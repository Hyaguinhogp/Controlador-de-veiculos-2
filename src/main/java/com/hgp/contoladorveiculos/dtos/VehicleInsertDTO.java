package com.hgp.contoladorveiculos.dtos;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.hgp.contoladorveiculos.entities.Vehicle;

public class VehicleInsertDTO extends VehicleDTO{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String type;
	
	public VehicleInsertDTO() {
	}
	
	public VehicleInsertDTO(Vehicle vehicle) {
		super(vehicle);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getType() {
		return type;
	}
	
	@JsonSetter(value = "TipoVeiculo")
	public void setType(String type) {
		this.type = type;
	}
}
