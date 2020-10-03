package com.example.controller;

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
		return "Welcome to GraphQL!";
	}

	@GetMapping(path = "/api/i")
	public String graphiql() {
		return "graphiql";
	}

	@GetMapping(path = "/api")
	public String playground() {
		return "playground";
	}

	@GetMapping(path = "/api/v")
	public String voyager() {
		return "voyager";
	}
}
