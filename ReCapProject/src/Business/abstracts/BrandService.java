package Business.abstracts;

import java.util.List;

import core.utilies.results.DataResult;
import core.utilies.results.Result;
import entities.concretes.Brand;
import entities.concretes.Car;

public interface BrandService{
	Result add(Brand brand);
	Result update(Brand brand,Brand brand1);
	Result delete(Brand brand);
	DataResult<List<Brand>> getAll();
}
