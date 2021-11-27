package com.etiya.RentACarSpring.RentACar.entities.complexTypies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarBrandDetail {
	private int brandId;
	private String description;
}
