package com.Swaptem.InventoryManagement.DAL;

import com.Swaptem.InventoryManagement.Entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ItemRepositoryCustom extends ItemRepositoryInterface{
    List<Item> findAllByOwner_UserIdAndActive(int userId, boolean active);
    Optional<Item> findByItemIdAndActive(int itemId, boolean active);
    Optional<List<Item>> findAllByActive(boolean active);
}
