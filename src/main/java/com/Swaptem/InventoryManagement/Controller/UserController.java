package com.Swaptem.InventoryManagement.Controller;

import com.Swaptem.InventoryManagement.DTO.UserDTO;
import com.Swaptem.InventoryManagement.Entity.User;
import com.Swaptem.InventoryManagement.Service.UserMapper;
import com.Swaptem.InventoryManagement.Service.UserService;
import com.Swaptem.InventoryManagement.Validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
        if(userValidation.UsernameIsValid(userInput.getUsername()) && userValidation.UserPasswordIsValid(userInput.getPassword()) && userValidation.UserCurrencyIsValid(userInput.getCurrency())){
            if(userService.RegisterUser(userInput)){
                return new ResponseEntity<>("User added", HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>("Could not add user", HttpStatus.NOT_ACCEPTABLE);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> GetUserById(@PathVariable int userId){
        User user = userService.getUserById(userId);
        if(user != null){
            UserDTO userDTO = userMapper.ToUserDTO(user);
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
    }

    @PutMapping()
    public ResponseEntity<String> UpdateUser(@RequestBody UserDTO userDTOInput){
        boolean succes = false;
        if(userValidation.UsernameIsValid(userDTOInput.getUsername())){
            User user = userMapper.ToUser(userDTOInput);
            succes = userService.updateUser(user);
            if(succes){
                return new ResponseEntity<>("User updated", HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>("User not updated", HttpStatus.NOT_ACCEPTABLE);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<String> DeleteUser(@PathVariable int userId){
        User user = userService.getUserById(userId);
        if(user != null){
            boolean succes = userService.deleteUserById(userId);
            if (succes){
                return new ResponseEntity<>("User deleted", HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>("User not deleted", HttpStatus.NOT_ACCEPTABLE);
    }
    
}
