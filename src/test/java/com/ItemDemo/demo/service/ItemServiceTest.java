package com.ItemDemo.demo.service;

import com.ItemDemo.demo.dao.ItemRepositoryTest;
import com.ItemDemo.demo.entity.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemServiceTest {

    ItemService itemService;
    ItemRepositoryTest itemRepositoryTest;

    @BeforeEach
    void setup() throws Exception{
        itemRepositoryTest = new ItemRepositoryTest();
        itemService = new ItemService(itemRepositoryTest);

    }



    @Test
    public void CreateItemTest(){
        // Arrange
        Item item = new Item(1, "Item1Name", "Item1Description");

        // Act
        Item result = itemService.createItem(item);

        // Assert
        assertEquals(item, result);
    }

    @Test
    public void CreateItemsTest(){
        // Arrange


        // Act


        // Assert

    }


    @Test
    public void GetItemByIdTest(){
        // Arrange


        // Act


        // Assert

    }

    @Test
    public void GetItemsTest(){
        // Arrange


        // Act


        // Assert

    }

    @Test
    public void UpdateItemTest(){
        // Arrange


        // Act


        // Assert
    }

    @Test
    public void DeleteItemByIdTest(){
        // Arrange


        // Act


        // Assert

    }

}
