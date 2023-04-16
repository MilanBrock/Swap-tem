package com.Swaptem.InventoryManagement.Service;

import com.Swaptem.InventoryManagement.DAL.UserRepositoryInterface;
import com.Swaptem.InventoryManagement.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    final UserRepositoryInterface userRepository;

    @Autowired
    public UserService(UserRepositoryInterface userRepositoryInput){
        this.userRepository = userRepositoryInput;
    }


    public boolean RegisterUser(User userInput){
        User resultUser = userRepository.save(userInput);
        if(resultUser.getUserId() > 0 ){
            return true;
        }
        return false;
    }

    public User getUserById(int userId){
        return userRepository.findById(userId).orElse(null);
    }

    public boolean updateUser(User user){
        User oldUser = new User();
        Optional<User> optionalUser = userRepository.findById(user.getUserId());
        if(optionalUser.isPresent()){
            oldUser.setUsername(user.getUsername());
            oldUser.setPassword(user.getPassword());
            oldUser.setCurrency(user.getCurrency());
            userRepository.save(oldUser);
        } else {
            return false;
        }
        return true;
    }


    public boolean deleteUserById(int userId){
        boolean succes = false;
        User user = userRepository.findById(userId).orElse(null);

        if(user != null){
            userRepository.deleteById(userId);
            succes = true;
        }
        return succes;
    }






}
