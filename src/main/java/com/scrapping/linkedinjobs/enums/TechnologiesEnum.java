package com.scrapping.linkedinjobs.enums;

import lombok.Getter;

@Getter
public enum TechnologiesEnum {
    JAVA("Java"),
    PHP("PHP"),
    LARAVEL("Laravel"),
    SPRING("Spring"),
    REACT("React"),
    REACT_NATIVE("React Native");

    private final String value;
    TechnologiesEnum(String value) {
        this.value = value;
    }
}
