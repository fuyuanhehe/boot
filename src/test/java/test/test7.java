package test;


import com.boot.boot.App;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@TestPropertySource("classpath:application.yml")
@Slf4j
public class test7 {


    public static void main(String[] args) {
        // acquire 该方法会被阻塞直到获取到请求。如果存在等待的情况的话，告诉调用者获取到该请求所需要的睡眠时间。
        // tryAcquire 获取许可如果该许可可以在不超过timeout的时间内获取得到的话，或者如果无法在timeout 过期之前获取得到许可的话，那么立即返回false

        testNoRateLimiter();
        testWithRateLimiter();
    }

    public static void testNoRateLimiter() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
     //       System.out.println("call execute.." + i); // 未限流总耗时:3
        }
        Long end = System.currentTimeMillis();
        System.out.println("未限流总耗时:" + (end - start)); // 进行限流后耗时:9912
    }

    public static void testWithRateLimiter() {
        Long start = System.currentTimeMillis();
        // 每秒不超过10个任务被提交
        RateLimiter limiter = RateLimiter.create(20);
        for (int i = 0; i < 100; i++) {
            // 请求RateLimiter, 超过permits会被阻塞，然后等待获取令牌
            limiter.acquire();
            System.out.println("call execute---.." + i);
        }
        Long end = System.currentTimeMillis();
        System.out.println("进行限流后耗时---:" + (end - start));
    }


}











