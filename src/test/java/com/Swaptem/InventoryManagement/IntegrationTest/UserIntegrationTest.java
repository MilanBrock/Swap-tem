package com.Swaptem.InventoryManagement.IntegrationTest;

import com.Swaptem.InventoryManagement.DAL.UserRepositoryCustom;
import com.Swaptem.InventoryManagement.DAL.UserRepositoryInterface;
import com.Swaptem.InventoryManagement.Entity.User;
import com.Swaptem.InventoryManagement.Service.ItemService;
import com.Swaptem.InventoryManagement.UnitTest.DAL.ItemRepositoryTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("IntegrationTest")
public class UserIntegrationTest {
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
        int expectedUserId = 4;

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
        String expectedUsername = "SwapGod";
        String expectedPassword = "Secret";
        int expectedCurrency = 9650;
        int expectedUserId = 2;

        // Act & Assert
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
        String newUsername = "MilanBrockTest";
        String newPassword = "SecretTest";
        int newCurrency = 850;
        int userId = 1;

        // Act
        try{
            mockMvc.perform( MockMvcRequestBuilders
                            .put("/users" )
                            .content(asJsonString(new User(userId, newUsername,newPassword,newCurrency)))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isAccepted());
        } catch (Exception ex){

        }

        User userResult = userRepository.findById(userId).orElse(null);

        // Assert
        if(userResult != null){
            assertEquals(newUsername, userResult.getUsername());
            assertEquals(newPassword, userResult.getPassword());
            assertEquals(newCurrency, userResult.getCurrency());
        }
    }


    @Test
    void DeleteUser_IntegrationTest(){
        // Arrange
        int expectedUserId = 3;
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
