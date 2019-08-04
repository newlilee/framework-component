package com.example.ssm.spring.resource;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @author clx at 2017年5月24日 下午5:42:00
 */
public class ResourceClasspathPrefix {

	@Test
	public void testClasspathPrefix() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath:META-INF/INDEX.LIST");
		Assert.assertEquals(1, resources.length);
		resources = resolver.getResources("classpath:META-INF/*.LIST");
		Assert.assertTrue(resources.length == 1);
	}

	@Test
	public void testClasspath() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath*:META-INF/INDEX.LIST");
		Assert.assertTrue(resources.length > 1);
		resources = resolver.getResources("classpath*:META-INF/*.LIST");
		Assert.assertTrue(resources.length > 1);
	}
}
