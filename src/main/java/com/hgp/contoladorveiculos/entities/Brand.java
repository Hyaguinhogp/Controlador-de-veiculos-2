package com.hgp.contoladorveiculos.entities;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Brand {

	private Long id;
	private String name;
	
	public Brand() {
	}

	public Long getId() {
		return id;
	}

	@JsonSetter(value = "codigo")
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@JsonSetter(value = "nome")
	public void setName(String name) {
		this.name = name;
	}
}
