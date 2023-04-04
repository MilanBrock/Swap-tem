package com.ItemDemo.demo.service;

import com.ItemDemo.demo.dao.ItemRepositoryTest;
import com.ItemDemo.demo.entity.Item;
import com.ItemDemo.demo.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        int id = 1;

        Item item = new Item(1, "ItemEen","ItemEenDescription");
        // Act
        Item itemResult = itemService.getItemById(id);

        // Assert
        for (int i = 0; i < 2; i++){
            assertEquals(item.getId(),itemResult.getId());
            assertEquals(item.getName(), itemResult.getName());
            assertEquals(item.getDescription(), itemResult.getDescription());
        }
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
        Item oldItem = new Item(1, "ItemEen", "ItemEenDescription");

        Item newItem = new Item(1,"ItemEenNEW", "ItemEenNEWDescription");

        // Act
        Item resultItem = itemService.updateItem(newItem);

        // Assert
        assertEquals(oldItem.getId(), resultItem.getId());
        assertNotEquals(oldItem.getName(), resultItem.getName());
        assertNotEquals(oldItem.getDescription(), resultItem.getDescription());
    }

    @Test
    public void DeleteItemByIdTest_True(){
        // Arrange
        int itemId = 1;
        Boolean succes = true;

        // Act
        Boolean succesResult = itemService.deleteItemById(itemId);

        // Assert
        assertEquals(succes, succesResult);
    }

    @Test
    public void DeleteItemByIdTest_False(){
        // Arrange
        int itemId = 5;
        Boolean succes = false;

        // Act
        Boolean succesResult = itemService.deleteItemById(itemId);

        // Assert
        assertEquals(succes, succesResult);
    }

}
