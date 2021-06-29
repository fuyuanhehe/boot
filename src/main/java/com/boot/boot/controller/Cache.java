package com.boot.boot.controller;

import com.boot.boot.mapper.UserMapper;
import com.boot.boot.model.User;
import com.boot.boot.service.testService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping

public class Cache {


    Logger logger = LoggerFactory.getLogger(this.getClass());

   /* @Autowired
    @Qualifier("testService1")
    testService testService;*/

    @Autowired
    testService testService1;

    @Autowired
    testService testServicebb;

    @Resource
    UserMapper userMapper;

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
    // https://github.com/modouxiansheng/Doraemon/tree/master/springdemo
















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
    @RequestMapping("/testUser")
    public Object testUser(@RequestBody User u) {
        System.out.print(u);
        return u;
    }


}
