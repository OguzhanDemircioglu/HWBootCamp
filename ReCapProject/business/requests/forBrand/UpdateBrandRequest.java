package com.etiya.RentACarSpring.RentACar.business.requests.forBrand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateBrandRequest {
	
	private int brandId;
	private String brandName;
}
