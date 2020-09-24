package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWaitNotifyThread3 {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();// 线程 等待 唤醒

    static class WaitThreadDemo extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("w1 start" + System.currentTimeMillis());
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("w1 end,time=" + System.currentTimeMillis());
            }
        }
    }
    static class NotifyThreadDemo extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println("w2-start-time" + System.currentTimeMillis());
            condition.signal(); // 唤醒前面等待的线程
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("w2-end" + System.currentTimeMillis());
            }
        }
    }

    public static void main(String[] args) {
        WaitThreadDemo waitThreadDemo = new WaitThreadDemo();
        NotifyThreadDemo notifyThreadDemo = new NotifyThreadDemo();
        waitThreadDemo.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThreadDemo.start();
    }
}