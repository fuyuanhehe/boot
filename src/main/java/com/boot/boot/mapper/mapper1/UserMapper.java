package com.boot.boot.mapper.mapper1;

import com.boot.boot.model.User;

import java.util.List;


public interface UserMapper {


    List<User> getUserByUsername(String username);


}