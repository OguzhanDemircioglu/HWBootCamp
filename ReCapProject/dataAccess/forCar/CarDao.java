package com.etiya.RentACarSpring.RentACar.dataAccess.forCar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.RentACarSpring.RentACar.entities.complexTypies.CarDetail;
import com.etiya.RentACarSpring.RentACar.entities.forCar.Car;

public interface CarDao extends JpaRepository<Car, Integer>{

	@Query( "Select new com.etiya.ReCapProject.entities.concretes.complexTypes.CarDetail "
			+ "(c.id,b.brandName,co.colorName,c.dailyPrice)" + "From Car c Inner Join c.brand b Inner Join c.color co ")
	List<CarDetail> CarWithBrandAndColorDetails();
	
	List<Car> getByBrand_Id(int brandId);
	
	List<Car> getByColor_Id(int colorId);
	
	List<CarDetail> getByBrand_BrandName(String brandName);
}
