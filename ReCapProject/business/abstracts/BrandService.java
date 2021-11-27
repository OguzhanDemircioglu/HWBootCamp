package com.etiya.RentACarSpring.RentACar.business.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.RentACar.business.dtos.BrandSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forBrand.CreateBrandRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forBrand.DeleteBrandRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forBrand.UpdateBrandRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;

public interface BrandService {
	
	DataResult<List<BrandSearchListDto>> getAll();
	Result add(CreateBrandRequest createBrandRequest);
	Result delete(DeleteBrandRequest deleteBrandRequest);
	Result update(UpdateBrandRequest updateBrandRequest);
	DataResult<BrandSearchListDto> getByBrandId(int brandId);
}
