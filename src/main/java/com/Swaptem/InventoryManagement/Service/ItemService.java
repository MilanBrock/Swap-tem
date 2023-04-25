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

    public boolean updateItem (Item item){
        Item oldItem = new Item();
        Optional<Item> optionalItem = itemRepository.findByItemIdAndActive(item.getItemId(), true);
        if(optionalItem.isPresent()){
            oldItem = optionalItem.get();
            oldItem.setName(item.getName());
            oldItem.setDescription(item.getDescription());
            itemRepository.save(oldItem);
        } else {
            return false;
        }
        return true;
    }

    public boolean deleteItemById(int id){
        boolean succes = false;
        Optional<Item> optionalItem = itemRepository.findByItemIdAndActive(id, true);

        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
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
