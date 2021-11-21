package com.RentACar.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RentACar.RentACar.business.abstracts.ColorService;
import com.RentACar.RentACar.business.dtos.ColorSearchListDto;
import com.RentACar.RentACar.business.requests.CreateColorRequest;
import com.RentACar.RentACar.business.requests.DeleteColorRequest;
import com.RentACar.RentACar.business.requests.UpdateColorRequest;
import com.RentACar.RentACar.core.utilities.mapping.ModelMapperService;
import com.RentACar.RentACar.core.utilities.results.DataResult;
import com.RentACar.RentACar.core.utilities.results.Result;
import com.RentACar.RentACar.core.utilities.results.SuccessDataResult;
import com.RentACar.RentACar.core.utilities.results.SuccessResult;
import com.RentACar.RentACar.dataAccess.abstracts.ColorDao;
import com.RentACar.RentACar.entities.Color;

@Service
public class ColorManager implements ColorService {

	private ColorDao colorDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		super();
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}
	
	@Override
	public DataResult<List<ColorSearchListDto>> getAll() {
		
		List<Color> result = this.colorDao.findAll();
		
		List <ColorSearchListDto> response = result.stream()
				.map(Color->modelMapperService.forDto()
						.map(Color, ColorSearchListDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult <List<ColorSearchListDto>> (response,"Renkler Listelendi");
	}
	
	@Override
	public Result save(CreateColorRequest createColorRequest) {
		Color color = modelMapperService.forRequest().map(createColorRequest, Color.class);
		this.colorDao.save(color);
		return new SuccessResult("Renk Eklendi");
	}
	
	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {
		
		Color color =modelMapperService.forRequest().map(deleteColorRequest, Color.class);
		this.colorDao.delete(color);
		return new SuccessResult("Renk Silindi");
	}
	
	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
		
		Color color =modelMapperService.forRequest().map(updateColorRequest, Color.class);
		this.colorDao.save(color);
		return new SuccessResult("Renk Güncellendi");
	}
}
