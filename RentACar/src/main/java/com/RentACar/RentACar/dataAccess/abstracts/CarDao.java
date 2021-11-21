package com.RentACar.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RentACar.RentACar.entities.Car;

public interface CarDao extends JpaRepository<Car, Integer> {
	
}
