package com.example.springboot.configuration;

import com.example.springboot.service.impl.CustomizedServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author clx 3/31/2018
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties({CustomizedProperties.class})
@Import(CustomizedServiceImpl.class)
public class CustomizedAutoConfiguration {

}
