package com.Swaptem.InventoryManagement;

import com.Swaptem.InventoryManagement.Entity.Item;
import com.Swaptem.InventoryManagement.Entity.User;
import com.Swaptem.InventoryManagement.DAL.ItemRepositoryInterface;
import com.Swaptem.InventoryManagement.DAL.UserRepositoryInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class InventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApplication.class, args);
	}




	@Bean
	CommandLineRunner run(UserRepositoryInterface userRepositoryInterface, ItemRepositoryInterface itemRepositoryInterface){
		return args -> {
			User userMilan = new User(1,"MilanBrock","Secret",650);
			userRepositoryInterface.save(userMilan);

			Item itemPenguino = new Item(2, "Penguino","Lives in the cold.", userMilan);
			itemRepositoryInterface.save(itemPenguino);
		};
	}
}
