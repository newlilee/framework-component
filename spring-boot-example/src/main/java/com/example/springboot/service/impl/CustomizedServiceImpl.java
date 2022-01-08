package com.example.springboot.service.impl;

import com.example.springboot.configuration.CustomizedProperties;
import com.example.springboot.service.CustomizedService;
import org.springframework.beans.factory.annotation.Autowired;

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
