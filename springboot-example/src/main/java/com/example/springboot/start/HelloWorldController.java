package com.example.springboot.start;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clx 3/30/2018/
 */
@RestController
@RequestMapping
public class HelloWorldController {

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String test(String project) {
		return "HelloWorld! " + project;
	}
}
