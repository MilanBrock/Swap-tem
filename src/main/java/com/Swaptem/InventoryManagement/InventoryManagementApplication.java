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
			User userMilan = new User(1,"MilanBrock","Secret",650, true, true);
			userRepositoryInterface.save(userMilan);

			User userSwapGod = new User(2,"SwapGod","Secret",9650, true, false);
			userRepositoryInterface.save(userSwapGod);

			User userToBeDeleted = new User(3,"ToBeDeleted","Goodbye",0, true, false);
			userRepositoryInterface.save(userToBeDeleted);

			User userGatoLover = new User(4,"GatoLover","Meow",0, true, false);
			userRepositoryInterface.save(userGatoLover);

			Item itemPenguino = new Item(1, "Penguino","Lives in the cold.", userMilan, true);
			itemRepositoryInterface.save(itemPenguino);

			Item itemHat = new Item(2, "Hat","Lookin mighty fine", true);
			itemRepositoryInterface.save(itemHat);

			Item itemBottle = new Item(3, "Water Bottle","Refreshing", true);
			itemRepositoryInterface.save(itemBottle);

			Item itemTree = new Item(4, "Tree","Mother Nature", userMilan, true);
			itemRepositoryInterface.save(itemTree);

			Item itemLock = new Item(5, "Steel Lock","Securely in place", userMilan, true);
			itemRepositoryInterface.save(itemLock);

			Item itemSweeper = new Item(5, "Minesweeper","Relic of a historic figure", userSwapGod, true);
			itemRepositoryInterface.save(itemSweeper);
		};
	}
}
