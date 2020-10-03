package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author clx
 */
@Import(GraphqlWebMvcConfigurer.class)
@SpringBootApplication
public class GraphqlApplication {
	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}
}
