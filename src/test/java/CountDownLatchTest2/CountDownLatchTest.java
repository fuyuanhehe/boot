package CountDownLatchTest2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/5 1:42
 * @mark: show me the code , change the world
 */
public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {

        int cnt = 10;
        CountDownLatch countDownLatch = new CountDownLatch(cnt);

        List list = new ArrayList();
        // 模拟10个并发干饭
        for (int i = 0; i < 10; i++) {

            // 每个线程调用一次，cnt每次减一，直到为0，就是干饭信号
            System.out.println("准备干饭，个数:" + (countDownLatch.getCount()));
            countDownLatch.countDown();


            new Thread(() -> {
                try {
                    // 干饭人准备完毕……干饭人都阻塞在这，等待号令(cnt=0)
                    countDownLatch.await();
                    System.out.println("编号:" + Thread.currentThread().getName() + " 开始干饭...." + System.currentTimeMillis());
                    list.add("test");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }

            System.out.println(list.size());

    }

}

