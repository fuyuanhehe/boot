package CountDownLatchTest2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/5 1:42
 * @mark: show me the code , change the world
 */
public class CountDownLatchTest2 {


    public static void main(String[] args) throws InterruptedException {

        List list = Collections.synchronizedList(new ArrayList<>());

        // 2 为线程个数
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " --执行结束");
                list.add("A");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();




        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
                list.add("B");
                System.out.println(Thread.currentThread().getName() + "**执行结束");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        countDownLatch.await();
        System.out.println("主线业务继续执行");
        System.out.println(list);
    }


}

