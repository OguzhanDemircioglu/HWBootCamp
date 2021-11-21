package com.RentACar.RentACar.business.abstracts;

import java.util.List;

import com.RentACar.RentACar.business.dtos.BrandSearchListDto;
import com.RentACar.RentACar.business.requests.CreateBrandRequest;
import com.RentACar.RentACar.business.requests.DeleteBrandRequest;
import com.RentACar.RentACar.business.requests.UpdateBrandRequest;
import com.RentACar.RentACar.core.utilities.results.DataResult;
import com.RentACar.RentACar.core.utilities.results.Result;

public interface BrandService {

	DataResult <List<BrandSearchListDto>> getAll();
	Result save(CreateBrandRequest createBrandRequest);
	Result delete(DeleteBrandRequest deleteBrandRequest);
	Result update(UpdateBrandRequest UpdateBrandRequest);
}
