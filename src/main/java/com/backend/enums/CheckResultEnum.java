package com.backend.enums;

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

    public static CheckResultEnum getByCode(String code) {
        for (CheckResultEnum value : CheckResultEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
} 