package com.hgp.contoladorveiculos.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSetter;

public class VehicleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String type;
	private String brand;
	private String model;
	private String year;
	private UserDTO user;

	public VehicleDTO() {
	}

	public VehicleDTO(Long id, String type, String brand, String model, String year, UserDTO user) {
		super();
		this.id = id;
		this.type = type;
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

	public String getType() {
		return type;
	}

	@JsonSetter(value = "TipoVeiculo")
	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	@JsonSetter(value = "Marca")
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	@JsonSetter(value = "Modelo")
	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	@JsonSetter(value = "AnoModelo")
	public void setYear(String year) {
		this.year = year;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
