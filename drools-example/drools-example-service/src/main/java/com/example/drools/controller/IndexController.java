package com.example.drools.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clx
 */
@RestController
public class IndexController {

	@GetMapping(path = "/index", produces = MediaType.APPLICATION_JSON_VALUE)
	public String index() {
		return "Welcome to drools.";
	}
}
