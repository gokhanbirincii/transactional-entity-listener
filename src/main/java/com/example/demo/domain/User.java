package com.example.demo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created on June, 2018
 *
 * @author gokhan
 */
@Entity
public class User {

	private static final Logger log = LoggerFactory.getLogger(User.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userName;

	private String userMail;

	@Column(nullable = false)
	private Long creationTime;

	private Long updateTime;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Product product;

	public User() {

	}

	public User(String userName, String userMail) {
		this.userName = userName;
		this.userMail = userMail;
	}

	@PrePersist
	protected void preSave() {
		setCreationTime(Calendar.getInstance().getTimeInMillis());
		log.info("User persist time is {}", getCreationTime());
	}

	@PreUpdate
	private void preUpdate() {
		setUpdateTime(Calendar.getInstance().getTimeInMillis());
		log.info("User updateTime time is {}", getUpdateTime());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public Long getCreationTime() {
		return creationTime;
	}

	private void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	private void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
