package thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockInterruptDemo {

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    //  中断锁
    static class ThreadDemo extends Thread {
        int i = 0;
        public ThreadDemo(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println(i);
                if (i == 1) {
                    lock1.lockInterruptibly();// 此获取锁可以中断
                    try {
                        System.out.println("随眠" + Thread.currentThread().getName());
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        System.out.println("t1关闭~~");
                        lock1.unlock();
                    }
                    System.out.println("随眠结束" +Thread.currentThread().getName());
                } else {

                    try {
                        lock2.lockInterruptibly();
                        System.out.println(Thread.currentThread().getName()+ "睡眠");
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        System.out.println("t2关闭~~");
                        lock2.unlock();
                    }


                }
                System.out.println(Thread.currentThread().getName() + "完成任务");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception  {
        Thread t1 = new Thread(new ThreadDemo(1),"t1");
        Thread t2 = new Thread(new ThreadDemo(2),"t2");
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("t1 中断");

        t1.interrupt();    //  中断锁


    }
}