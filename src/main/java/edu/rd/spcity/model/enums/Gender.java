package edu.rd.spcity.model.enums;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("MALE"),
    FEMALE("FEMALE");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

}
