package com.lbg.project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Visitor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String name;
	private Integer age;
	private Integer favouriteNumber;

	public Visitor() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getFavouriteNumber() {
		return favouriteNumber;
	}

	public void setFavouriteNumber(Integer favouriteNumber) {
		this.favouriteNumber = favouriteNumber;
	}

	@Override
	public String toString() {
		return "Visitor [name=" + name + ", age=" + age + ", favouriteNumber=" + favouriteNumber + "]";
	}

}