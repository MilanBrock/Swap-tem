package com.ItemDemo.demo.controllers;

import com.ItemDemo.demo.service.ItemService;
import com.ItemDemo.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @PostMapping("/addItems")
    public List<Item> addItems(@RequestBody List<Item> items){
        return itemService.createItems(items);
    }

    @PostMapping("/item/{id}")
    public Item getItemById(@PathVariable int id){
        return itemService.getItemById(id);
    }

    @GetMapping("/items")
    public List<Item> getAllItems(){
        return itemService.getItems();
    }

    @PutMapping("/updateitem")
    public Item updateItem(@RequestBody Item item){
        return itemService.updateItem(item);
    }

    @DeleteMapping("/item/{id}")
    public String deleteItem(@PathVariable int id){
        return itemService.deleteItemById(id);
    }




}
