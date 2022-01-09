package com.hgp.contoladorveiculos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hgp.contoladorveiculos.dtos.VehicleDTO;
import com.hgp.contoladorveiculos.services.VehicleService;

@RestController
@RequestMapping(path = "/veiculos")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping
	public ResponseEntity<VehicleDTO> get(@RequestBody VehicleDTO dto){
		dto = vehicleService.getVehicle(dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<VehicleDTO> insertVehicle(@Valid @RequestBody VehicleDTO dto){
		dto = vehicleService.insertVehicle(dto);
		return ResponseEntity.ok().body(dto);
	}
}
