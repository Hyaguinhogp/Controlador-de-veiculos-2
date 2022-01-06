package com.hgp.contoladorveiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hgp.contoladorveiculos.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
