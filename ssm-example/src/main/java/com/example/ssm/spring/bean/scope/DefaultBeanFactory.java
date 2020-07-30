package com.example.ssm.spring.bean.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;

/**
 * @author clx at 2017年5月10日 下午3:25:23
 */
public class DefaultBeanFactory {

	private static final Logger logger = LoggerFactory.getLogger(DefaultBeanFactory.class);

	private BeanDefinitionRegister DEFINITIONS = new BeanDefinitionRegister();
	private final SingletonBeanRegistry SINGLETON = new SingletonBeanRegister();

	public Object getBean(String beanName) {
		if (!DEFINITIONS.containsBeanDefinition(beanName)) {
			throw new RuntimeException(beanName + "not exist!");
		}

		BeanDefinition bd = DEFINITIONS.getBeanDefinition(beanName);
		if (BeanDefinition.SCOPE_SINGLETON == bd.getScope()) {
			if (SINGLETON.containsSingleton(beanName)) {
				return SINGLETON.getSingleton(beanName);
			}
			SINGLETON.registerSingleton(beanName, this.createBean(bd));
			return SINGLETON.getSingleton(beanName);
		}

		if (BeanDefinition.SCOPE_PROTOTYPE == bd.getScope()) {
			return this.createBean(bd);
		}

		// define bean error
		throw new RuntimeException("Define bean error!");
	}

	public void registerBeanDefinition(BeanDefinition bd) {
		DEFINITIONS.registerBeanDefinition(bd.getId(), bd);
	}

	private Object createBean(BeanDefinition bd) {
		try {
			Class clazz = Class.forName(bd.getClazz());
			return clazz.getConstructor().newInstance();
		} catch (ClassNotFoundException e) {
			logger.error("class not found: className={}", bd.getId());
			throw new RuntimeException("class not found:" + bd.getId());
		} catch (Exception ex) {
			logger.error("create bean fail:className={}", bd.getId());
			throw new RuntimeException("create bean fail!");
		}
	}
}
