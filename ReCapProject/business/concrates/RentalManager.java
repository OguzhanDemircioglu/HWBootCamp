package com.etiya.RentACarSpring.RentACar.business.concrates;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACarSpring.RentACar.business.abstracts.CarService;
import com.etiya.RentACarSpring.RentACar.business.abstracts.RentalService;
import com.etiya.RentACarSpring.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.dtos.RentalSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forRent.CreateRentalRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forRent.DeleteRentalRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forRent.UpdateRentalRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.Business.BusinessRules;
import com.etiya.RentACarSpring.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.ErrorResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessDataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.services.findex.FindexService;
import com.etiya.RentACarSpring.RentACar.dataAccess.forRent.RentalDao;
import com.etiya.RentACarSpring.RentACar.entities.forRent.Rental;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private ModelMapperService modelMapperService;
	private FindexService findexService;
	private CarService carService;
	
	@Autowired
	public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService,
			FindexService findexService,CarService carService) 
	{
		super();
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
		this.findexService= findexService;
		this.carService=carService;
	}

	@Override
	public DataResult<List<RentalSearchListDto>> getAll() {
		List<Rental> result = this.rentalDao.findAll();
		List<RentalSearchListDto> response = result.stream()
				.map(rental -> modelMapperService.forDto().map(rental, RentalSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<RentalSearchListDto>>(response, "Rental listed");
	}

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {
		Result result=BusinessRules.run(checkIfReturnDateIsNull(createRentalRequest.getCarId()),
				checkFindexScore(createRentalRequest.getCarId()));
		if (result!=null) {
			return result;
		}
		
		Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		rental.setRentDate(LocalDate.now());
		this.rentalDao.save(rental);
		return new SuccessResult("Araba kiralandı");
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		Rental rental = modelMapperService.forRequest().map(deleteRentalRequest, Rental.class);
		this.rentalDao.delete(rental);
		return new SuccessResult("Kiralama silindi");
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		Rental rental = modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
		rentalDao.save(rental);
		return new SuccessResult("Kiralama güncellendi");
	}
	
	private Result checkIfReturnDateIsNull(int carId) {
		RentalSearchListDto rental = this.rentalDao.getByCarIdWhereReturnDateIsNull(carId);
		if (rental!=null) {
			return new ErrorResult("Bu araba şuan kiralanamaz");
		}
		return new SuccessResult();
		
	}
	
	private Result checkFindexScore(int carId) {
		DataResult<CarSearchListDto> car =carService.getById(carId);
		
		int CarFindexScore=car.getData().getFindexScore();
		int CustomerFindexScore=findexService.findexScore();
		
		if(CarFindexScore>CustomerFindexScore) {
			return new ErrorResult("Findex Puanınız bu arabayı kiralamak için yeterli değil");
		}	
		return new SuccessResult();
	
	}

}