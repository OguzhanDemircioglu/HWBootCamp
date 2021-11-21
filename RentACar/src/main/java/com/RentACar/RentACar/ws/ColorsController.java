package com.RentACar.RentACar.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RentACar.RentACar.business.abstracts.ColorService;
import com.RentACar.RentACar.business.dtos.ColorSearchListDto;
import com.RentACar.RentACar.business.requests.CreateColorRequest;
import com.RentACar.RentACar.business.requests.DeleteColorRequest;
import com.RentACar.RentACar.business.requests.UpdateColorRequest;
import com.RentACar.RentACar.core.utilities.results.DataResult;
import com.RentACar.RentACar.core.utilities.results.Result;

@RestController
@RequestMapping("api/colors")
public class ColorsController {

	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@GetMapping("getAll")
	public DataResult <List<ColorSearchListDto>> getAll(){
		return this.colorService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody CreateColorRequest createColorRequest){
		return this.colorService.save(createColorRequest);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody UpdateColorRequest updateColorRequest) {
		return this.colorService.update(updateColorRequest);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {
		return this.colorService.delete(deleteColorRequest);
	}
}
