package com.example.springboot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author clx 3/31/2018
 */
@ConfigurationProperties(prefix = "customized")
public class CustomizedProperties {

	/**
	 * message
	 */
	private String message = "default!";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
