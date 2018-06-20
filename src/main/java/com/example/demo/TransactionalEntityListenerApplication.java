package com.example.demo;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class TransactionalEntityListenerApplication implements CommandLineRunner {

	private final UserService userService;

	@Autowired
	public TransactionalEntityListenerApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TransactionalEntityListenerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product product = new Product("Prroodduucctt", UUID.randomUUID().toString());

		User user = new User("testUser", "testUser@mailinator.com");

		user.setProduct(product);
		product.setUser(user);

		userService.save(user);

	}
}
