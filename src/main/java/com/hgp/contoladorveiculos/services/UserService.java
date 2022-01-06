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
	
	@Transactional
	public UserDTO insertUser(UserDTO dto) {
		User user = dtoToUser(dto);
		userRepository.save(user);
		return dto;
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
