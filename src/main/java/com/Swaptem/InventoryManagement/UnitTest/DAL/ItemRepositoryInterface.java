package com.Swaptem.InventoryManagement.UnitTest.DAL;

import com.Swaptem.InventoryManagement.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositoryInterface extends JpaRepository<Item, Integer> {
}
