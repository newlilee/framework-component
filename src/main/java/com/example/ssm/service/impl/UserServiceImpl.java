package com.example.ssm.service.impl;

import com.example.ssm.dao.UserDao;
import com.example.ssm.model.UserModel;
import com.example.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author clx 2018/9/15
 */
@Service("ssm-UserService")
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private UserDao userDao;

	@Override
	public void addUser(UserModel user) {
		int retVal = userDao.save(user);
		if (retVal != 1) {
			LOGGER.error("UserService:add user failed. user={}", user);
		}
	}

	@Override
	public UserModel getUserById(Integer id) {
		UserModel user = userDao.queryById(id);
		if (user == null) {
			LOGGER.warn("UserService:user not exist. id={}", id);
			return null;
		}
		return user;
	}
}
