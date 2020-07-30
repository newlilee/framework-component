package org.example.spring.di.navigation;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author chenlixin at 2017年1月19日 下午3:15:43
 */
public class NavigationSecond {

    @Autowired
	private NavigationFirst navigationFirst;
	private List<NavigationFirst> list;
	private Properties properties;
	private NavigationFirst[] array = new NavigationFirst[1];
	private Map<String, NavigationFirst> map;

	public NavigationFirst getNavigationFirst() {
		return navigationFirst;
	}

	public void setNavigationFirst(NavigationFirst navigationFirst) {
		this.navigationFirst = navigationFirst;
	}

	public List<NavigationFirst> getList() {
		return list;
	}

	public void setList(List<NavigationFirst> list) {
		this.list = list;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public NavigationFirst[] getArray() {
		return array;
	}

	public void setArray(NavigationFirst[] array) {
		this.array = array;
	}

	public Map<String, NavigationFirst> getMap() {
		return map;
	}

	public void setMap(Map<String, NavigationFirst> map) {
		this.map = map;
	}
}
