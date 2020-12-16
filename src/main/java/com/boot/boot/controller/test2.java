package com.boot.boot.controller;


import com.boot.boot.model.User;
import com.boot.boot.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
@RestController
@RequestMapping(value = "/test2")
public class test2 {


    @Autowired
    private ApplicationContext applicationContext;

    @Resource
    private UserService userService;


 /*   @RequestMapping(value = "/getPage")
    public PageInfo<User> test(User user,int pageSize,int pageNum) {
        PageInfo<User> result = userService.findPage(pageSize,pageNum);
        return result;
        //  au2  au2 = applicationContext.getBean(au2.class);
        //  au2.add();

    }*/

    @RequestMapping(value = "/getPage2")
    public PageInfo<User> test2(@RequestBody Map map) {
        PageInfo<User> result = userService.findPage(map);
        return result;
    }


    @RequestMapping(value = "/t")
    public String t() {
        String s = null;
        try {
            int a = 1 / 0;
        } catch (RuntimeException e) {
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
        }
        return s;
    }


}
