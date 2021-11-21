package com.RentACar.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RentACar.RentACar.entities.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer>{

}
