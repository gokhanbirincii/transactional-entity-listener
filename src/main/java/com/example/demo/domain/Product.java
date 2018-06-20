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
public class Product {

	private static final Logger log = LoggerFactory.getLogger(Product.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String code;

	@Column(nullable = false)
	private Long creationTime;

	private Long updateTime;

	@OneToOne
	private User user;

	public Product() {

	}

	public Product(String name, String code) {
		this.name = name;
		this.code = code;
	}

	@PrePersist
	protected void preSave() {
		setCreationTime(Calendar.getInstance().getTimeInMillis());
		log.info("Product persist time is {}", getCreationTime());
	}

	@PreUpdate
	private void preUpdate() {
		setUpdateTime(Calendar.getInstance().getTimeInMillis());
		log.info("Product updateTime time is {}", getUpdateTime());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
