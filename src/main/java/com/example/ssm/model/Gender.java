package com.example.ssm.model;

/**
 * gender
 *
 * @author clx
 */
public enum Gender {
	/**
	 * male
	 */
	MALE(1),
	/**
	 * female
	 */
	FEMALE(2);

	final int gender;

	Gender(int gender) {
		this.gender = gender;
	}

	public int getGender() {
		return gender;
	}

	public static Gender valueOf(int gender) {
		for (Gender pGender : Gender.values()) {
			if (pGender.getGender() == gender) {
				return pGender;
			}
		}
		throw new IllegalStateException(String.format("unknown gender [%s]", gender));
	}
}
