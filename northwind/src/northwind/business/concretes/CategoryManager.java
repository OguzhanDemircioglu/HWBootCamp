package northwind.business.concretes;

import java.util.List;

import northwind.business.abstracts.CategoryService;
import northwind.dataAccess.abstracts.CategoryRepository;
import northwind.entities.concretes.Category;

public class CategoryManager implements CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryManager(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void add(Category category) {
		//category uzunluğu 5 olabilir
		categoryRepository.add(category);

	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.getAll();
	}
	

}
