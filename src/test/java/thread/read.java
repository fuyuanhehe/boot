package thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class read {   // 读取锁 可同时读
                      // 写锁 不能同时
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();



    public static void main(String[] args)  {
        final read test = new read();

        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

    }

    public void get(Thread thread) {
        rwl.readLock().lock();
      //  rwl.writeLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
          //  rwl.writeLock().unlock();
            rwl.readLock().unlock();

        }
    }
}