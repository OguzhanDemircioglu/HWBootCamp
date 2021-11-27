package com.etiya.RentACarSpring.RentACar.business.concrates;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.etiya.RentACarSpring.RentACar.business.abstracts.BrandService;
import com.etiya.RentACarSpring.RentACar.business.dtos.BrandSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forBrand.CreateBrandRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forBrand.DeleteBrandRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forBrand.UpdateBrandRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.Business.BusinessRules;
import com.etiya.RentACarSpring.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.ErrorResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessDataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessResult;
import com.etiya.RentACarSpring.RentACar.dataAccess.forCar.BrandDao;
import com.etiya.RentACarSpring.RentACar.entities.forCar.Brand;

@Service
@ConfigurationProperties
public class BrandManager implements BrandService{
	private BrandDao brandDao;
	private ModelMapperService modelMapperService;
	
	@Value("${imagePath}")
	private String path;
	
	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		super();
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<BrandSearchListDto>> getAll() {
		List<Brand> result = this.brandDao.findAll();
		List<BrandSearchListDto> response = result.stream().map(brand -> modelMapperService.forDto().map(brand, BrandSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<BrandSearchListDto>>(response, "Markalar listelendi.");
	}

	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		
		var result = BusinessRules.run(this.checkBrandByBrandName(createBrandRequest.getBrandName()));

		if (result != null) {
			return result;
		}
		
		Brand adding = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandDao.save(adding);
		
		return new SuccessResult("Marka eklendi"+ path);
	}

	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) {
		Brand result = modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
		this.brandDao.delete(result);
		return new SuccessResult("Marka silindi");
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		Brand result = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandDao.save(result);
		return new SuccessResult("Marka güncellendi");
	}

	@Override
	public DataResult<BrandSearchListDto> getByBrandId(int brandId) {
		Brand brand= this.brandDao.findById(brandId).get();
		BrandSearchListDto brandSearchListDto=modelMapperService.forDto().map(brand, BrandSearchListDto.class);
		return new SuccessDataResult<BrandSearchListDto>(brandSearchListDto);
		
	}
	
	private Result checkBrandByBrandName(String brandName) {

		if (this.brandDao.existsByBrandName(brandName)) {
			return new ErrorResult("Bu marka daha önce yüklendi");
		}
		return new SuccessResult();
	}
}
