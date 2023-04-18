package com.Swaptem.InventoryManagement.DAL;

import com.Swaptem.InventoryManagement.Entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepositoryInterfaceCustom extends ItemRepositoryInterface{
    List<Item> findAllByOwner_UserId(int userId);
}
