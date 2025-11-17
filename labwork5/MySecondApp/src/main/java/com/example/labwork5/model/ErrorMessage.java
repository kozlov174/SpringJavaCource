package com.example.labwork5.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessage {

    EMPTY(""),
    VALIDATION("Ошибка валидации"),
    UNSUPPORTED("Произошла непредвиденная ошибка"),
    UNKNOWN("Не поддерживаемая ошибка");

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}