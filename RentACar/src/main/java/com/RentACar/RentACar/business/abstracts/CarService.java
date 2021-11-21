package com.RentACar.RentACar.business.abstracts;

import java.util.List;

import com.RentACar.RentACar.business.dtos.CarSearchListDto;
import com.RentACar.RentACar.business.requests.CreateCarRequest;
import com.RentACar.RentACar.business.requests.DeleteCarRequest;
import com.RentACar.RentACar.business.requests.UpdateCarRequest;
import com.RentACar.RentACar.core.utilities.results.DataResult;
import com.RentACar.RentACar.core.utilities.results.Result;

public interface CarService {
	
	DataResult<List<CarSearchListDto>> getAll();
	Result save(CreateCarRequest createCarRequest);
	Result update(UpdateCarRequest updateCarRequest);
	Result delete(DeleteCarRequest DeleteCarRequest);
}
