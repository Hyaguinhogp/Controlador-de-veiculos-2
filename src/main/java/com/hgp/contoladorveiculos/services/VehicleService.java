package com.hgp.contoladorveiculos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgp.contoladorveiculos.dtos.VehicleDTO;
import com.hgp.contoladorveiculos.dtos.VehicleInsertDTO;
import com.hgp.contoladorveiculos.entities.User;
import com.hgp.contoladorveiculos.entities.Vehicle;
import com.hgp.contoladorveiculos.repositories.UserRepository;
import com.hgp.contoladorveiculos.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private FipeService fipeService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Transactional
	public VehicleInsertDTO insertVehicle(VehicleInsertDTO dto) {
		User user = userRepository.findByName(dto.getUserName());
		dto = fipeService.getVehicle(dto);
		
		Vehicle vehicle = dtoToEntity(dto);
		vehicle.getUsers().add(user);
		user.getVehicles().add(vehicle);
		
		vehicleRepository.save(vehicle);
		userRepository.save(user);
		
		return dto;
	}
	
	private Vehicle dtoToEntity(VehicleDTO dto) {
		Vehicle vehicle = new Vehicle();
		
		vehicle.setId(dto.getId());
		vehicle.setModel(dto.getModel());
		vehicle.setBrand(dto.getBrand());
		vehicle.setYear(dto.getYear());
		
		return vehicle;
	}
}
