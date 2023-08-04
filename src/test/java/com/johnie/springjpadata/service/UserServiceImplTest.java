package com.johnie.springjpadata.service;

import com.johnie.springjpadata.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
    }


    @Test
    @Order(1)
    void add() {
        User newUser = new User();
        newUser.setUserName("johnie");
        newUser.setPassword("123");
        User user = userService.add(newUser);
        assertNotNull(user);
    }

    @Test
    @Order(2)
    void getById() {
        User user = userService.getById(1L);
        assertNotNull(user);
    }

    @Test
    @Order(3)
    void getByUsername() {
        User user = userService.getByUsername("johnie");
        assertNotNull(user);
    }

}