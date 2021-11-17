package Business.concretes;

import java.util.List;

import core.utilies.results.DataResult;
import core.utilies.results.Result;
import core.utilies.results.SuccessDataResult;
import core.utilies.results.SuccessResult;
import dataAccess.abstracts.CarRepository;
import dataAccess.abstracts.ColorRepository;
import entities.concretes.Car;
import entities.concretes.Color;
import Business.abstracts.ColorService;

public class ColorManager implements ColorService {

	private ColorRepository colorRepository;

	public ColorManager(ColorRepository colorRepository) {
		super();
		this.colorRepository = colorRepository;
	}

	@Override
	public Result add(Color entity) {
		// TODO Auto-generated method stub
		this.colorRepository.add(entity);
		return new SuccessResult();
	}

	@Override
	public Result update(Color entity) {
		// TODO Auto-generated method stub
		this.colorRepository.update(entity);
		return new SuccessResult();
	}

	@Override
	public Result delete(Color entity) {
		// TODO Auto-generated method stub
		this.colorRepository.delete(entity);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Color>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Color>>(this.colorRepository.getAll());
	}

	@Override
	public DataResult<Color> getById(int id) {
		return new SuccessDataResult<Color>(this.colorRepository.getById(id));
	}

}
