package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.service.CustomizedService;

/**
 * @author clx 3/31/2018
 */
@RestController
@RequestMapping
public class CustomizedController {

	@Autowired
	private CustomizedService customizedService;

	@RequestMapping(value = "/customized", method = RequestMethod.GET)
	public String customizedStarter(String name) {
		return customizedService.customizedMessage(name);
	}
}
