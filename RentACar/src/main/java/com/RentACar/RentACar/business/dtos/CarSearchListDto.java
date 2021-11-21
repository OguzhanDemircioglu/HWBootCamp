package com.RentACar.RentACar.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarSearchListDto {
	
	private int modelYear;
	private int dailyPrice;
	private String description;
}
