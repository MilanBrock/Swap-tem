package com.Swaptem.InventoryManagement.UnitTest.Validation;

import com.Swaptem.InventoryManagement.Entity.User;
import com.Swaptem.InventoryManagement.Validation.UserValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Tag("UnitTest")
public class UserValidationTest {

    private UserValidation userValidation;

    @BeforeEach
    void setup() throws Exception{
        userValidation = new UserValidation();
    }


    @Test
    public void UsernameIsValidTest_Pass(){
        // Arrange
        User user = new User();
        user.setUsername("UserEenName");

        boolean expectedResult = true;

        // Act
        boolean result = userValidation.UsernameIsValid(user.getUsername());

        // Assert
        assertEquals(expectedResult,result);
    }


    @Test
    public void UsernameIsValidTest_Fail(){
        // Arrange
        User user = new User();
        user.setUsername("UserEenNameIsInvalidBecauseItHasMoreThanTwentyFiveCharacters");

        boolean expectedResult = false;

        // Act
        boolean result = userValidation.UsernameIsValid(user.getUsername());

        // Assert
        assertEquals(expectedResult,result);
    }


    @Test
    public void UserPasswordIsValidTest_Pass(){
        // Arrange
        User user = new User();
        user.setPassword("UserEenPassword");

        boolean expectedResult = true;

        // Act
        boolean result = userValidation.UserPasswordIsValid(user.getPassword());

        // Assert
        assertEquals(expectedResult,result);
    }

    @Test
    public void UserPasswordIsValidTest_Fail(){
        // Arrange
        User user = new User();
        user.setPassword("UserEenPasswordIsInvalidBecauseItIsOverTwentyFiveCharacters");

        boolean expectedResult = false;

        // Act
        boolean result = userValidation.UserPasswordIsValid(user.getPassword());

        // Assert
        assertEquals(expectedResult,result);
    }


    @Test
    public void UserCurrencyIsValidTest_Pass(){
        // Arrange
        User user = new User();
        user.setCurrency(500);

        boolean expectedResult = true;

        // Act
        boolean result = userValidation.UserCurrencyIsValid(user.getCurrency());

        // Assert
        assertEquals(expectedResult,result);
    }

    @Test
    public void UserCurrencyIsValidTest_Fail(){
        // Arrange
        User user = new User();
        user.setCurrency(-250);

        boolean expectedResult = false;

        // Act
        boolean result = userValidation.UserCurrencyIsValid(user.getCurrency());

        // Assert
        assertEquals(expectedResult,result);
    }


}
