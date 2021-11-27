package com.etiya.RentACarSpring.RentACar.business.concrates;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACarSpring.RentACar.business.abstracts.IndividualCustomerService;
import com.etiya.RentACarSpring.RentACar.business.dtos.IndividualCustomerSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forUsers.IndividualCustomer.CreateIndividualCustomerRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forUsers.IndividualCustomer.DeleteIndividualCustomerRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forUsers.IndividualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessDataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessResult;
import com.etiya.RentACarSpring.RentACar.dataAccess.forUser.IndividualCustomerDao;
import com.etiya.RentACarSpring.RentACar.entities.forUser.IndividualCustomer;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {
	
	private IndividualCustomerDao individualCustomerDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao,ModelMapperService modelMapperService) {
		super();
		this.individualCustomerDao = individualCustomerDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
		List<IndividualCustomer> result = this.individualCustomerDao.findAll();
		List<IndividualCustomerSearchListDto> response = result.stream()
				.map(individualCustomer->modelMapperService.forDto()
						.map(individualCustomer,IndividualCustomerSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<IndividualCustomerSearchListDto>>(response);
	}

	@Override
	public Result add(CreateIndividualCustomerRequest createIndividualRequest) {
		IndividualCustomer individualCustomer = modelMapperService.forRequest().map(createIndividualRequest,IndividualCustomer.class);
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult("Bireysel Müşteri Eklendi.");
			}

	@Override
	public Result delete(DeleteIndividualCustomerRequest deleteIndividualRequest) {
		IndividualCustomer individualCustomer=modelMapperService.forRequest().map(deleteIndividualRequest, IndividualCustomer.class);
		this.individualCustomerDao.delete(individualCustomer);
		return new SuccessResult("Bireysel Müşteri silindi");
	}

	@Override
	public Result update(UpdateIndividualCustomerRequest updateIndividualRequest) {

		IndividualCustomer individualCustomer=modelMapperService.forRequest().map(updateIndividualRequest, IndividualCustomer.class);
		this.individualCustomerDao.delete(individualCustomer);
		return new SuccessResult("Bireysel Müşteri Güncellendi");
	}

	@Override
	public DataResult<IndividualCustomerSearchListDto> getByIndividualCustomerId(int individualCustomerId) {
		
		IndividualCustomer individualCustomer = this.individualCustomerDao.getById(individualCustomerId);
		IndividualCustomerSearchListDto customerSearchListDto = modelMapperService.forRequest().map(individualCustomer,IndividualCustomerSearchListDto.class);
			return new SuccessDataResult<IndividualCustomerSearchListDto>(customerSearchListDto);
	}
}