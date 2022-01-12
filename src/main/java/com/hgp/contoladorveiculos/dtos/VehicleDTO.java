package com.hgp.contoladorveiculos.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.hgp.contoladorveiculos.entities.Vehicle;

public class VehicleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String brand;
	private String model;
	private String year;
	
	public VehicleDTO() {
	}

	public VehicleDTO(String id, String brand, String model, String year) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
	}
	
	public VehicleDTO(Vehicle vehicle) {
		this.id = vehicle.getId();
		this.brand = vehicle.getBrand();
		this.model = vehicle.getModel();
		this.year = vehicle.getYear();
	}

	public String getId() {
		return id;
	}

	@JsonSetter(value = "CodigoFipe")
	public void setId(String id) {
		this.id = id;
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
}
