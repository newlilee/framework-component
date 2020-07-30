package com.example.ssm.spring.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author chenlixin at 2017年1月16日 下午6:19:13
 */
public class CollectionBean {

    private List<String> hobbies;
    private List<UserBean> users;
    private Set<String> grade;
    private Map<String, String> map;
    private Properties properties;
    private String[] array;
    private String[][] arrays;

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    public Set<String> getGrade() {
        return grade;
    }

    public void setGrade(Set<String> grade) {
        this.grade = grade;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public String[][] getArrays() {
        return arrays;
    }

    public void setArrays(String[][] arrays) {
        this.arrays = arrays;
    }

}
