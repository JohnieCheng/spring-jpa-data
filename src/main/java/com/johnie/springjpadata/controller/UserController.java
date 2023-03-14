package com.johnie.springjpadata.controller;

import com.johnie.springjpadata.entity.User;
import com.johnie.springjpadata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        User savedUser = this.userService.add(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        User updatedUser = this.userService.update(user);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User getedUser = this.userService.getById(id);
        return ResponseEntity.ok(getedUser);
    }

    @GetMapping(value = "/history/{id}")
    public ResponseEntity<List<User>> getHistory(@PathVariable Long id) {
        List<User> historyUsers = this.userService.getHistoryById(id);
        return ResponseEntity.ok(historyUsers);
    }
}
