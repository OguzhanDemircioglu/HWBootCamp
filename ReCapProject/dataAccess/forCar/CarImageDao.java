package com.etiya.RentACarSpring.RentACar.dataAccess.forCar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.RentACarSpring.RentACar.entities.forCar.CarImage;

public interface CarImageDao extends JpaRepository<CarImage, Integer>{
	
	List<CarImage> getByCar_Id(int id);
	
	int countCarImagesByCar_Id(int id);

}
