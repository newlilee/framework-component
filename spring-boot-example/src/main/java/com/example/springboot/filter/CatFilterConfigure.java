package com.example.springboot.filter;

import com.dianping.cat.servlet.CatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author clx 2019-08-02
 */
//@Component
public class CatFilterConfigure {
	@Bean
	public FilterRegistrationBean catFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		CatFilter filter = new CatFilter();
		registration.setFilter(filter);
		registration.addUrlPatterns("/*");
		registration.setName("cat-filter");
		registration.setOrder(1);
		return registration;
	}
}
