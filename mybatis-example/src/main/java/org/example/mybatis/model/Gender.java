package org.example.mybatis.model;

/**
 * @author clx at 2016年3月22日 下午4:15:35
 */
public enum Gender {
	/**
	 * male
	 */
	male(1),
	/**
	 * female
	 */
	female(2);

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
		throw new IllegalStateException(String.format("Unknown gender [%s]", gender));
	}
}
