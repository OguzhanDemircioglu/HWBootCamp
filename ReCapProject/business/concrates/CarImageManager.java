package com.etiya.RentACarSpring.RentACar.business.concrates;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.RentACarSpring.RentACar.business.abstracts.CarImageService;
import com.etiya.RentACarSpring.RentACar.business.dtos.CarImageSearchListDto;
import com.etiya.RentACarSpring.RentACar.business.requests.forCarImage.CreateCarImageRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forCarImage.DeleteCarImageRequest;
import com.etiya.RentACarSpring.RentACar.business.requests.forCarImage.UpdateCarImageRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.Business.BusinessRules;
import com.etiya.RentACarSpring.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.DataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.ErrorResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessDataResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessResult;
import com.etiya.RentACarSpring.RentACar.dataAccess.forCar.CarImageDao;
import com.etiya.RentACarSpring.RentACar.entities.forCar.CarImage;

@Service
@ConfigurationProperties
public class CarImageManager implements CarImageService {
	private CarImageDao carImageDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CarImageManager(CarImageDao carImageDao, ModelMapperService modelMapperService) {
		super();
		this.carImageDao = carImageDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CarImageSearchListDto>> getAll() {
		List<CarImage> carImages = this.carImageDao.findAll();
		List<CarImageSearchListDto> result = carImages.stream()
				.map(carImage -> modelMapperService.forDto().map(carImage, CarImageSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CarImageSearchListDto>>(result, "Otomobil görselleri listelendi.");
	}

	@Override
	public Result add(CreateCarImageRequest createCarImageRequest) throws IOException {
		Result result = BusinessRules.run(checkNumberOfCarImages(createCarImageRequest.getCarId()));
		if (result != null) {
			return result;
		}

		CarImage carImage = modelMapperService.forRequest().map(createCarImageRequest, CarImage.class);
		carImage.setDate(LocalDate.now());
		carImage.setImagePath(generateImage(createCarImageRequest.getFile()).toString());
		this.carImageDao.save(carImage);
		return new SuccessResult("Arabaya resim eklendi");
	}

	@Override
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		var result = this.carImageDao.getById(deleteCarImageRequest.getId());
		this.carImageDao.delete(result);
		return new SuccessResult("Araba resmi silindi.");
	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) throws IOException {
		CarImage carImage = modelMapperService.forRequest().map(updateCarImageRequest, CarImage.class);
		carImage.setDate(LocalDate.now());
		carImage.setImagePath(generateImage(updateCarImageRequest.getFile()).toString());
		this.carImageDao.save(carImage);
		return new SuccessResult("Arabaya ait resimler güncellendi.");
	}

	private File generateImage(MultipartFile file) throws IOException {
		String imagePathGuid = java.util.UUID.randomUUID().toString();
		File imageFile = new File("C:\\Users\\oguzhan.demircioglu\\eclipse-workspace\\.metadata\\RentACarYeni\\src\\Image" 
		+ imagePathGuid + "." + file.getContentType().substring(file.getContentType().indexOf("/") + 1));
		imageFile.createNewFile();
		FileOutputStream outputImage = new FileOutputStream(imageFile);
		outputImage.write(file.getBytes());
		outputImage.close();
		return imageFile;
	}

	private Result checkNumberOfCarImages(int carId) {
		if (this.carImageDao.countCarImagesByCar_Id(carId) >= 5) {
			return new ErrorResult("Bu arabanın zaten 5 tane resmi var");
		}
		return new SuccessResult();
	}

	public DataResult<List<CarImageSearchListDto>> getCarImagesByCarId(int id) {
	
		if (this.carImageDao.getByCar_Id(id).isEmpty()) {
			CarImageSearchListDto carImageSearchListDto = new CarImageSearchListDto();
			
			carImageSearchListDto.setImagePath("C:\\Users\\oguzhan.demircioglu\\eclipse-workspace\\.metadata\\RentACarYeni\\src\\Image\\DefaultCar.jpg");
			
			List<CarImageSearchListDto> carImages = new ArrayList<CarImageSearchListDto>();
			carImages.add(carImageSearchListDto);
			
			return new SuccessDataResult<List<CarImageSearchListDto>>(carImages);
		}
		List<CarImage> carImages = this.carImageDao.getByCar_Id(id);
		List<CarImageSearchListDto> result = carImages.stream()
				.map(carImage -> modelMapperService.forDto().map(carImage, CarImageSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CarImageSearchListDto>>(result);

	}
}
