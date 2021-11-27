package com.etiya.RentACarSpring.RentACar.dataAccess.forCar;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.RentACarSpring.RentACar.entities.forCar.Color;

public interface ColorDao extends JpaRepository<Color, Integer> {

}
