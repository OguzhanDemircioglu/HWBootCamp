package com.RentACar.RentACar.business.abstracts;

import java.util.List;

import com.RentACar.RentACar.business.dtos.ColorSearchListDto;
import com.RentACar.RentACar.business.requests.CreateColorRequest;
import com.RentACar.RentACar.business.requests.DeleteColorRequest;
import com.RentACar.RentACar.business.requests.UpdateColorRequest;
import com.RentACar.RentACar.core.utilities.results.DataResult;
import com.RentACar.RentACar.core.utilities.results.Result;

public interface ColorService {

	DataResult <List<ColorSearchListDto>> getAll();
	Result save (CreateColorRequest createColorRequest);
	Result delete (DeleteColorRequest deleteColorRequest);
	Result update (UpdateColorRequest updateColorRequest);
}
