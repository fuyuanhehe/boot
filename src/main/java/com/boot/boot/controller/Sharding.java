/*
package com.boot.boot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.boot.mapper.mapper1.UserMapper;
import com.boot.boot.model.User;
import com.boot.boot.sharding.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sharding {


    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserMappers userMappers;
    @Autowired
    MyDictMapper dictMapper;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("good")
    private void test(long id, long uid) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setUserId(uid);
        goodsMapper.insert(goods);
    }

    @RequestMapping("q")
    private Object q(long id) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return goodsMapper.selectOne(queryWrapper);

    }

    @RequestMapping("u")
    private void u(int id, String uid) {
        User goods = new User();
        goods.setId(id);
        goods.setUsername(uid);
        userMappers.insert(goods);

    }

    @RequestMapping("d")
    private void d(int id, String uid) {
        MyDict goods = new MyDict();
        goods.setId(id);
        goods.setName(uid);
        dictMapper.insert(goods);
    }


    @RequestMapping("i")
    private void testi(int id, int uid) {
        userMapper.insertGood(id, uid);
    }


}
*/
