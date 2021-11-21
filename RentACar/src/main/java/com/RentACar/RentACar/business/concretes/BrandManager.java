package com.RentACar.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RentACar.RentACar.business.abstracts.BrandService;
import com.RentACar.RentACar.business.dtos.BrandSearchListDto;
import com.RentACar.RentACar.business.requests.CreateBrandRequest;
import com.RentACar.RentACar.business.requests.DeleteBrandRequest;
import com.RentACar.RentACar.business.requests.UpdateBrandRequest;
import com.RentACar.RentACar.core.utilities.mapping.ModelMapperService;
import com.RentACar.RentACar.core.utilities.results.DataResult;
import com.RentACar.RentACar.core.utilities.results.Result;
import com.RentACar.RentACar.core.utilities.results.SuccessDataResult;
import com.RentACar.RentACar.core.utilities.results.SuccessResult;
import com.RentACar.RentACar.dataAccess.abstracts.BrandDao;
import com.RentACar.RentACar.entities.Brand;

@Service
public class BrandManager implements BrandService{

	private BrandDao brandDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		super();
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<BrandSearchListDto>> getAll() {

		List <Brand> result =this.brandDao.findAll();
		
		List <BrandSearchListDto> response =result.stream()
				.map(Brand->modelMapperService.forDto()
						.map(Brand, BrandSearchListDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<BrandSearchListDto>>(response,"Markalar Listelendi");
	}

	@Override
	public Result save(CreateBrandRequest createBrandRequest) {
		Brand brand =modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandDao.save(brand);
		return new SuccessResult("Marka Eklendi");
	}
	
	@Override
	public Result update(UpdateBrandRequest UpdateBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(UpdateBrandRequest, Brand.class);
		this.brandDao.save(brand);
		return new SuccessResult("Marka Güncellendi");
	}
	
	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand=modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
		this.brandDao.delete(brand);
		return new SuccessResult("Marka Silindi");
	}

	

}
