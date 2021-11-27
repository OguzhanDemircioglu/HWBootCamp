package com.etiya.RentACarSpring.RentACar.business.concrates;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACarSpring.RentACar.business.abstracts.CarService;
import com.etiya.RentACarSpring.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forCar.CreateCarRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forCar.DeleteCarRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forCar.UpdateCarRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessDataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessResult;
import com.etiya.RentACarSpring.RentACar.dataAccess.forCar.CarDao;
import com.etiya.RentACarSpring.RentACar.entities.complexTypies.CarBrandDetail;
import com.etiya.RentACarSpring.RentACar.entities.complexTypies.CarColorDetail;
import com.etiya.RentACarSpring.RentACar.entities.complexTypies.CarDetail;
import com.etiya.RentACarSpring.RentACar.entities.forCar.Car;

	@Service
	public class CarManager implements CarService {

		private CarDao carDao;
		private ModelMapperService modelMapperService;

		@Autowired
		public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
			super();
			this.carDao = carDao;
			this.modelMapperService = modelMapperService;
		}
		@Override
		public DataResult<List<CarSearchListDto>> getAll() {
			List<Car> result = this.carDao.findAll();
			List<CarSearchListDto> response = result.stream()
					.map(car -> modelMapperService.forDto()
							.map(car, CarSearchListDto.class)).collect(Collectors.toList());
			return new SuccessDataResult<List<CarSearchListDto>>(response, "Arabalar listelendi.");
		}

		@Override
		public Result add(CreateCarRequest createCarRequest) {
			Car result = modelMapperService.forRequest().map(createCarRequest, Car.class);
			this.carDao.save(result);
			return new SuccessResult("Araba eklendi.");
		}

		@Override
		public Result update(UpdateCarRequest updateCarRequest) {
			Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
			this.carDao.save(car);
			return new SuccessResult("Araba güncellendi.");
		}

		@Override
		public Result delete(DeleteCarRequest deleteCarRequest) {
			Car car = modelMapperService.forRequest().map(deleteCarRequest, Car.class);
			this.carDao.delete(car);
			return new SuccessResult("Araba silindi");
		}

		@Override
		public DataResult<CarSearchListDto> getById(int carId) {
			Car car = this.carDao.findById(carId).get();
			CarSearchListDto response = modelMapperService.forDto().map(car, CarSearchListDto.class);
			return new SuccessDataResult<CarSearchListDto>(response, "Id'ye göre araba getirildi.");
		}

		@Override
		public DataResult<List<CarDetail>> getCarWithBrandAndColorDetails() {
			
			return new SuccessDataResult<List<CarDetail>>(this.carDao.CarWithBrandAndColorDetails());
		}

		@Override
		public DataResult<List<CarBrandDetail>> getByBrandId(int brandId) {
			List<Car> cars=this.carDao.getByBrand_Id(brandId);
			List<CarBrandDetail> result=cars.stream().map(car -> modelMapperService.forDto().map(car, CarBrandDetail.class)).collect(Collectors.toList());
			return new SuccessDataResult<List<CarBrandDetail>>(result);
		}

		@Override
		public DataResult<List<CarColorDetail>> getByColorId(int colorId) {
			List<Car> cars = this.carDao.getByColor_Id(colorId);
			List<CarColorDetail> result=cars.stream().map(car -> modelMapperService.forDto().map(car, CarColorDetail.class)).collect(Collectors.toList());
			return new SuccessDataResult<List<CarColorDetail>>(result);
		
		}
	}
