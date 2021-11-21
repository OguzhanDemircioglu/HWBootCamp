package com.RentACar.RentACar.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RentACar.RentACar.business.abstracts.CarService;
import com.RentACar.RentACar.business.dtos.CarSearchListDto;
import com.RentACar.RentACar.business.requests.CreateCarRequest;
import com.RentACar.RentACar.business.requests.DeleteCarRequest;
import com.RentACar.RentACar.business.requests.UpdateCarRequest;
import com.RentACar.RentACar.core.utilities.results.DataResult;
import com.RentACar.RentACar.core.utilities.results.Result;

@RestController
@RequestMapping("api/cars")
public class CarsContoller {

	private CarService carService;

	@Autowired
	private CarsContoller(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<CarSearchListDto>> getAll(){
		return this.carService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody CreateCarRequest createCarRequest) {
		return this.carService.save(createCarRequest);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody UpdateCarRequest updateCarRequest) {
		return this.carService.update(updateCarRequest);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody DeleteCarRequest deleteCarRequest) {
		return this.carService.delete(deleteCarRequest);
	}
	
}
