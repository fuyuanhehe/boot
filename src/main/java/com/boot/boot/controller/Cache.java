package com.boot.boot.controller;

import com.boot.boot.mapper.mapper1.UserMapper;
import com.boot.boot.mapper.mapper2.UserMapper2;
import com.boot.boot.model.User;
import com.boot.boot.redis.RedisServiceImpl;
import com.boot.boot.service.testService;
import com.boot.boot.service.testServiceFeig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.concurrent.Executor;

@RestController
@Slf4j
public class Cache {

    @Autowired
    @Qualifier("testService1")
    testService testService;
    @Autowired
    testService testService1;

    @Autowired
    testService testServicebb;
    @Resource
    UserMapper userMapper;

    @Autowired
    RedisServiceImpl<Object> redisService;
    @Autowired
    UserMapper2 userMapper2;

    @Autowired
    @Qualifier("asyncServiceExecutor")
    private Executor executor;

    @Autowired
    private testServiceFeig testServiceFeig;


    @RequestMapping("/testFeignClient")
    public Object testFeignClient(@RequestBody String str) {
        log.info(str);
        return testServiceFeig.hello(str);
    }


    @RequestMapping("/getUser")
    public Object getUser() {
        return userMapper.getUserByUsername(null);
    }

    @RequestMapping("/getUser2")
    public Object getUser2() {
        return userMapper2.getCall();
    }

    @GetMapping("/async")
    public void async() {

        executor.execute(
                () ->
                {

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {

                    }

                    log.info("11111111111111111111111111111");

                }
        );

    }

    /**
     * allEntries是否移除所有缓存条目。
     * beforeInvocation：在方法调用前还是调用后完成移除操作。true/false
     *//*
    @RequestMapping(value = "u3")
    @CacheEvict(value = "user", key = "#id", condition = "#id > 11", beforeInvocation = true)
    public int test3(int id) {
        System.out.println(a);

        return id;
    }
*/
    @RequestMapping("set")
    public void set(String key, String value) {
        redisService.set(key, value);

    }

    @RequestMapping("set2")
    public void set2(String key, String value, long time) {
        redisService.set(key, value, time);

    }

    @RequestMapping("get")
    public Object get(String key) {
        return redisService.get(key);
    }

    /**
     * 当调用这个方法的时候，会从一个名叫 scf_company的缓存中查询，
     * 如果没有，则执行实际的方法（即查询数据库），并将执行的结果存入缓存中，
     * 否则返回缓存中的对象。这里的缓存中的 key 就是参数 id，value 就是 CompanyVo 对象。
     *//*
    @RequestMapping(value = "u")
    @Cacheable(value = "user", key = "#id", unless = "#result == null", condition = "#id > 11")
    public User test(int id) {
        a = 11;

        System.out.println(a);
        return testService.getUser(id);
    }

    @RequestMapping(value = "u2")
    @CachePut(value = "user", key = "#id", unless = "#result == null", condition = "#id > 11")
    public User test2(int id) {
        a = 12;

        System.out.println(a);
        return testService.getUser(id);
    }

    */


}
