package com.Swaptem.InventoryManagement.DAL;

import com.Swaptem.InventoryManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryInterface extends JpaRepository<User,Integer> {

}
