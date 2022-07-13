package com.boot.boot.controller;


import com.boot.boot.model.user;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class test {


    @Autowired
    private test2Service test2Service;
    @Autowired
    private com.boot.boot.mapper.userMapper userMapper;


    @RequestMapping("testUser")
    // @Transactional(rollbackFor = Exception.class)
    public Object test2() {

        user user = new user();
        user.setUsername("99299");
        userMapper.insertSelective(user);
        test1(2);

        return "ok";
    }

    //  @Transactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void test1(int i) {

        user user = new user();
        user.setUsername("test" + i);
        userMapper.insertSelective(user);


        if (i == 2) {
            int a = 10 / 0;
        }

    }


}
