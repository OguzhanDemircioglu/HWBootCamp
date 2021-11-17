package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.ColorRepository;
import entities.concretes.Color;

public class ColorDao implements ColorRepository {

	List <Color>colors;
	
	public ColorDao(){
		this.colors=new ArrayList<Color>();
	}
	
	
	@Override
	public void add(Color entity) {
		// TODO Auto-generated method stub
		this.colors.add(entity);
	}

	@Override
	public void delete(Color entity) {
		// TODO Auto-generated method stub
		this.colors.remove(entity);
	}

	@Override
	public void update(Color entity, Color entity1) {
		// TODO Auto-generated method stub
		if(entity.getColorId()==entity1.getColorId()){
			entity.setColorId(entity1.getColorId());
			entity.setColorName(entity1.getColorName());
			
			colors.remove(entity1);
		}else{
			System.out.println("Neyse Update etmek için ID deðerleri ayný olmalý");
	}
	}
	@Override
	public Color getById(int id) {
		// TODO Auto-generated method stub
		return colors.get(id);
	}

	@Override
	public List<Color> getAll() {
		// TODO Auto-generated method stub
		return colors;
	}

}
