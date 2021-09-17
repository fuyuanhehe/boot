package com.boot.boot.config;

import java.util.concurrent.*;


public class ThreadPool {
    private static ExecutorService pool = null;

   /* corePoolSize:指定了线程池中的线程数量，它的数量决定了添加的任务是开辟新的线程去执行，还是放到workQueue任务队列中去；
    maximumPoolSize:指定了线程池中的最大线程数量，这个参数会根据你使用的workQueue任务队列的类型，决定线程池会开辟的最大线程数量；
    keepAliveTime:当线程池中空闲线程数量超过corePoolSize时，多余的线程会在多长时间内被销毁；
    unit:keepAliveTime的单位
    workQueue:任务队列，被添加到线程池中，但尚未被执行的任务；它一般分为直接提交队列、有界任务队列、无界任务队列、优先任务队列几种；
    threadFactory:线程工厂，用于创建线程，一般用默认即可；
    handler:拒绝策略；当任务太多来不及处理时，如何拒绝任务；*/


    public static void main(String[] args) {
        //maximumPoolSize设置为2 ，拒绝策略为AbortPolic策略，直接抛出异常

        /* 直接提交队列
        使用SynchronousQueue队列，提交的任务不会被保存，总是会马上提交执行。
        如果用于执行任务的线程数量小于maximumPoolSize，则尝试创建新的进程，
        如果达到maximumPoolSize设置的最大值，则根据你设置的handler执行拒绝策略。
        因此这种方式你提交的任务不会被缓存起来，而是会被马上执行，在这种情况下，
        你需要对你程序的并发量有个准确的评估，才能设置合适的maximumPoolSize数量，
        否则很容易就会执行拒绝策略；
        */
        //   pool = new ThreadPoolExecutor(1, 3, 1000, TimeUnit.MILLISECONDS, new SynchronousQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // 有界任务队列
        pool = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
       /* 使用ArrayBlockingQueue有界任务队列，若有新的任务需要执行时，线程池会创建新的线程，
        直到创建的线程数量达到corePoolSize时，则会将新的任务加入到等待队列中。若等待队列已满，
        即超过ArrayBlockingQueue初始化的容量，则继续创建线程，
        直到线程数量达到maximumPoolSize设置的最大线程数量，若大于maximumPoolSize，则执行拒绝策略。
        在这种情况下，线程数量的上限与有界任务队列的状态有直接关系，
        如果有界队列初始容量较大或者没有达到超负荷的状态，线程数将一直维持在corePoolSize以下，
        反之当任务队列已满时，则会以maximumPoolSize为最大线程数上限。*/

       /*无界
       LinkedBlockingQueue
       使用无界任务队列，线程池的任务队列可以无限制的添加新的任务，
       而线程池创建的最大线程数量就是你corePoolSize设置的数量，
       也就是说在这种情况下maximumPoolSize这个参数是无效的，
       哪怕你的任务队列中缓存了很多未执行的任务，当线程池的线程数达到corePoolSize后，就不会再增加了；
       若后续有新的任务加入，则直接进入队列等待，当使用这种任务队列模式时，
       一定要注意你任务提交与处理之间的协调与控制，不然会出现队列中的任务由于无法及时处理导致一直增长，
       直到最后资源耗尽的问题。
       */

        pool.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(((ThreadPoolExecutor) pool).getMaximumPoolSize());
        System.out.println(((ThreadPoolExecutor) pool).getCorePoolSize());

        //正在运行线程大小
        System.out.println(((ThreadPoolExecutor) pool).getActiveCount());
        System.out.println(((ThreadPoolExecutor) pool).getPoolSize());


        /*
          //优先任务队列 implements Runnable,Comparable<ThreadTask>
        PriorityBlockingQueue
        * */


    /*    1、AbortPolicy策略：该策略会直接抛出异常，阻止系统正常工作；

        2、CallerRunsPolicy策略：如果线程池的线程数量达到上限，
        该策略会把任务队列中的任务放在调用者线程当中运行；

        3、DiscardOledestPolicy策略：该策略会丢弃任务队列中最老的一个任务，
        也就是当前任务队列中最先被添加进去的，马上要被执行的那个任务，并尝试再次提交；

        4、DiscardPolicy策略：该策略会默默丢弃无法处理的任务，不予任何处理。当然使用此策略，业务场景中需允许任务的丢失；
        */

    }
}

class ThreadTask implements Runnable {

    public ThreadTask() {

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(1);
    }

}


/*
class c{

    private void test4(){
        //自定义拒绝策略
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString()+"执行了拒绝策略");

            }
        });
    }

}
*/

