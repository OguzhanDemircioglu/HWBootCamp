package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.BrandRepository;
import entities.concretes.Brand;

public class BrandDao implements BrandRepository {

	List <Brand> brands;

	
	public BrandDao(){
		this.brands=new ArrayList<Brand>();
	}
	@Override
	public void add(Brand entity) {
		// TODO Auto-generated method stub
		this.brands.add(entity);
	}

	@Override
	public void delete(Brand entity) {
		// TODO Auto-generated method stub
		this.brands.remove(entity);
	}

	@Override
	public void update(Brand entity) {
		Brand brandToUpdate=brands.stream()
				.filter(b->b.getBrandId()==entity.getBrandId())
				.findFirst()
				.orElse(entity);
		brandToUpdate.setBrandId(entity.getBrandId());
		brandToUpdate.setBrandName(entity.getBrandName());
	
	}
	@Override
	public Brand getById(int id) {
		// TODO Auto-generated method stub
		return brands.get(id-1);
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brands;
	}

}
