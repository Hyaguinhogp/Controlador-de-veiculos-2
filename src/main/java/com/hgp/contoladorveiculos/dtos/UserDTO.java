package com.hgp.contoladorveiculos.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.hgp.contoladorveiculos.entities.User;
import com.hgp.contoladorveiculos.entities.Vehicle;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "O nome não pode estar vazio.")
	private String name;
	@NotBlank(message = "O email não pode estar vazio.")
	private String email;
	@NotBlank(message = "O cpf não pode estar vazio.")
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyy", shape = Shape.STRING)
	private LocalDate birthDate;
	private List<VehicleDTO> vehicles = new ArrayList<>();
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email, String cpf, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
		this.birthDate = user.getBirthDate();
	}

	public UserDTO(User user, Set<Vehicle> vehicles) {
		this(user);
		for(Vehicle vehicle : vehicles) {
			this.vehicles.add(new VehicleGetDTO(vehicle));
		}
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<VehicleDTO> getVehicles() {
		return vehicles;
	}
}
