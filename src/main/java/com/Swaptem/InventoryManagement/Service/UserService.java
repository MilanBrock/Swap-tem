package com.Swaptem.InventoryManagement.Service;

import com.Swaptem.InventoryManagement.DAL.UserRepositoryCustom;
import com.Swaptem.InventoryManagement.DTO.UserLoginDTO;
import com.Swaptem.InventoryManagement.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepositoryCustom userRepository;

    @Autowired
    public UserService(UserRepositoryCustom userRepositoryInput){
        this.userRepository = userRepositoryInput;
    }


    public boolean registerUser(User userInput){
        userInput.setActive(true);
        userInput.setAdmin(false);
        User resultUser = userRepository.save(userInput);
        if(resultUser.getUserId() > 0 ){
            return true;
        }
        return false;
    }

    public User getUserById(int userId){
        return userRepository.findByUserIdAndActive(userId, true).orElse(null);
    }

    public boolean updateUser(User userInput){
        User user = userRepository.findByUserIdAndActive(userInput.getUserId(), true).orElse(null);
        if(user != null){
            if(userInput.getUsername() != null){
                user.setUsername(userInput.getUsername());
            }
            if(userInput.getPassword() != null){
                user.setPassword(userInput.getPassword());
            }
            if(userInput.getCurrency() != 0){
                user.setCurrency(userInput.getCurrency());
            }
            userRepository.save(user);
        } else {
            return false;
        }
        return true;
    }


    public boolean deleteUserById(int userId){
        boolean succes = false;

        User user = userRepository.findByUserIdAndActive(userId, true).orElse(null);
        if(user != null){
            user.setActive(false);
            userRepository.save(user);
            succes = true;
        }
        return succes;
    }


    public User CheckUserCredentials(UserLoginDTO userInput){
        User validatedUser = null;

        User resultUser = userRepository.findUserByUsernameAndPassword(userInput.username, userInput.password).orElse(null);
        if(resultUser != null){
            validatedUser = resultUser;
        }
        return validatedUser;
    }


    public boolean isUserAdmin(int userIdInput){
        boolean isAdmin = false;
        User user = userRepository.findUserByUserIdAndAdmin(userIdInput, true).orElse(null);
        if(user != null){
            isAdmin = true;
        }
        return isAdmin;
    }



}
