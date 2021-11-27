package com.etiya.RentACarSpring.RentACar.dataAccess.forRent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.RentACarSpring.RentACar.business.dtos.RentalSearchListDto;
import com.etiya.RentACarSpring.RentACar.entities.forRent.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer> {
	
	@Query("select new com.etiya.ReCapProject.business.dtos.RentalSearchListDto"
			+ "(c.id, r.returnDate) "
			+ "From Car c Inner Join c.rentals r where c.id=:carId and r.returnDate is null")
	RentalSearchListDto getByCarIdWhereReturnDateIsNull(int carId);
	
}
