package com.example.ssm.spring.bean.scope;

import java.util.HashMap;
import java.util.Map;

/**
 * @author clx at 2017年5月10日 上午11:24:41
 */
public class BeanDefinitionRegister {

	/**
	 * bean cache pool
	 */
	private final Map<String, BeanDefinition> DEFINITIONS = new HashMap<>();

	public void registerBeanDefinition(String beanName, BeanDefinition bd) {
		// not allowed replaced
		if (DEFINITIONS.containsKey(bd.getId())) {
			throw new RuntimeException("[" + bd.getId() + "] existed!");
		}
		DEFINITIONS.put(bd.getId(), bd);
	}

	public BeanDefinition getBeanDefinition(String beanName) {
		return DEFINITIONS.get(beanName);
	}

	public boolean containsBeanDefinition(String beanName) {
		return DEFINITIONS.containsKey(beanName);
	}

}
