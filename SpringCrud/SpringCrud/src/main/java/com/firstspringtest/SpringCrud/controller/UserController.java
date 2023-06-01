package com.firstspringtest.SpringCrud.controller;

import com.firstspringtest.SpringCrud.entity.User;
import com.firstspringtest.SpringCrud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService UserService;

    @Autowired
    public UserController(UserService UserService){
        this.UserService=UserService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return UserService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        UserService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return UserService.updateUser(id, updatedUser);
    }
}
