package com.example.netty.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clx
 */
@Slf4j
@RestController
public class IndexController {

	@GetMapping(path = "/index", produces = MediaType.APPLICATION_JSON_VALUE)
	public String index() {
		log.info("Welcome to Project example.");
		return "Welcome to Project example.";
	}
}
