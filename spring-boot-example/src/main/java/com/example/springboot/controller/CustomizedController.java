package com.example.springboot.controller;

import com.example.springboot.service.CustomizedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clx 3/31/2018
 */
@RestController
@RequestMapping(path = "/")
public class CustomizedController {

	private CustomizedService customizedService;

	@Autowired
	public CustomizedController(CustomizedService customizedService) {
		this.customizedService = customizedService;
	}

	@GetMapping(path = "customized")
	public String customizedStarter(String name) {
		return customizedService.customizedMessage(name);
	}
}
