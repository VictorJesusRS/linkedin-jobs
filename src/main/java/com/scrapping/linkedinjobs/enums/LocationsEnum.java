package com.scrapping.linkedinjobs.enums;

import lombok.Getter;

@Getter
public enum LocationsEnum {
    VE("Venezuela"),
    LATAM("91000011");

    private final String value;
    LocationsEnum(String value) {
        this.value = value;
    }
}
