package com.Swaptem.InventoryManagement.DAL;

import com.Swaptem.InventoryManagement.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryCustom extends UserRepositoryInterface{
    Optional<User> findByUserIdAndActive(int userId, boolean active);
    Optional<User> findUserByUsernameAndPassword(String username, String password);
    Optional<User> findUserByUserIdAndAdmin(int userId, boolean admin);
}
