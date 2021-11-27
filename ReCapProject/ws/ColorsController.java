package com.etiya.RentACarSpring.RentACar.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.RentACarSpring.RentACar.business.abstracts.ColorService;
import com.etiya.RentACarSpring.RentACar.business.dtos.ColorSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forColor.CreateColorRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forColor.DeleteColorRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forColor.UpdateColorRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {
	
	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	@GetMapping("getAll")
	public DataResult<List<ColorSearchListDto>> getAll(){
		return this.colorService.getAll();
	}
	@DeleteMapping("delete")
	public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {
		return this.colorService.delete(deleteColorRequest);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody UpdateColorRequest updateColorRequest){
		return this.colorService.update(updateColorRequest);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateColorRequest createColorRequest){
		return this.colorService.add(createColorRequest);
	}
	
	@GetMapping("/getColor")
	public DataResult<ColorSearchListDto> getColor(int id){
		return this.colorService.getByColorId(id);
	}

}
