package com.example.application.controllers;

import com.example.application.utils.ReturnTypeFromJson;
import com.example.application.dtos.UserDto;
import com.example.application.services.HistoryRegisterService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

@RestController
public class RestUsersController {

    @Autowired
    HistoryRegisterService historyRegisterService;

    @GetMapping("/users/{login}")
    public UserDto getUser(@PathVariable String login) throws IOException {
        URL url = new URL("https://api.github.com/users/" + login);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonUser = mapper.readTree(url);
            historyRegisterService.incrementUsage(usersLogin(jsonUser));
            return consumeJson(jsonUser);
        } catch (FileNotFoundException e) {
            System.out.println("Invalid user login");
            return null;
        }
    }

    private UserDto consumeJson(JsonNode json) {
        try {
            return new UserDto(
                    ReturnTypeFromJson.STRING.getValue(json, "id"),
                    ReturnTypeFromJson.STRING.getValue(json, "login"),
                    ReturnTypeFromJson.STRING.getValue(json, "name"),
                    ReturnTypeFromJson.STRING.getValue(json, "type"),
                    ReturnTypeFromJson.STRING.getValue(json, "avatar_url"),
                    ReturnTypeFromJson.STRING.getValue(json, "created_at"),
                    ReturnTypeFromJson.INT.getValue(json, "followers"),
                    ReturnTypeFromJson.INT.getValue(json, "public_repos"));
        } catch (ClassCastException e) {
            throw new ClassCastException("One of the values type is incorrect");
        }
    }

    private String usersLogin(JsonNode json) {
        return ReturnTypeFromJson.STRING.getValue(json, "login");
    }
}
