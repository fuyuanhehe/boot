package com.boot.boot.service.impl;

import com.boot.boot.model.User;
import com.boot.boot.service.testService;
import org.springframework.stereotype.Service;

@Service
public class testServicebb implements testService {

    @Override
    public void gg() {
        System.out.println("bbb");
    }

    @Override
    public User getUser(int id) {
        return null;
    }
}
