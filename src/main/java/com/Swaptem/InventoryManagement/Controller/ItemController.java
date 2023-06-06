package com.Swaptem.InventoryManagement.Controller;

import com.Swaptem.InventoryManagement.DTO.ItemCollectionDTO;
import com.Swaptem.InventoryManagement.DTO.ItemDTO;
import com.Swaptem.InventoryManagement.Entity.User;
import com.Swaptem.InventoryManagement.Service.ItemMapper;
import com.Swaptem.InventoryManagement.Service.ItemService;
import com.Swaptem.InventoryManagement.Entity.Item;
import com.Swaptem.InventoryManagement.Service.JwtService;
import com.Swaptem.InventoryManagement.Service.UserService;
import com.Swaptem.InventoryManagement.Validation.ItemValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/items")
public class ItemController {

    final ItemService itemService;
    final ItemMapper itemMapper;
    final ItemValidation itemValidation;
    final UserService userService;
    final JwtService jwtService;

    @Autowired
    public ItemController(ItemService itemServiceInput, ItemMapper itemMapper, ItemValidation itemValidation, UserService userService, JwtService jwtService){
        this.itemService = itemServiceInput;
        this.itemMapper = itemMapper;
        this.itemValidation = itemValidation;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping()
    public ResponseEntity<String> addItem(@RequestBody Item item, @RequestHeader String authentication){
        int userId = jwtService.getUserIdFromJwtToken(authentication);
        boolean isAdmin = userService.isUserAdmin(userId);

        if(isAdmin && itemValidation.ItemNameIsValid(item.getName()) && itemValidation.ItemDescriptionIsValid(item.getDescription())){
            itemService.createItem(item);
            return new ResponseEntity<>("Item added", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Could not add item", HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable int id){
        Item item = itemService.getItemById(id);
        if (item != null){
            ItemDTO itemDTO = itemMapper.toItemDTO(item);
            return ResponseEntity.ok(itemDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
    }

    @PostMapping("/itemCollection")
    public ResponseEntity<ItemCollectionDTO> getItemsByIds(@RequestBody ItemCollectionDTO itemIds){
        ItemCollectionDTO itemCollectionDTO = new ItemCollectionDTO();
        ItemDTO[] itemDTOS = new ItemDTO[itemIds.itemIds.length];
        for(int i = 0; i < itemIds.itemIds.length; i++){
            Item item = itemService.getItemById(itemIds.itemIds[i]);
            if (item != null){
                ItemDTO itemDTO = itemMapper.toItemDTO(item);
                itemDTOS[i] = itemDTO;
            }
        }
        itemCollectionDTO.items = itemDTOS;

        return ResponseEntity.ok(itemCollectionDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        List<Item> items = itemService.getItems();
        List<ItemDTO> itemDTOs = new ArrayList<>();
        for (int i = 0; i < items.size(); i++){
            ItemDTO itemDTO = itemMapper.toItemDTO(items.get(i));
            itemDTOs.add(itemDTO);
        }
        return ResponseEntity.ok(itemDTOs);
    }

    @PutMapping()
    public ResponseEntity<String> updateItem(@RequestBody Item item, @RequestHeader String authentication){
        int userId = jwtService.getUserIdFromJwtToken(authentication);
        boolean isAdmin = userService.isUserAdmin(userId);

        if(isAdmin && itemValidation.ItemNameIsValid(item.getName()) && itemValidation.ItemDescriptionIsValid(item.getDescription())){
            boolean succes = itemService.updateItem(item);
            if(succes){
                return new ResponseEntity<>("Item updated", HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Item not updated", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Requesting user is not an admin", HttpStatus.NOT_ACCEPTABLE);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable int id, @RequestHeader String authentication){
        int userId = jwtService.getUserIdFromJwtToken(authentication);
        boolean isAdmin = userService.isUserAdmin(userId);

        if(isAdmin){
            boolean succes = itemService.deleteItemById(id);
            if(succes){
                return new ResponseEntity<>("Item deleted", HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Item not deleted, incorrect item id", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Requesting user is not an admin", HttpStatus.NOT_ACCEPTABLE);
    }
}
