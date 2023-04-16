package com.Swaptem.InventoryManagement.Service;

import com.Swaptem.InventoryManagement.Entity.Item;
import com.Swaptem.InventoryManagement.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private UserService userService;
    private ItemService itemService;


    @Autowired
    public InventoryService(UserService userServiceInput, ItemService itemServiceInput){
        this.userService = userServiceInput;
        this.itemService = itemServiceInput;
    }

    public boolean AddItemToUser(User userInput, Item itemInput){
        return false;
    }

    public boolean RemoveItemFromUser(User userInput, Item itemInput){
        return false;
    }

    public List<Item> GetItemsByUsedId(int userIdInput){
        return null;
    }

}
