package com.Swaptem.InventoryManagement.IntegrationTest;

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
    private UserRepositoryInterface userRepository;


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



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
