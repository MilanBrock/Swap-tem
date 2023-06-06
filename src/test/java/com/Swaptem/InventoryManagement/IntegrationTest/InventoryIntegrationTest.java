package com.Swaptem.InventoryManagement.IntegrationTest;


import com.Swaptem.InventoryManagement.DAL.ItemRepositoryCustom;
import com.Swaptem.InventoryManagement.DAL.UserRepositoryCustom;
import com.Swaptem.InventoryManagement.DTO.InventoryDTO;
import com.Swaptem.InventoryManagement.Entity.Item;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("IntegrationTest")
public class InventoryIntegrationTest {

//    Inventory controller -> inventory service -> item/user service -> item/user repo
//    call: add Item to User 	-> check: data in item repo
//    call: removeItemfromUser-> check: data in item repo
//    call: get Inventory 	-> check: data in return

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ItemRepositoryCustom itemRepository;
    @Autowired
    private UserRepositoryCustom userRepository;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


//    @Test
//    void AddItemToUser_IntegrationTest(){
//        // Arrange
//        int userId = 1;
//        int itemId = 2;
//
//
//        // Act
//        try{
//            mockMvc.perform( MockMvcRequestBuilders
//                            .put("/inventory/add" )
//                            .content(asJsonString(new InventoryDTO(userId,itemId)))
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isAccepted());
//        } catch (Exception ex){
//
//        }
//
//        Item itemResult = itemRepository.findByItemIdAndActive(itemId,true).orElse(null);
//
//        // Assert
//        assertEquals(userId, itemResult.getOwner().getUserId());
//
//    }
//
//
//    @Test
//    void RemoveItemFromUser_IntegrationTest(){
//        // Arrange
//        int userId = 1;
//        int itemId = 1;
//
//
//        // Act
//        try{
//            mockMvc.perform( MockMvcRequestBuilders
//                            .put("/inventory/remove" )
//                            .content(asJsonString(new InventoryDTO(userId,itemId)))
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isAccepted());
//        } catch (Exception ex){
//
//        }
//
//        List<Item> itemResults = itemRepository.findAllByOwner_UserIdAndActive(userId,true);
//
//        // Assert
//        for(int i = 0; i< itemResults.size(); i++){
//            assertNotEquals(itemId, itemResults.get(i).getItemId());
//        }
//
//    }
//
//
//    @Test
//    void GetInventory_IntegrationTest(){
//        // Arrange
//        int userId = 2;
//        String expectedItemName = "Minesweeper";
//        String expectedItemDescription = "Relic of a historic figure";
//
//        // Act & Assert
//        try{
//            mockMvc.perform( MockMvcRequestBuilders
//                            .get("/inventory/{userId}", userId )
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value(expectedItemName))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value(expectedItemDescription));
//        } catch (Exception ex){
//
//        }
//
//    }

}
