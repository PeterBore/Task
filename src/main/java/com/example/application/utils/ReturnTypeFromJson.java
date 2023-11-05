package com.example.application.utils;

import com.fasterxml.jackson.databind.JsonNode;

public enum ReturnTypeFromJson {
    STRING, INT;

    @SuppressWarnings("unchecked")
    public <T> T getValue(JsonNode json, String value) {
        JsonNode jsonNode = json.get(value);
        return switch (this) {
            case INT -> (T) Integer.valueOf(jsonNode.isNull() ? 0 : jsonNode.asInt());
            case STRING -> (T) String.valueOf(jsonNode.isNull() ? "" : jsonNode.asText());
            default -> (T) "";
        };
    }
}
