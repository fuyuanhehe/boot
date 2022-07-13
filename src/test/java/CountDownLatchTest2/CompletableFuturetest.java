package CountDownLatchTest2;

import java.util.concurrent.CompletableFuture;

public class CompletableFuturetest {


    public static void main(String[] args) throws Exception {

        //CompletableFuture创建线程有2种方式：supplyAsync（有返回值）和：runAsync（无返回值）。
     /*       CompletableFuture.runAsync(
                    () -> doA()
            );*/

        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> doA());
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> doB());
        CompletableFuture.allOf(futureA, futureB); // 等a b 两个任务都执行完成

           String c = doC(futureA.get(), futureB.get());
//

      //  futureA.join();
     //   futureB.join();
        //   String c = doC(futureA.join(), futureB.join());

        //     doC();
    }


    public static String doA() {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doA");
        return "A";
    }

    public static String doB() {
        System.out.println("doB");
        return "B";
    }

    public static String doC(String a, String b) {
        System.out.println("CCCC");
        return "CCCC";
    }


}
