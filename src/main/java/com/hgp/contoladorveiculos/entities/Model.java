package com.hgp.contoladorveiculos.entities;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Model {

	private String id;
	private String name;
	
	public Model() {
	}

	public String getId() {
		return id;
	}

	@JsonSetter(value = "codigo")
	public void setId(String id) {
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
