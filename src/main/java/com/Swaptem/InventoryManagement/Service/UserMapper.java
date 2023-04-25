package com.Swaptem.InventoryManagement.Service;

import com.Swaptem.InventoryManagement.DTO.UserDTO;
import com.Swaptem.InventoryManagement.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO ToUserDTO(User userInput){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(userInput.getUsername());
        userDTO.setPassword(userInput.getPassword());
        userDTO.setCurrency(userInput.getCurrency());
        return userDTO;
    }

    public User ToUser(UserDTO userDTOInput){
        User user = new User();
        user.setUserId(userDTOInput.getUserId());
        user.setUsername(userDTOInput.getUsername());
        user.setPassword(userDTOInput.getPassword());
        user.setCurrency(userDTOInput.getCurrency());
        return user;
    }
}
