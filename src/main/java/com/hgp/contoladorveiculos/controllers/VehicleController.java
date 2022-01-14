package com.hgp.contoladorveiculos.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hgp.contoladorveiculos.dtos.VehicleDTO;
import com.hgp.contoladorveiculos.dtos.VehicleInsertDTO;
import com.hgp.contoladorveiculos.services.VehicleService;

@RestController
@RequestMapping(path = "/veiculos")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping
	public ResponseEntity<VehicleDTO> insertVehicle(@Valid @RequestBody VehicleInsertDTO dto){
		dto = vehicleService.insertVehicle(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
