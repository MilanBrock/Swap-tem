package com.Swaptem.InventoryManagement.Service;

import com.Swaptem.InventoryManagement.DAL.ItemRepositoryInterface;
import com.Swaptem.InventoryManagement.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    final ItemRepositoryInterface itemRepository;

    @Autowired
    public ItemService(ItemRepositoryInterface itemRepositoryInput){
        this.itemRepository = itemRepositoryInput;
    }

    public boolean createItem(Item item){
        itemRepository.save(item);
        return true;
    }

    public Item getItemById(int id){
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public boolean updateItem (Item item){
        Item oldItem = new Item();
        Optional<Item> optionalItem = itemRepository.findById(item.getId());
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
        Optional<Item> item = itemRepository.findById(id);

        if(item != null){
            itemRepository.deleteById(id);
            succes = true;
        }

        return succes;
    }


}
