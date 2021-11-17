package Business.abstracts;

import java.util.List;

import core.utilies.results.DataResult;
import core.utilies.results.Result;
import entities.concretes.Brand;

public interface BrandService{
	Result add(Brand brand);
	Result update(Brand brand);
	Result delete(Brand brand);
	DataResult<Brand> getById(int id);
	DataResult<List<Brand>> getAll();
}
