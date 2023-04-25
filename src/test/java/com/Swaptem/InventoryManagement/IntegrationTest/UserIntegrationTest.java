package com.Swaptem.InventoryManagement.IntegrationTest;

import com.Swaptem.InventoryManagement.DAL.UserRepositoryCustom;
import com.Swaptem.InventoryManagement.DAL.UserRepositoryInterface;
import com.Swaptem.InventoryManagement.Entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("IntegrationTest")
public class UserIntegrationTest {

//    Usercontroller -> user service - > user repo
//    call: registerUser -> check: data in repo
//    call: GetUserById  -> check: data in return
//    call: UpdateUser 	 -> check: data in repo
//    call: delete User  -> check: data in repo


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepositoryCustom userRepository;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // Database aanvullen

    @Test
    void registerUser_IntegrationTest(){
        // Arrange
        String expectedUsername = "MilanBrockTest";
        String expectedPassword = "SecretTest";
        int expectedCurrency = 780;
        int expectedUserId = 2;


        // Act
        try{
            mockMvc.perform( MockMvcRequestBuilders
                            .post("/users")
                            .content(asJsonString(new User(expectedUsername,expectedPassword,expectedCurrency)))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated());
        } catch(Exception ex){

        }

        User userResult = userRepository.findById(expectedUserId).orElse(null);

        // Assert
        if(userResult != null){
            assertEquals(expectedUserId, userResult.getUserId());
            assertEquals(expectedUsername, userResult.getUsername());
            assertEquals(expectedPassword, userResult.getPassword());
            assertEquals(expectedCurrency, userResult.getCurrency());
        }
    }


    @Test
    void GetUserById_IntegrationTest(){
        // Arrange
        String expectedUsername = "MilanBrock";
        String expectedPassword = "Secret";
        int expectedCurrency = 650;
        int expectedUserId = 1;

        // Act
        try{
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/users/{userId}", expectedUserId)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.username").value(expectedUsername))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.password").value(expectedPassword))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value(expectedCurrency));
        } catch(Exception ex){

        }


    }



    @Test
    void UpdateUser_IntegrationTest(){
        // Arrange
        String expectedUsername = "MilanBrockTest";
        String expectedPassword = "SecretTest";
        int expectedCurrency = 850;
        int expectedUserId = 1;

        // Act
        try{
            mockMvc.perform( MockMvcRequestBuilders
                            .put("/users" )
                            .content(asJsonString(new User(expectedUserId, expectedUsername,expectedPassword,expectedCurrency)))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isAccepted());
        } catch (Exception ex){

        }

        User userResult = userRepository.findById(expectedUserId).orElse(null);

        // Assert
        if(userResult != null){
            assertEquals(expectedUserId, userResult.getUserId());
            assertEquals(expectedUsername, userResult.getUsername());
            assertEquals(expectedPassword, userResult.getPassword());
            assertEquals(expectedCurrency, userResult.getCurrency());
        }
    }


    @Test
    void DeleteUser_IntegrationTest(){
        // Arrange
        int expectedUserId = 1;
        boolean expectedActive = false;

        // Act
        try{
            mockMvc.perform( MockMvcRequestBuilders.delete("/users/{userId}", expectedUserId) )
                    .andExpect(status().isAccepted());
        } catch( Exception ex){

        }


        User userResult = userRepository.findById(expectedUserId).orElse(null);
        // Assert
        if(userResult != null){
            assertEquals(expectedActive, userResult.isActive());
        }


    }

}
