package com.boot.boot.service.impl;

import com.boot.boot.model.User;
import com.boot.boot.service.testService;
import org.springframework.stereotype.Service;

@Service
public class testService1 implements testService {
    @Override
    public void gg() {
        System.out.println("aaa");
    }

    @Override
    public User getUser(int id) {
        System.out.println("获取用户--->");
        User u = new User();
        u.setId(123);
        return u;
    }


}
