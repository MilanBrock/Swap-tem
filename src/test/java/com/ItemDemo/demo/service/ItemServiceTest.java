package com.ItemDemo.demo.service;

import com.ItemDemo.demo.dao.ItemRepositoryTest;
import com.ItemDemo.demo.entity.Item;
import com.ItemDemo.demo.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
        Item item4 = new Item();
        item4.setName("Item4");
        item4.setDescription("Item4Desc");

        Item item5 = new Item();
        item5.setName("Item5");
        item5.setDescription("Item5Desc");

        List<Item> itemList = new ArrayList<>();
        itemList.add(item4);
        itemList.add(item5);

        // Act
        List<Item> resultList = itemService.createItems(itemList);

        itemList.get(0).setId(4);
        itemList.get(1).setId(5);
        // Assert


        for (int i = 0; i < resultList.size(); i++){
            assertEquals(itemList.get(i).getId() ,resultList.get(i).getId());
            assertEquals(itemList.get(i).getName() ,resultList.get(i).getName());
            assertEquals(itemList.get(i).getDescription() ,resultList.get(i).getDescription());

        }

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
