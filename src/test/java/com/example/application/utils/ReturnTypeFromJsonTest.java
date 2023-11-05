package com.example.application.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


class ReturnTypeFromJsonTest {

    JsonNode jsonNodeInTest;

    @BeforeEach
    void init() throws IOException {
        ObjectMapper mapperInTest = new ObjectMapper();

        jsonNodeInTest = mapperInTest
                .readValue(new File("src/test/java/com/example/application/utils/testJson.json"), JsonNode.class);
    }

    @Test
    void getValueFromJsonString() {
        Assertions.assertEquals("octocat", ReturnTypeFromJson.STRING.getValue(jsonNodeInTest, "login"));
    }

    @Test
    void getValueFromJsonInt() {
        Assertions.assertEquals(Integer.valueOf(8), ReturnTypeFromJson.INT.getValue(jsonNodeInTest, "public_repos"));
    }
}