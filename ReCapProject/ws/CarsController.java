package com.etiya.RentACarSpring.RentACar.ws;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.RentACarSpring.RentACar.business.abstracts.CarService;
import com.etiya.RentACarSpring.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forCar.CreateCarRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forCar.DeleteCarRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forCar.UpdateCarRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;
import com.etiya.RentACarSpring.RentACar.entities.complexTypies.CarBrandDetail;
import com.etiya.RentACarSpring.RentACar.entities.complexTypies.CarColorDetail;
import com.etiya.RentACarSpring.RentACar.entities.complexTypies.CarDetail;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

	private CarService carService;

	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCarRequest createCarRequest) {

		return this.carService.add(createCarRequest);
	}

	@PutMapping("/update")
	public Result update(UpdateCarRequest updateCarRequest) {
		return this.carService.update(updateCarRequest);

	}

	@DeleteMapping("/delete")
	public Result delete(DeleteCarRequest deleteCarRequest) {
		return this.carService.delete(deleteCarRequest);

	}

	@GetMapping("/getAll")
	public DataResult<List<CarSearchListDto>> getAll() {
		return this.carService.getAll();
	}
	@GetMapping("/getCarWithBrandAndColorDetails")
	public DataResult<List<CarDetail>> getCarWithBrandAndColorDetails() {
		return this.carService.getCarWithBrandAndColorDetails();
	}

	@GetMapping("/getCar")
	public DataResult<CarSearchListDto> getCar(int id) {
		return this.carService.getById(id);
	}
	@GetMapping("/getCarByBrandId")
	public DataResult<List<CarBrandDetail>> getCarByBrandId(int brandId) {
		return this.carService.getByBrandId(brandId);
	}
		@GetMapping("/getCarByColorId")
	public DataResult<List<CarColorDetail>> getCarByColorId(int colorId) {
		return this.carService.getByColorId(colorId);
	}
}