package com.Swaptem.InventoryManagement.Controller;

import com.Swaptem.InventoryManagement.DTO.UserDTO;
import com.Swaptem.InventoryManagement.Entity.User;
import com.Swaptem.InventoryManagement.UnitTest.Service.UserMapper;
import com.Swaptem.InventoryManagement.UnitTest.Service.UserService;
import com.Swaptem.InventoryManagement.UnitTest.Validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;
    final UserValidation userValidation;
    final UserMapper userMapper;

    @Autowired
    public UserController(UserService userServiceInput, UserValidation userValidationInput, UserMapper userMapper){
        this.userService = userServiceInput;
        this.userValidation = userValidationInput;
        this.userMapper = userMapper;
    }

    @PostMapping()
    public ResponseEntity<String> RegisterUser(@RequestBody User userInput){
        boolean succes = userService.RegisterUser(userInput);
        if(succes){
            return new ResponseEntity<>("User added", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Could not add user", HttpStatus.NOT_ACCEPTABLE);

    }

    @GetMapping()
    public ResponseEntity<User> GetUserById(@PathVariable int userId){
        User user = userService.getUserById(userId);
        if(user != null){
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>(user, HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping()
    public ResponseEntity<String> UpdateUser(@RequestBody UserDTO userDTOInput){
        boolean succes = false;
        if(userValidation.UsernameIsValid(userDTOInput.getUsername())){
            User user = userMapper.ToUser(userDTOInput);
            succes = userService.updateUser(user);
            if(succes){
                return new ResponseEntity<>("Item updated", HttpStatusCode.valueOf(204));
            }
        }
        return new ResponseEntity<>("Item not updated", HttpStatus.NOT_ACCEPTABLE);
    }


    @DeleteMapping()
    public ResponseEntity<String> DeleteUser(@RequestBody UserDTO userDTOInput){
        User user = userService.getUserById(userDTOInput.getId());
        if(user != null){
            boolean succes = userService.deleteUserById(userDTOInput.getId());
            if (succes){
                return new ResponseEntity<>("User deleted", HttpStatusCode.valueOf(204));
            }
        }
        return new ResponseEntity<>("Item not deleted", HttpStatus.NOT_ACCEPTABLE);
    }





}
