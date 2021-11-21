package com.RentACar.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RentACar.RentACar.business.abstracts.CarService;
import com.RentACar.RentACar.business.dtos.CarSearchListDto;
import com.RentACar.RentACar.business.requests.CreateCarRequest;
import com.RentACar.RentACar.business.requests.DeleteCarRequest;
import com.RentACar.RentACar.business.requests.UpdateCarRequest;
import com.RentACar.RentACar.core.utilities.mapping.ModelMapperService;
import com.RentACar.RentACar.core.utilities.results.DataResult;
import com.RentACar.RentACar.core.utilities.results.Result;
import com.RentACar.RentACar.core.utilities.results.SuccessDataResult;
import com.RentACar.RentACar.core.utilities.results.SuccessResult;
import com.RentACar.RentACar.dataAccess.abstracts.CarDao;
import com.RentACar.RentACar.entities.Car;

@Service
public class CarManager implements CarService {

	
	private CarDao carDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	private CarManager(CarDao carDao, ModelMapperService modelMapperService) {
		super();
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CarSearchListDto>> getAll() {
		
		List<Car> result=this.carDao.findAll();
		
		List<CarSearchListDto> response=result.stream()
				.map(car->modelMapperService.forDto()
						.map(car, CarSearchListDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult <List<CarSearchListDto>> (response,"Arabalar listelendi");
	}

	@Override
	public Result save(CreateCarRequest createCarRequest) {
		Car car=modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carDao.save(car);
		return new SuccessResult("Araba eklendi");
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Car car=modelMapperService.forRequest().map(updateCarRequest, Car.class);
		carDao.save(car);
		return new SuccessResult("Araba güncellendi");
		
	}

	@Override
	public Result delete(DeleteCarRequest DeleteCarRequest) {
		Car car=modelMapperService.forRequest().map(DeleteCarRequest, Car.class);
		this.carDao.delete(car);
		return new SuccessResult("Araba silindi");
	}

	
}
