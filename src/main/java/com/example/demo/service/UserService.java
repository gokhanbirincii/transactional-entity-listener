package com.example.demo.service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on June, 2018
 *
 * @author gokhan
 */
@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public void updateUserMail(Long userId, String mail) {
		User user = userRepository.findById(userId).orElseThrow(IllegalStateException::new);
		user.setUserMail(mail);
		log.info("Mail address of the User updated with userId = {}", user.getId());
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User findById(Long userId) {
		return userRepository.findById(userId).orElseThrow(IllegalStateException::new);
	}

	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName).orElseThrow(IllegalStateException::new);
	}

	@Transactional
	public void updateProduct(Long userId, Product product) {

		User user = findById(userId);
		user.setProduct(product);
		product.setUser(user);

		log.info("Updated product of user with userId: {}", userId);

	}

	@Transactional
	public void updateProductName(Long userId, String productName) {
		User user = findById(userId);
		user.getProduct().setName(productName);

		log.info("Updated product name of user with userId: {}", userId);

	}
}
