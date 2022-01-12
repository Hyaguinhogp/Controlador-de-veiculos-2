package com.hgp.contoladorveiculos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgp.contoladorveiculos.dtos.UserDTO;
import com.hgp.contoladorveiculos.entities.User;
import com.hgp.contoladorveiculos.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		User user = userRepository.findById(id).get();
		UserDTO dto = new UserDTO(user, user.getVehicles());
		return dto;
	}
	
	@Transactional
	public UserDTO insertUser(UserDTO dto) {
		User user = dtoToUser(dto);
		userRepository.save(user);
		return new UserDTO(user);
	}
	
	private User dtoToUser(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setCpf(dto.getCpf());
		user.setBirthDate(dto.getBirthDate());
		return user;
	}

	
}
