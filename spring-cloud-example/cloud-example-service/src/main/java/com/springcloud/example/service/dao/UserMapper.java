package com.springcloud.example.service.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.springcloud.example.service.entity.UserEntity;


public interface UserMapper {

    int save(UserEntity user);

    int deleteById(@Param("id") Integer id);

    int updateUser(UserEntity user);

    UserEntity queryById(@Param("id") Integer id);

    List<UserEntity> queryAll();
    
    @MapKey("id")
    Map<Integer, UserEntity> getById(@Param("id") Integer id);
}
