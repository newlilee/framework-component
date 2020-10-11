package com.example.ssm.enums;

/**
 * gender enum
 *
 * @author clx
 */
public enum GenderEnum {
	/**
	 * male
	 */
	MALE(1),
	/**
	 * female
	 */
	FEMALE(2);

	final int gender;

	GenderEnum(int gender) {
		this.gender = gender;
	}

	public int getGender() {
		return gender;
	}

	public static GenderEnum valueOf(int gender) {
		for (GenderEnum pGender : GenderEnum.values()) {
			if (pGender.getGender() == gender) {
				return pGender;
			}
		}
		throw new IllegalStateException(String.format("unknown gender [%s]", gender));
	}
}
