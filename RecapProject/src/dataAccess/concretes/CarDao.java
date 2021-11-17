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
		this.cars.remove(entity);
	}

	@Override
	public void update(Car entity) {
		
		Car carToUpdate=cars.stream()
				.filter(x->x.getId()==entity.getId())
				.findFirst().orElse(null);
		carToUpdate.setId(entity.getId());
		carToUpdate.setColorId(entity.getColorId());
		carToUpdate.setBrandId(entity.getBrandId());
		carToUpdate.setDailyPrice(entity.getDailyPrice());
		carToUpdate.setDescription(entity.getDescription());
	}

	@Override
	public Car getById(int id) {
		// TODO Auto-generated method stub
		return cars.get(id-1);
	}

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return cars;
	}

	
	
	

}
