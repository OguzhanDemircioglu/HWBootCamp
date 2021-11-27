package com.etiya.RentACarSpring.RentACar.business.requests.forRent;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	
	public class UpdateRentalRequest {
		
		private int id;
		private LocalDate rentDate;
		private LocalDate returnDate;
}
