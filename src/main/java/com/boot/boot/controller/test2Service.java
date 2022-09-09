package com.boot.boot.controller;


import com.boot.boot.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class test2Service {


    @Autowired
    private com.boot.boot.mapper.userMapper userMapper;


   // @Transactional(rollbackFor = Exception.class)


    //开启新事务 不受上级事务影响
     @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void test1(int i) {

        user user = new user();
        user.setUsername("test" + i);
        userMapper.insertSelective(user);


    }

}
