package com.johnie.springjpadata.service;

import com.johnie.springjpadata.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);

    User update(User user);

    User getById(Long id);
    User getByUsername(String username);
    User getByUsername2(String username);
    User getByUsername3(String username);

    List<User> getHistoryById(Long id);
}
