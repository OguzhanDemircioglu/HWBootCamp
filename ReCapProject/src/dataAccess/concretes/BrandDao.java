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
	public void update(Brand entity, Brand entity1) {
		// TODO Auto-generated method stub
		if(entity.getBrandId()==entity1.getBrandId()){
			entity.setBrandId(entity1.getBrandId());
			entity.setBrandName(entity1.getBrandName());
			
			brands.remove(entity1);
		}else{
			System.out.println("Neyse Update etmek için ID deðerleri ayný olmalý");
	}
	}
	@Override
	public Brand getById(int id) {
		// TODO Auto-generated method stub
		return brands.get(id);
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brands;
	}

}
