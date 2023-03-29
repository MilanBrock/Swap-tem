package com.ItemDemo.demo.service;

import com.ItemDemo.demo.dao.ItemRepositoryTest;
import com.ItemDemo.demo.entity.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemServiceTest {
    @Test
    void CreateItem(){
        // Arrange
        ItemService itemService = new ItemService(new ItemRepositoryTest());
        Item item = new Item(1, "Item1Name", "Item1Description");

        // Act
        Item result = itemService.createItem(item);

        // Assert
        assertEquals(item, result);
    }
}
