package com.ItemDemo.demo.controllers;

import com.ItemDemo.demo.dao.ItemRepositoryTest;
import com.ItemDemo.demo.entity.Item;
import com.ItemDemo.demo.service.ItemService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemControllerTest {

    @Test
    void addItem(){
        // Arrange
        ItemController itemController = new ItemController(new ItemService(new ItemRepositoryTest()));
        Item item = new Item();

        // Act
        Item result = itemController.addItem(item);

        // Assert
        assertEquals(item,result);
    }
}
