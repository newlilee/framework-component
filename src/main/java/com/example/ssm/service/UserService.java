package com.example.ssm.service;

import com.example.ssm.model.UserModel;

/**
 * @author clx 2018/9/15
 */
public interface UserService {

	/**
	 * add user
	 * 
	 * @param user
	 */
	void addUser(UserModel user);

	/**
	 * get user by id
	 * 
	 * @param id
	 * @return
	 */
	UserModel getUserById(Integer id);
}
