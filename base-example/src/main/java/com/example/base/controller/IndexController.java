package com.example.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author clx
 */
@Controller
public class IndexController {

	@GetMapping(path = "/index")
	@ResponseBody
	public String index() {
		return "Welcome to base-example!";
	}
}
