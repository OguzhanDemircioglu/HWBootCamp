package com.etiya.RentACarSpring.RentACar.business.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.RentACar.business.dtos.RentalSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forRent.CreateRentalRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forRent.DeleteRentalRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forRent.UpdateRentalRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;

public interface RentalService {
	
	DataResult<List<RentalSearchListDto>> getAll();
	Result add(CreateRentalRequest createRentalRequest);
	Result delete(DeleteRentalRequest deleteRentalRequest);
	Result update(UpdateRentalRequest updateRentalRequest);
	
}	

