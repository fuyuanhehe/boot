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
        RBucket<String> key = redissonClient.getBucket("fukey");
        key.set("新的数据");
        System.out.println("获取到新存入的数据：" + key.get());
    }

    //锁住10S  尝试2s
    @RequestMapping("lock")
    public boolean lock(String lockName) {
        RLock lock = null;
        try {
            lock = redissonClient.getLock(lockName);
            return lock.tryLock(2000, 10000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.error(" lock [{}] Exception:{}", lockName, e);
            return false;
        }
    }

    // 锁住30s
    @RequestMapping("lock2")
    public boolean lock2(String lockName) throws Exception {
        RLock lock = null;
        try {
            lock = redissonClient.getLock(lockName);
            lock.lock(30000, TimeUnit.MILLISECONDS);
            return true;
        } catch (Exception e) {
            log.error(" lock [{}] Exception{}:", lockName, e);
            return false;
        } finally {
            log.info("lock2结束");
        }

    }


    //一直锁住 第二个线程尝试5s
    @RequestMapping("lock3")
    public boolean lock3(String lockName) {
        RLock lock = null;
        try {
            lock = redissonClient.getLock(lockName);
            return lock.tryLock(5000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.error(" lock [{}] Exception:{}", lockName, e);
            return false;
        }
    }


}
