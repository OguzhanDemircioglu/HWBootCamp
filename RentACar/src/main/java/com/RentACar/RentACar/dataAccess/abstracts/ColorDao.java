package com.RentACar.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RentACar.RentACar.entities.Color;

public interface ColorDao extends JpaRepository<Color, Integer> {

}
