package northwind.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import northwind.dataAccess.abstracts.CategoryRepository;
import northwind.entities.concretes.Category;

public class CategoryDao implements CategoryRepository {

	List<Category> categories;

	public CategoryDao() {
		super();
		this.categories = new ArrayList<Category>();
	}

	@Override
	public void add(Category category) {
		categories.add(category);

	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category getById(int id) {
		return this.categories.get(id);
	}

	@Override
	public List<Category> getAll() {
		return categories;
	}

}
