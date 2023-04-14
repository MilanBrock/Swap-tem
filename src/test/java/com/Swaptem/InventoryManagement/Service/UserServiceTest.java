package com.Swaptem.InventoryManagement.Service;

import com.Swaptem.InventoryManagement.DAL.ItemRepositoryTest;
import com.Swaptem.InventoryManagement.DAL.UserRepositoryTest;
import com.Swaptem.InventoryManagement.Entity.Item;
import com.Swaptem.InventoryManagement.Entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {


    private UserService userService;
    private UserRepositoryTest userRepositoryTest;

    @BeforeEach
    void setup() throws Exception{
        userRepositoryTest = new UserRepositoryTest();
        userService = new UserService(userRepositoryTest);

    }


    @Test
    public void RegisterUserTest(){
        // Arrange
        User registerUser = new User("NewUserName", "NewUserPassword", 500);
        boolean expectedResult = true;

        // Act
        boolean result = userService.RegisterUser(registerUser);

        // Assert
        assertEquals(expectedResult, result);
    }


    @Test
    public void GetUserByIdTest_Pass(){
        // Arrange
        int id = 1;

        User userExpected = new User(1, "UsernameEEN", "UserPasswordEEN", 500);
        // Act
        User userResult = userService.getUserById(id);

        // Assert
        for (int i = 0; i < 2; i++){
            assertEquals(userExpected.getId(),userResult.getId());
            assertEquals(userExpected.getUsername(), userResult.getUsername());
            assertEquals(userExpected.getPassword(), userResult.getPassword());
            assertEquals(userExpected.getCurrency(), userResult.getCurrency());
        }
    }



    @Test
    public void GetUserByIdTest_Fail(){
        // Arrange
        int id = 5;

        User userExpected = null;
        // Act
        User userResult = userService.getUserById(id);

        // Assert
        assertEquals(userExpected,userResult);
    }


    @Test
    public void UpdateUserTest(){
        // Arrange
        User newUser3 = new User(3, "UsernameDRIE", "UserPasswordDRIE", 1250);
        boolean expectedResult = true;

        // Act
        boolean result = userService.updateUser(newUser3);

        // Assert
        assertEquals(expectedResult, result);
    }


    @Test
    public void DeleteUserByIdTest_Pass(){
        // Arrange
        int userId = 1;
        boolean succes = true;

        // Act
        boolean succesResult = userService.deleteUserById(userId);

        // Assert
        assertEquals(succes, succesResult);
    }


    @Test
    public void DeleteUserByIdTest_Fail(){
        // Arrange
        int userId = 5;
        boolean succes = false;

        // Act
        boolean succesResult = userService.deleteUserById(userId);

        // Assert
        assertEquals(succes, succesResult);
    }

}
