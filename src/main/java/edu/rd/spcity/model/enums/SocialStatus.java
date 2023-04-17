package edu.rd.spcity.model.enums;

import lombok.Getter;

@Getter
public enum SocialStatus {
    WORKING("Работающий"),
    PRESCHOOLER("Дошкольник"),
    STUDENT("Учащийся"),
    UNEMPLOYED("Безработный"),
    REFUGEE("Беженец"),
    TEMPORARILY_INACTIVE("Временно безработный"),
    RETIRED_PEOPLE("Пенсионер");

    private final String name;

    SocialStatus(String name) {
        this.name = name;
    }
}
