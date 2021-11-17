package Business.concretes;

import java.util.List;

import core.utilies.results.DataResult;
import core.utilies.results.Result;
import core.utilies.results.SuccessDataResult;
import core.utilies.results.SuccessResult;
import dataAccess.abstracts.BrandRepository;
import entities.concretes.Brand;
import entities.concretes.Color;
import Business.abstracts.BrandService;

public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	
	
	public  BrandManager(BrandRepository brandRepository){
		super();
		this.brandRepository=brandRepository;
	}
	
	public Result add(Brand entity) {
		// TODO Auto-generated method stub
		this.brandRepository.add(entity);
		return new SuccessResult();
	}

	@Override
	public Result update(Brand entity,Brand entity1) {
		// TODO Auto-generated method stub
		this.brandRepository.update(entity,entity1);

		return new SuccessResult();
	}

	@Override
	public Result delete(Brand entity) {
		// TODO Auto-generated method stub
		this.brandRepository.delete(entity);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Brand>>(this.brandRepository.getAll());
	}

}
