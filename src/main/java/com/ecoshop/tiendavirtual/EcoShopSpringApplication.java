package com.ecoshop.tiendavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcoShopSpringApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/EcoShop");
		SpringApplication.run(EcoShopSpringApplication.class, args);
	}

}
