package com.Swaptem.InventoryManagement.UnitTest.Service;

import com.Swaptem.InventoryManagement.Service.InventoryService;
import com.Swaptem.InventoryManagement.Service.ItemService;
import com.Swaptem.InventoryManagement.Service.UserService;
import com.Swaptem.InventoryManagement.UnitTest.DAL.ItemRepositoryTest;
import com.Swaptem.InventoryManagement.UnitTest.DAL.UserRepositoryTest;
import com.Swaptem.InventoryManagement.Entity.Item;
import com.Swaptem.InventoryManagement.Entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Tag("UnitTest")
public class InventoryServiceTest {


    private InventoryService inventoryService;
    private UserService userService;
    private ItemService itemService;

    @BeforeEach
    public void setup() throws Exception{
        userService = new UserService(new UserRepositoryTest());
        itemService = new ItemService(new ItemRepositoryTest());
        inventoryService = new InventoryService(userService, itemService);
    }


    @Test
    public void AddItemTest_UserNotExist_Fail(){
        // Arrange
        Item item = new Item(1,"ItemEen","ItemEenDescription");
        User user = new User(404, "Username404", "UserPassword404", 500);
        // User 404 does not exist

        boolean expectedResult = false;
        // Act
        boolean result = inventoryService.AddItemToUser(user, item);

        // Assert
        //assertEquals(expectedResult, result);
    }

    @Test
    public void AddItemTest_ItemNotExist_Fail(){
        // Arrange
        Item item = new Item(404,"ItemVIERNULVIER","ItemVIERNULVIERDescription");
        User user = new User(1, "UsernameEEN", "UserPasswordEEN", 500);
        // Item 404 does not exist

        boolean expectedResult = false;
        // Act
        boolean result = inventoryService.AddItemToUser(user, item);

        // Assert
        //assertEquals(expectedResult, result);
    }

    @Test
    public void AddItemTest_ItemNotAvailable_Fail(){
        // Arrange
        Item item = new Item(2,"ItemVIERTWEEVIER","ItemVIERTWEEVIERDescription");
        User user = new User(1, "UsernameEEN", "UserPasswordEEN", 500);
        // Item 2 already belongs to another user

        boolean expectedResult = false;
        // Act
        boolean result = inventoryService.AddItemToUser(user, item);

        // Assert
        //assertEquals(expectedResult, result);
    }


    @Test
    public void AddItemTest_Pass(){
        // Arrange
        Item item = new Item(3,"ItemEen","ItemEenDescription");
        User user = new User(1, "UsernameEEN", "UserPasswordEEN", 500);

        boolean expectedResult = true;
        // Act
        boolean result = inventoryService.AddItemToUser(user, item);

        // Assert
        //assertEquals(expectedResult, result);
    }


    @Test
    public void RemoveItemTest_UserNotExist_Fail(){
        // Arrange
        Item item = new Item(1,"ItemEen","ItemEenDescription");
        User user = new User(404, "Username404", "UserPassword404", 500);
        // User 404 does not exist

        boolean expectedResult = false;
        // Act
        boolean result = inventoryService.RemoveItemFromUser(user, item);

        // Assert
        //assertEquals(expectedResult, result);
    }

    @Test
    public void RemoveItemTest_UserNotHaveItem_Fail(){
        // Arrange
        Item item = new Item(5,"ItemFIVE","ItemFIVEDescription");
        User user = new User(1, "UsernameEEN", "UserPasswordEEN", 500);
        // User does not have this item

        boolean expectedResult = false;
        // Act
        boolean result = inventoryService.RemoveItemFromUser(user, item);

        // Assert
        //assertEquals(expectedResult, result);
    }


    @Test
    public void RemoveItemTest_ItemNotExist_Fail(){
        // Arrange
        Item item = new Item(404,"ItemVIERNULVIER","ItemVIERNULVIERDescription");
        User user = new User(1, "UsernameEEN", "UserPasswordEEN", 500);
        // Item 404 does not exist

        boolean expectedResult = false;
        // Act
        boolean result = inventoryService.RemoveItemFromUser(user, item);

        // Assert
        //assertEquals(expectedResult, result);
    }

    @Test
    public void RemoveItemTest_Pass(){
        // Arrange
        Item item = new Item(1,"ItemEen","ItemEenDescription");
        User user = new User(1, "UsernameEEN", "UserPasswordEEN", 500);


        boolean expectedResult = true;
        // Act
        boolean result = inventoryService.RemoveItemFromUser(user, item);

        // Assert
        //assertEquals(expectedResult, result);
    }

    @Test
    public void GetItemsByUserId_UserNotExist_Fail(){
        // Arrange
        int userId = 404;
        // user 404 does not exist

        int expectedResult = 0;
        // Act
        List<Item> itemsResult = inventoryService.GetItemsByUsedId(userId);

        // Assert
        //assertEquals(expectedResult, itemsResult.size());
    }

    @Test
    public void GetItemsByUserId_Pass(){
        // Arrange
        int userId = 1;

        int expectedResult = 1;
        // Act
        List<Item> itemsResult = inventoryService.GetItemsByUsedId(userId);

        // Assert
        //assertEquals(expectedResult, itemsResult.size());
    }


}
