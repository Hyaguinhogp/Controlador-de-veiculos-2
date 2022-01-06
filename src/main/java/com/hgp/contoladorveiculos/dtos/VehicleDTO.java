package com.hgp.contoladorveiculos.dtos;

import java.io.Serializable;

public class VehicleDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String brand;
	private String model;
	private Integer year;
	private UserDTO user;
	
	public VehicleDTO() {
	}

	public VehicleDTO(Long id, String brand, String model, Integer year, UserDTO user) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
