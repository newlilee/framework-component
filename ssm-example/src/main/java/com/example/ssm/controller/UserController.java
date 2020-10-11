package com.example.ssm.controller;

import com.example.ssm.model.UserModel;
import com.example.ssm.service.UserService;
import com.example.ssm.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author clx 2018/9/15
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/add")
	public void addUser(@ModelAttribute UserVO user) {
		if (Objects.isNull(user)) {
			throw new IllegalArgumentException("param error.");
		}
		this.userService.addUser(user.voFormat(user));
	}

	@GetMapping(value = "/get/{id}")
	public UserVO getUserById(@PathVariable Integer id) {
		if (Objects.isNull(id)) {
			throw new IllegalArgumentException("param error.");
		}
		UserModel user = this.userService.getUserById(id);
		if (Objects.isNull(user)) {
			throw new IllegalStateException("User not exist.");
		}
		return new UserVO().toVo(user);
	}
}
