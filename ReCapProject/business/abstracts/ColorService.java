package com.etiya.RentACarSpring.RentACar.business.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.RentACar.business.dtos.ColorSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forColor.CreateColorRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forColor.DeleteColorRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forColor.UpdateColorRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;

public interface ColorService {
	
	DataResult<List<ColorSearchListDto>> getAll();
	Result add(CreateColorRequest createColorRequest);
	Result delete(DeleteColorRequest deleteColorRequest);
	Result update(UpdateColorRequest updateColorRequest);
	DataResult<ColorSearchListDto> getByColorId(int colorId);
	
}
