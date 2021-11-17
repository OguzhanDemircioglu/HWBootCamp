package Business.concretes;

import java.util.List;

import core.utilies.results.DataResult;
import core.utilies.results.Result;
import core.utilies.results.SuccessDataResult;
import core.utilies.results.SuccessResult;
import dataAccess.abstracts.CarRepository;
import entities.concretes.Brand;
import entities.concretes.Car;
import Business.abstracts.CarService;

public class CarManager implements CarService {

	private CarRepository carRepository;
	
	
	public CarManager(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}
	
	

	@Override
	public Result add(Car car) {
		// TODO Auto-generated method stub
		this.carRepository.add(car);
		return new SuccessResult();
	}

	
	public Result update(Car car) {
		
		this.carRepository.update(car);
		return new SuccessResult();
	}

	@Override
	public Result delete(Car car) {
		
		this.carRepository.delete(car);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Car>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Car>>(this.carRepository.getAll());
	}

	@Override
	public DataResult<Car> getById(int id) {
		return new SuccessDataResult<Car>(this.carRepository.getById(id)); 
	}

}
