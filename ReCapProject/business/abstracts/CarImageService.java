package com.etiya.RentACarSpring.RentACar.business.abstracts;

import java.io.IOException;
import java.util.List;

import com.etiya.RentACarSpring.RentACar.business.dtos.CarImageSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forCarImage.CreateCarImageRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forCarImage.DeleteCarImageRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forCarImage.UpdateCarImageRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;

public interface CarImageService {
	
	DataResult<List<CarImageSearchListDto>> getAll();
	Result add(CreateCarImageRequest createCarImageRequest) throws IOException;
	Result delete(DeleteCarImageRequest deleteCarImageRequest) throws IOException;
	Result update(UpdateCarImageRequest dpdateCarImageRequest) throws IOException;
	DataResult<List<CarImageSearchListDto>> getCarImagesByCarId(int id);
}
