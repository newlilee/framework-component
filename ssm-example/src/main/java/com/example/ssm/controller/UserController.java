package com.example.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ssm.model.UserModel;
import com.example.ssm.service.UserService;
import com.example.ssm.vo.UserVO;

/**
 * @author clx 2018/9/15
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUser(@ModelAttribute UserVO user) {
		if (user == null) {
			throw new IllegalArgumentException("param error.");
		}
		userService.addUser(user.to(user));
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public UserVO getUserById(@PathVariable Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("param error.");
		}
		UserModel user = userService.getUserById(id);
		if (user == null) {
			throw new IllegalStateException("User not exist.");
		}
		UserVO userVO = new UserVO();
		userVO.setName(user.getName());
		userVO.setAge(user.getAge());
		userVO.setGender(user.getGenderBy());
		userVO.setBirthday(user.getBirthday());
		userVO.setAddress(user.getAddress());
		return userVO;
	}
}
