package com.Swaptem.InventoryManagement.Service;
import com.Swaptem.InventoryManagement.DTO.ItemDTO;
import com.Swaptem.InventoryManagement.Entity.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper {
    public ItemDTO toItemDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName(item.getName());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setCurrencyValue(item.getCurrencyValue());
        return itemDTO;
    }

    public Item toItem(ItemDTO itemDTO){
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setCurrencyValue(itemDTO.getCurrencyValue());
        return item;
    }
}
