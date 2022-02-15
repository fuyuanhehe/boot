package com.boot.boot.mapper.mapper1;

import com.boot.boot.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    List<User> getUserByUsername(String username);


    int insertGood(@Param("id") int id,@Param("uid") int uid);

}