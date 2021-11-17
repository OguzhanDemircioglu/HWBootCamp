package Business.abstracts;

import java.util.List;

import core.utilies.results.DataResult;
import core.utilies.results.Result;
import entities.concretes.Brand;
import entities.concretes.Car;

public interface CarService {
	Result add(Car car);
	Result update(Car car,Car car1);
	Result delete(Car car);
	DataResult<List<Car>> getAll();

}
