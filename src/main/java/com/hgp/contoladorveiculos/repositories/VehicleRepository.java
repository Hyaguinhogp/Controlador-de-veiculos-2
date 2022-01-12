package com.hgp.contoladorveiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hgp.contoladorveiculos.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
