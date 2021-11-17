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
	public void update(Color entity) {
		Color colorToUpdate=colors.stream().filter(c->c.getColorId()==entity.getColorId()).findFirst().orElse(null);
		colorToUpdate.setColorId(entity.getColorId());
		colorToUpdate.setColorName(entity.getColorName());
		
	}
	@Override
	public Color getById(int id) {

		Color color=colors.stream().filter(x->x.getColorId()==id).findFirst().orElse(null);
		return color;
	}

	@Override
	public List<Color> getAll() {
		// TODO Auto-generated method stub
		return colors;
	}

}
