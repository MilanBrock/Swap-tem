package com.Swaptem.InventoryManagement.UnitTest.Service;

import com.Swaptem.InventoryManagement.UnitTest.DAL.ItemRepositoryTest;
import com.Swaptem.InventoryManagement.Entity.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Tag("UnitTest")
public class ItemServiceTest {

    private ItemService itemService;
    private ItemRepositoryTest itemRepositoryTest;

    @BeforeEach
    void setup() throws Exception{
        itemRepositoryTest = new ItemRepositoryTest();
        itemService = new ItemService(itemRepositoryTest);

    }



    @Test
    public void CreateItemTest(){
        // Arrange
        Item item = new Item("Item1Name", "Item1Description");
        boolean expectedResult = true;

        // Act
        boolean result = itemService.createItem(item);

        // Assert
        assertEquals(expectedResult, result);
    }


    @Test
    public void GetItemByIdTest_Pass(){
        // Arrange
        int id = 1;

        Item itemExpected = new Item(1, "ItemEen","ItemEenDescription");
        // Act
        Item itemResult = itemService.getItemById(id);

        // Assert
        for (int i = 0; i < 2; i++){
            assertEquals(itemExpected.getId(),itemResult.getId());
            assertEquals(itemExpected.getName(), itemResult.getName());
            assertEquals(itemExpected.getDescription(), itemResult.getDescription());
        }
    }

    @Test
    public void GetItemByIdTest_Fail(){
        // Arrange
        int id = 5;

        Item itemExpected = null;
        // Act
        Item itemResult = itemService.getItemById(id);

        // Assert
        assertEquals(itemExpected,itemResult);
    }


    @Test
    public void GetItemsTest(){
        // Arrange
        List<Item> items = new ArrayList<Item>();

        Item itemEen = new Item(1,"ItemEen","ItemEenDescription");
        Item itemTwee = new Item(2,"ItemTwee","ItemTweeDescription");
        Item itemDrie = new Item(3,"ItemDrie","ItemDrieDescription");
        items.add(itemEen);
        items.add(itemTwee);
        items.add(itemDrie);

        // Act
        List<Item> resultItems = itemService.getItems();

        // Assert
        for(int i = 0; i < items.size(); i++){
            assertEquals(items.get(i).getId(),resultItems.get(i).getId());
            assertEquals(items.get(i).getName(), resultItems.get(i).getName());
            assertEquals(items.get(i).getDescription(), resultItems.get(i).getDescription());
        }

    }

    @Test
    public void UpdateItemTest(){
        // Arrange
        Item newItem = new Item(1,"ItemEenNEW", "ItemEenNEWDescription");
        boolean expectedResult = true;

        // Act
        boolean result = itemService.updateItem(newItem);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void DeleteItemByIdTest_Pass(){
        // Arrange
        int itemId = 1;
        boolean succes = true;

        // Act
        boolean succesResult = itemService.deleteItemById(itemId);

        // Assert
        assertEquals(succes, succesResult);
    }

    @Test
    public void DeleteItemByIdTest_Fail(){
        // Arrange
        int itemId = 5;
        boolean succes = false;

        // Act
        boolean succesResult = itemService.deleteItemById(itemId);

        // Assert
        assertEquals(succes, succesResult);
    }

}
