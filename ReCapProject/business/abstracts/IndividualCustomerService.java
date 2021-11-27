package com.etiya.RentACarSpring.RentACar.business.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.RentACar.business.dtos.IndividualCustomerSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forUsers.IndividualCustomer.CreateIndividualCustomerRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forUsers.IndividualCustomer.DeleteIndividualCustomerRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forUsers.IndividualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;

public interface IndividualCustomerService {
	
	DataResult<List<IndividualCustomerSearchListDto>> getAll();
	Result add(CreateIndividualCustomerRequest createIndividualRequest);
	Result delete(DeleteIndividualCustomerRequest deleteIndividualRequest);
	Result update(UpdateIndividualCustomerRequest updateIndividualRequest);
	DataResult<IndividualCustomerSearchListDto> getByIndividualCustomerId(int individualCustomerId);
	
}
