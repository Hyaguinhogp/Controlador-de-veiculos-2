package com.hgp.contoladorveiculos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgp.contoladorveiculos.dtos.VehicleDTO;
import com.hgp.contoladorveiculos.entities.Vehicle;
import com.hgp.contoladorveiculos.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private FipeService fipeService;
	
	@Transactional(readOnly = true)
	public VehicleDTO getVehicle(VehicleDTO dto) {
		dto = fipeService.getVehicle(dto);
		Vehicle vehicle = dtoToEntity(dto);
		vehicleRepository.save(vehicle);
		return dto;
	}
	
	@Transactional
	public VehicleDTO insertVehicle(VehicleDTO dto) {
		dto = fipeService.getVehicle(dto);
		Vehicle vehicle = dtoToEntity(dto);
		vehicleRepository.save(vehicle);
		return dto;
	}
	
	private Vehicle dtoToEntity(VehicleDTO dto) {
		Vehicle vehicle = new Vehicle();
		
		vehicle.setModel(dto.getModel());
		vehicle.setBrand(dto.getBrand());
		vehicle.setYear(dto.getYear());
		
		return vehicle;
	}
}
