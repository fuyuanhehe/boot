package com.boot.boot.redisson;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class BlogApplicationTests {

    @Resource
    private RedissonClient redissonClient;

    @RequestMapping("RedissionTest")
    public void RedissionTest() {
        RBucket<String> key = redissonClient.getBucket("newday");
        key.set("新的数据");
        System.out.println("获取到新存入的数据：" + key.get());
    }


    // 加锁
    @RequestMapping("lock")
    public Boolean lock(String lockName) {
        RLock lock = null;
        try {
            lock = redissonClient.getLock(lockName);

            boolean res = lock.tryLock(1000 * 5, 1000 * 60, TimeUnit.MILLISECONDS);

            return res;

        } catch (Exception e) {
            log.error("DistributedRedisLock lock [{}] Exception:", lockName, e);
            if (lock != null) {
                lock.unlock();
            }
            return false;
        }
    }


}
