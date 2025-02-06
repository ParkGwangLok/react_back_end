package com.pkr.project.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.pkr.project.user.model.User;

@Mapper
public interface AuthMapper {
    @Select("SELECT * FROM TB_USER WHERE USER_ID = #{userId}")
    User findByUserId(String username);

}
