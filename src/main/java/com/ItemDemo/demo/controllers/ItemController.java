package com.ItemDemo.demo.controllers;

import com.ItemDemo.demo.service.ItemService;
import com.ItemDemo.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Item")
public class ItemController {

    final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemServiceInput){
        this.itemService = itemServiceInput;
    }

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
    public Boolean deleteItem(@PathVariable int id){
        return itemService.deleteItemById(id);
    }




}
