package com.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum CheckResultEnum {
    UNQUALIFIED("0", "不合格"),
    QUALIFIED("1", "合格");

    @Getter
    private final String code;
    private final String description;

    CheckResultEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    @JsonCreator
    public static CheckResultEnum fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        for (CheckResultEnum result : CheckResultEnum.values()) {
            if (result.getCode().equals(value) || result.getDescription().equals(value)) {
                return result;
            }
        }
        return null;
    }

    public static CheckResultEnum getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (CheckResultEnum result : CheckResultEnum.values()) {
            if (result.getCode().equals(code)) {
                return result;
            }
        }
        return null;
    }
} 