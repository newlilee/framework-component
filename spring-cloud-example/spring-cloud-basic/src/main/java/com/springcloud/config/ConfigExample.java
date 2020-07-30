package com.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clx 2017年3月6日 上午8:37:10
 */
@Configuration
@EnableAutoConfiguration
@RestController
public class ConfigExample {

	@Value("${config.name}")
	String name;

	@RequestMapping(value = "/")
	public String name() {
		return "Hello" + name;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigExample.class, args);
	}
}
