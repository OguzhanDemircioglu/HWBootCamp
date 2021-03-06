package Business.abstracts;

import java.util.List;

import core.utilies.results.DataResult;
import core.utilies.results.Result;
import entities.concretes.Brand;
import entities.concretes.Color;

public interface ColorService {
	Result add(Color color);
	Result update(Color color);
	Result delete(Color color);
	DataResult<Color> getById(int id);
	DataResult<List<Color>> getAll();
}
