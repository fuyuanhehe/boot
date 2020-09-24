package lambda;

public class t1 extends Thread {



    public static void main(String[] args) {
        t1 t = new t1();
          t.start();
          t.run();

     //   t1.run();  只是调用了一个普通方法，并没有启动另一个线程，程序还是会按照顺序执行相应的代码。

     //   t1.start();  则表示，重新开启一个线程，不必等待其他线程运行完，只要得到cup就可以运行该线程。
/*
        通过start(）方法，直接调用run()方法可以达到多线程的目的 通常，
                系统通过调用线程类的start()方法来启动一个线程，此时该线程处于就绪状态
                ，而非运行状态，这也就意味着这个线程可以被JVM来调度执行。在调度过程中，
                JVM会通过调用线程类的run()方法来完成试机的操作，当run()方法结束之后，此线程就会终止。
                如果直接调用线程类的run()方法，它就会被当做一个普通的函数调用，程序中任然只有主线程这一个线程。
                也就是说，star()方法可以异步地调用run()方法，但是直接调用run()方法确实同步的，
                因此也就不能达到多线程的目的。 run()和start()的区别可以用一句话概括：单独调用run()方法，
                是同步执行；通过start()调用run()，是异步执行


                run方法是Runnable接口中定义的，start方法是Thread类定义的。
                所有实现Runnable的接口的类都需要重写run方法，run方法是线程默认要执行的方法，
                有底层源码可知是绑定操作系统的，也是线程执行的入口。 start方法是Thread类的默认执行入口，
                Thread又是实现Runnable接口的。要使线程Thread启动起来，需要通过start方法，表示线程可执行状态，
                调用start方法后，则表示Thread开始执行，此时run变成了Thread的默认要执行普通方法  */

    }
}
