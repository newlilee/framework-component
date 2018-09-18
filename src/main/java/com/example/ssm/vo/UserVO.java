package com.example.ssm.vo;

import java.io.Serializable;

import com.example.ssm.model.UserModel;

/**
 * @author clx 2018/9/15
 */
public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * name
	 */
	private String name;
	/**
	 * gender
	 */
	private Integer gender;
	/**
	 * age
	 */
	private Integer age;
	/**
	 * birthday
	 */
	private Long birthday;
	/**
	 * address
	 */
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getBirthday() {
		return birthday;
	}

	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserVO{" + "name='" + name + '\'' + ", gender=" + gender + ", age=" + age + ", birthday=" + birthday
				+ ", address='" + address + '\'' + '}';
	}

	/**
	 * UserVO to UserModel
	 * 
	 * @param user
	 * @return
	 */
	public UserModel to(UserVO user) {
		UserModel userModel = new UserModel();
		userModel.setName(user.getName());
		userModel.setAge(user.getAge());
		userModel.setGenderBy(user.getGender());
		userModel.setBirthday(user.getBirthday());
		userModel.setAddress(user.getAddress());
		return userModel;
	}
}
