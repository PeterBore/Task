package com.example.application.dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserDtoTest {

    @Test
    void calculateZeroFollowers() {
        UserDto testUser = new UserDto(null, null, null, null, null, null, 0, 5);
        Assertions.assertEquals(0, testUser.getCalculations());
    }

    @Test
    void calculateZeroPublicRepos() {
        UserDto testUser = new UserDto(null, null, null, null, null, null, 10, 0);
        Assertions.assertEquals(6.0 / 10.0 * (2.0 + 0.0), testUser.getCalculations());
    }

    @Test
    void calculateZeroFollowersAndPublicRepos() {
        UserDto testUser = new UserDto(null, null, null, null, null, null, 0, 0);
        Assertions.assertEquals(0, testUser.getCalculations());
    }

    @Test
    void calculate() {
        UserDto testUser = new UserDto(null, null, null, null, null, null, 10, 5);
        Assertions.assertEquals(6.0 / 10.0 * (2.0 + 5.0), testUser.getCalculations());
    }
}