package com.springcloud.example.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcloud.example.service.dao.UserMapper;
import com.springcloud.example.service.entity.UserEntity;

@Service("cloud-service-UserMapper")
@Transactional
public class UserMapperImpl implements UserMapper {

    @Autowired
    UserMapper mapper;
    
    @Override
    public int save(UserEntity user) {
        return mapper.save(user);
    }

    @Override
    public int deleteById(Integer id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUser(UserEntity user) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public UserEntity queryById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserEntity> queryAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Integer, UserEntity> getById(Integer id) {
        return mapper.getById(id);
    }

}
