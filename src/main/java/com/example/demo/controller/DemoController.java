package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

/**
 * Created on June, 2018
 *
 * @author gokhan
 */
@Controller
public class DemoController {

	private final UserService userService;

	public DemoController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/update-user-property")
	public ResponseEntity<Void> updateUser() {

		User user = userService.findByUserName("testUser");

		//`preUpdate()` method invoked
		userService.updateUserMail(user.getId(), "newusermail@mailinator.com");

		return ResponseEntity.ok().build();
	}

	@GetMapping("/update-user-product")
	public ResponseEntity<Void> updateProduct() {

		Product product = new Product("Hede", UUID.randomUUID().toString());
		User user = userService.findByUserName("testUser");

		//`preSave()` method of the Product Entity invoked here.
		//So , Product's updateTime field has been null
		userService.updateProduct(user.getId(), product);

		//`preUpdate()` method of the Product Entity invoked here.
		userService.updateProductName(user.getId(), "Product Name");

		//Not invoked user entity's both `preSave()` and `preUpdate()` methods in both cases
		return ResponseEntity.ok().build();
	}

}
