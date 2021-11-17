package Business.abstracts;

import java.util.List;

import core.utilies.results.DataResult;
import core.utilies.results.Result;
import entities.concretes.Brand;
import entities.concretes.Car;

public interface CarService {
	Result add(Car car);
	Result update(Car car);
	Result delete(Car car);
	DataResult<Car> getById(int id);
	DataResult<List<Car>> getAll();

}
