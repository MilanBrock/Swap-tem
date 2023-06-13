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

			User userSaiPres = new User(5,"PresidentSai","Test",500, true, false);
			userRepositoryInterface.save(userSaiPres);

			User userBigStepper = new User(6,"BigStepper","Money",1500, true, false);
			userRepositoryInterface.save(userBigStepper);

			User userMisser = new User(7,"JettMisser","Cry",1500, true, false);
			userRepositoryInterface.save(userMisser);

			User userSkipper = new User(8,"Skipper","Hermes",0, true, false);
			userRepositoryInterface.save(userSkipper);

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

			Item itemBingus	= new Item(6, "Bingus", "Goofy goober", userGatoLover, true);
			itemRepositoryInterface.save(itemBingus);

			Item itemFlag	= new Item(7, "Flag", "Red white and blue", userSaiPres, true);
			itemRepositoryInterface.save(itemFlag);
		};
	}
}
