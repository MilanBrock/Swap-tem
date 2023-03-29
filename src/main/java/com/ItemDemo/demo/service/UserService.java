package com.ItemDemo.demo.service;

import com.ItemDemo.demo.dao.UserRepositoryInterface;
import com.ItemDemo.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepositoryInterface userRepository;

    @Autowired
    public UserService(UserRepositoryInterface userRepositoryInput){
        this.userRepository = userRepositoryInput;
    }


    public User CreateUser(User userInput){
        User user = userRepository.save(userInput);
        return user;
    }







}
