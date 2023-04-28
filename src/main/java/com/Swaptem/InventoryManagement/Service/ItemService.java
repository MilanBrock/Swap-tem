package com.Swaptem.InventoryManagement.Service;

import com.Swaptem.InventoryManagement.DAL.ItemRepositoryCustom;
import com.Swaptem.InventoryManagement.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    final ItemRepositoryCustom itemRepository;

    @Autowired
    public ItemService(ItemRepositoryCustom itemRepositoryInput){
        this.itemRepository = itemRepositoryInput;
    }

    public boolean createItem(Item item){
        item.setActive(true);
        Item itemResult = itemRepository.save(item);
        if( itemResult.getItemId() > 0){
            return true;
        }
        return false;
    }

    public Item getItemById(int id){
        return itemRepository.findByItemIdAndActive(id,true).orElse(null);
    }

    public List<Item> getItems(){
        return itemRepository.findAllByActive(true).orElse(null);
    }

    public boolean updateItem (Item itemInput){
        Item item = itemRepository.findByItemIdAndActive(itemInput.getItemId(), true).orElse(null);
        if(item != null){
            item.setName(itemInput.getName());
            item.setDescription(itemInput.getDescription());
            itemRepository.save(item);
        } else {
            return false;
        }
        return true;
    }

    public boolean deleteItemById(int id){
        boolean succes = false;
        Item item = itemRepository.findByItemIdAndActive(id, true).orElse(null);

        if(item != null){
            item.setActive(false);
            itemRepository.save(item);
            succes = true;
        }
        return succes;
    }

    public List<Item> getItemsByUserId(int userId){
        List<Item> items = itemRepository.findAllByOwner_UserIdAndActive(userId, true);
        return items;
    }


}
