package com.example.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.springboot.CustomizedProperties;
import com.example.springboot.service.CustomizedService;

/**
 * @author clx 3/31/2018
 */
public class CustomizedServiceImpl implements CustomizedService {

	@Autowired
	private CustomizedProperties customizedProperties;

	@Override
	public String customizedMessage(String name) {
		return name + customizedProperties.getMessage();
	}
}
