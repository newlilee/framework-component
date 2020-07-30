package com.example.ssm.spring.bean.scope;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

/**
 * @author clx 2017年5月9日 下午10:59:07
 */
public class SingletonBeanRegister implements SingletonBeanRegistry {

	private final Map<String, Object> BEANS = new HashMap<>();

	@Override
	public void registerSingleton(String beanName, Object bean) {
		if (BEANS.containsKey(beanName)) {
			throw new RuntimeException("[" + beanName + "] existed");
		}
		BEANS.put(beanName, bean);
	}

	@Override
	public Object getSingleton(String beanName) {
		return BEANS.get(beanName);
	}

	@Override
	public boolean containsSingleton(String beanName) {
		return BEANS.containsKey(beanName);
	}

	@Override
	public String[] getSingletonNames() {
		return BEANS.keySet().toArray(new String[0]);
	}

	@Override
	public int getSingletonCount() {
		return BEANS.size();
	}

	@Override
	public Object getSingletonMutex() {
		return null;
	}
}
