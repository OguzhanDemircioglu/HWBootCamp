package com.etiya.RentACarSpring.RentACar.business.concrates;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACarSpring.RentACar.business.abstracts.ColorService;
import com.etiya.RentACarSpring.RentACar.business.dtos.ColorSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forColor.CreateColorRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forColor.DeleteColorRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forColor.UpdateColorRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessDataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessResult;
import com.etiya.RentACarSpring.RentACar.dataAccess.forCar.ColorDao;
import com.etiya.RentACarSpring.RentACar.entities.forCar.Color;

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
		List<ColorSearchListDto> response = result.stream()
				.map(color -> modelMapperService.forDto().map(color, ColorSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ColorSearchListDto>>(response, "Arabalar listelendi.");
	}

	@Override
	public Result add(CreateColorRequest createColorRequest) {

		Color result = modelMapperService.forRequest().map(createColorRequest, Color.class);
		this.colorDao.save(result);
		return new SuccessResult("Renk eklendi.");
	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {
		Color color= modelMapperService.forRequest().map(deleteColorRequest, Color.class);
		this.colorDao.delete(color);
		return new SuccessResult("Renk Silindi.");
	}

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
		Color color= modelMapperService.forRequest().map(updateColorRequest, Color.class);
		this.colorDao.save(color);
		return new SuccessResult("Renk güncellendi.");
	}

	@Override
	public DataResult<ColorSearchListDto> getByColorId(int colorId) {
		Color color = this.colorDao.findById(colorId).get();
		ColorSearchListDto response = modelMapperService.forDto().map(color ,ColorSearchListDto.class);
		return new SuccessDataResult<ColorSearchListDto>(response,"Renge ait arabalar");
	}

}
