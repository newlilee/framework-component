package com.springcloud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author clx 2017年3月5日 下午10:29:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryClientExample {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryClientExample.class, args);
	}
}
