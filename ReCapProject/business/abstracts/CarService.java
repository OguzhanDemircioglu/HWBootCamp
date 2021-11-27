package com.etiya.RentACarSpring.RentACar.business.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forCar.CreateCarRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forCar.DeleteCarRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forCar.UpdateCarRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;
import com.etiya.RentACarSpring.RentACar.entities.complexTypies.CarBrandDetail;
import com.etiya.RentACarSpring.RentACar.entities.complexTypies.CarColorDetail;
import com.etiya.RentACarSpring.RentACar.entities.complexTypies.CarDetail;

public interface CarService {

	DataResult<List<CarSearchListDto>> getAll();
	Result add(CreateCarRequest createCarRequest);
	Result update(UpdateCarRequest updateCarRequest);
	Result delete(DeleteCarRequest deleteCarRequest);
	DataResult<CarSearchListDto> getById(int carId);
	DataResult<List<CarDetail>> getCarWithBrandAndColorDetails();
	DataResult<List<CarBrandDetail>> getByBrandId(int brandId);
	DataResult<List<CarColorDetail>> getByColorId(int colorId);
	
}
