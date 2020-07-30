package org.example.spring.bean.scope;

/**
 * @author clx at 2017年5月10日 上午11:18:34
 */
public class BeanDefinition {

	/**
	 * singleton
	 */
	public static final int SCOPE_SINGLETON = 0;
	/**
	 * prototype
	 */
	public static final int SCOPE_PROTOTYPE = 1;

	/**
	 * unique id
	 */
	private String id;

	private String clazz;

	private int scope = SCOPE_SINGLETON;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}
}
