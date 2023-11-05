package com.example.application.dtos;

public class UserDto {
    private String id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private double calculations;

    public UserDto(String id, String login, String name, String type, String avatarUrl, String createdAt, int followers, int public_repos) {
        this.id = id;
        this.login = login;
        this.type = type;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.calculations = calculate(followers, public_repos);
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public double getCalculations() {
        return calculations;
    }

    private double calculate(int followers, int public_repos) {
        try {
            return followers != 0 ? (double) 6 / followers * (2 + public_repos) : 0;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("the number of followers or number of public repos is incorrect");
        }
    }

}
