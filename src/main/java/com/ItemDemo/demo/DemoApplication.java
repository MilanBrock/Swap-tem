package com.ItemDemo.demo;

import com.ItemDemo.demo.controllers.ItemController;
import com.ItemDemo.demo.dao.ItemRepository;
import com.ItemDemo.demo.entity.Item;
import com.ItemDemo.demo.service.ItemService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
