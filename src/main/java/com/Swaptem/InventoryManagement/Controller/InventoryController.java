package com.Swaptem.InventoryManagement.Controller;


import com.Swaptem.InventoryManagement.DTO.InventoryDTO;
import com.Swaptem.InventoryManagement.DTO.ItemDTO;
import com.Swaptem.InventoryManagement.Entity.Item;
import com.Swaptem.InventoryManagement.Service.InventoryService;
import com.Swaptem.InventoryManagement.Service.ItemMapper;
import com.Swaptem.InventoryManagement.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    final InventoryService inventoryService;
    final ItemMapper itemMapper;
    final JwtService jwtService;

    @Autowired
    public InventoryController(InventoryService inventoryService, ItemMapper itemMapper, JwtService jwtService){
        this.inventoryService = inventoryService;
        this.itemMapper = itemMapper;
        this.jwtService = jwtService;
    }


    @PutMapping("/add")
    public ResponseEntity<String> addItemToUser(@RequestBody InventoryDTO inventoryDTO){
        boolean succes = inventoryService.AddItemToUser(inventoryDTO.getUserId(),inventoryDTO.getItemId());
        if (succes){
            return new ResponseEntity<String>("Succesfully added item to inventory", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("Unable to add item to inventory", HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/remove")
    public ResponseEntity<String> removeItemFromUser(@RequestBody InventoryDTO inventoryDTO){
        boolean succes = inventoryService.RemoveItemFromUser(inventoryDTO.getUserId(),inventoryDTO.getItemId());
        if(succes){
            return new ResponseEntity<String>("Succesfully removed item from inventory", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("Unable to remove item from inventory", HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("")
    public ResponseEntity<List<ItemDTO>> getInventory(@RequestHeader String authentication){
        int userId = jwtService.getUserIdFromJwtToken(authentication);

        List<ItemDTO> itemDTOs = new ArrayList<>();
        List<Item> items = inventoryService.GetItemsByUserId(userId);
        if(items.size() > 0){
            for(int i = 0; i < items.size(); i++){
                itemDTOs.add(itemMapper.toItemDTO(items.get(i)));
            }
            return ResponseEntity.ok(itemDTOs);
        }

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
    }
}