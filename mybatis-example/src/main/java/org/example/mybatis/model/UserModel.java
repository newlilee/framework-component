package org.example.mybatis.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author clx at 2016年3月22日 下午4:15:35
 */
public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	@JsonIgnore
	private Gender gender;
	private int age;
	private long birthday;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("gender")
	public int getGenderBy() {
		return gender.getGender();
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@JsonProperty("gender")
	public void setGenderBy(int gender) {
		this.gender = Gender.valueOf(gender);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getBirthday() {
		return birthday;
	}

	public void setBirthday(long birthday) {
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
		return "UserModel [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", birthday="
				+ birthday + ", address=" + address + "]";
	}
}
