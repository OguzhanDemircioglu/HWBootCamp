package com.etiya.RentACarSpring.RentACar.business.requests.forCar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCarRequest {
	
	private int id;
	
	private int modelYear;

	private int dailyPrice;

	private String description;

	private int colorId;

	private int brandId;
}
