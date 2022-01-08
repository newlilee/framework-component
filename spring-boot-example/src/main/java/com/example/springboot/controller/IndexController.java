package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clx 2019-08-13
 */
@RestController
@RequestMapping(path = "/")
public class IndexController {

	@GetMapping(path = "/index")
	public String index() {
		return "Welcome!";
	}
}
