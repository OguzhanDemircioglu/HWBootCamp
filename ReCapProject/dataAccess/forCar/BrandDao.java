package com.etiya.RentACarSpring.RentACar.dataAccess.forCar;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.RentACarSpring.RentACar.entities.forCar.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer> {

	boolean existsByBrandName(String brandName);

}
