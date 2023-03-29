package com.ItemDemo.demo.controllers;

import com.ItemDemo.demo.entity.User;
import com.ItemDemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/User")
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userServiceInput){
        this.userService = userServiceInput;
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User userInput){
        return userService.CreateUser(userInput);
    }

}
