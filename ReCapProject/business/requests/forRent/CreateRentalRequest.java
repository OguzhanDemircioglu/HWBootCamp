package com.etiya.RentACarSpring.RentACar.business.requests.forRent;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	
	public class CreateRentalRequest {
		
		private int carId;
		private int individualCustomerId;
		
		@JsonIgnore
		private LocalDate rentDate;
		
		private LocalDate returnDate;
}