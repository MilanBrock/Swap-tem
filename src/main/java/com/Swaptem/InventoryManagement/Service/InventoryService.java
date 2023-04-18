package com.Swaptem.InventoryManagement.Service;

import com.Swaptem.InventoryManagement.Entity.Item;
import com.Swaptem.InventoryManagement.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public boolean AddItemToUser(int userIdInput, int itemIdInput){
        boolean succes = false;

        // Check gebruiker bestaat
        User user = userService.getUserById(userIdInput);

        // check of item bestaat
        Item item = itemService.getItemById(itemIdInput);

        if (user != null && item != null){
            // check of item een eigenaar heeft
            if (item.getOwner() == null){
                // Update item met gebruiker als eigenaar
                item.setOwner(user);
                itemService.updateItem(item);
                succes = true;
            }
        }
        return succes;
    }

    public boolean RemoveItemFromUser(int userIdInput, int itemIdInput){
        boolean succes = false;

        // Check gebruiker bestaat
        User user = userService.getUserById(userIdInput);

        // check of item bestaat
        Item item = itemService.getItemById(itemIdInput);

        if (user != null && item != null){
            // check of gegeven gebruiker de eigenaar is van het item
            if (item.getOwner() == user){
                // Update item met gebruiker als eigenaar
                item.setOwner(null);
                itemService.updateItem(item);
                succes = true;
            }
        }
        return succes;
    }

    public List<Item> GetItemsByUserId(int userIdInput){
        List<Item> items = new ArrayList<>();
        User user = userService.getUserById(userIdInput);
        if (user != null){
            items = itemService.getItemsByUserId(userIdInput);
        }
        return items;
    }

}
