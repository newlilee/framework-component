package com.springcloud.example.service.entity;

/**
 * @author chenlixin at 2016年3月22日 下午4:15:35
 */
public enum Gender {

    male(1), female(2);

    final int gender;

    private Gender(int gender) {
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
        throw new IllegalStateException(
                String.format("unknow gender [%s]", gender));
    }
}
