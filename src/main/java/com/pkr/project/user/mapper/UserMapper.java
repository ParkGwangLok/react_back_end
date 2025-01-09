package com.pkr.project.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pkr.project.user.model.User;

@Mapper
public interface UserMapper {
//    @Select("SELECT * FROM TB_USER")
    List<User> findAllUsers(User user);

//    void insertUser(User user);
}
