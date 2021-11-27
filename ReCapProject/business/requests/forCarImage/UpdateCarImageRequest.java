package com.etiya.RentACarSpring.RentACar.business.requests.forCarImage;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCarImageRequest {
	
	private int id;
	private int carId;
	private String imagePath;
	private LocalDate imageDate;
	private MultipartFile file;
}