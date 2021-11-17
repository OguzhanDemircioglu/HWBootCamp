package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.CarRepository;
import entities.concretes.Car;

public class CarDao implements CarRepository {

	List <Car> cars; 
	
	
	public CarDao (){
		this.cars=new ArrayList<Car>();
	}
	
	@Override
	public void add(Car entity) {
		// TODO Auto-generated method stub
		this.cars.add(entity);
		
	}

	@Override
	public void delete(Car entity) {
		// TODO Auto-generated method stub
		this.cars.remove(entity);
	}

	@Override
	public void update(Car entity, Car entity1) {
		// TODO Auto-generated method stub
		if(entity.getId()==entity1.getId()){
			entity.setBrandId(entity1.getBrandId());
			entity.setColorId(entity1.getColorId());
			entity.setId(entity1.getId());
			entity.setDailyPrice(entity1.getDailyPrice());
			entity.setDescription(entity1.getDescription());
			entity.setModelYear(entity1.getModelYear());
			cars.remove(entity1);
		}else{
			System.out.println("Neyse Update etmek için ID deðerleri ayný olmalý");
		
	}
	
	}

	@Override
	public Car getById(int id) {
		// TODO Auto-generated method stub
		return cars.get(id);
	}

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return cars;
	}

	
	
	

}
