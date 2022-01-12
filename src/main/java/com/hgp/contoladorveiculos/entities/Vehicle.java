package com.hgp.contoladorveiculos.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_tb")
public class Vehicle {

	@Id
	private String id;
	private String brand;
	private String model;
	private String year;
	
	@ManyToMany(mappedBy = "vehicles")
	private Set<User> users = new HashSet<>();
	
	public Vehicle() {
	}

	public Vehicle(String id, String brand, String model, String year) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Set<User> getUsers() {
		return users;
	}
}
