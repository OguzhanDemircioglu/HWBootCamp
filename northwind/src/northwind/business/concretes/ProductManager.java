package northwind.business.concretes;

import java.util.List;

import northwind.business.abstracts.ProductService;
import northwind.dataAccess.abstracts.ProductRepository;
import northwind.entities.concretes.Product;

public class ProductManager implements ProductService {

	private ProductRepository productRepository;

	public ProductManager(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAll() {
		return this.productRepository.getAll();
	}

	@Override
	public void add(Product product) {
		if (categoryLimit(product) && CannotSameProductName(product) && MinusPrice(product)
				&& cantBeSmallUnitPrice10(product)) {
			this.productRepository.add(product);
		} else {

		}
	}

	public boolean CannotSameProductName(Product product) {
		for (Product name : productRepository.getAll()) {
			if (product.getProductName().equals(name.getProductName())) {
				System.out.println("Aynı isimden olamaz");
				return false;
			}
		}
		return true;
	}

	public boolean categoryLimit(Product product) {
		int size = 0;
		for (Product item : productRepository.getAll()) {
			if (product.getCategoryId() == item.getCategoryId()) {
				size++;
			}
			if (size >= 5) {
				System.out.println("Her bir kategori'de en fazla 5 eleman olabilir.");
				return false;
			}
		}
		return true;
	}

	public boolean MinusPrice(Product product) {
		for (Product name : productRepository.getAll()) {
			if (product.getUnitPrice() < 0) {
				System.out.println("Fiyatlar 0 dan düşük olamaz");
				return false;
			}
		}
		return true;
	}

	public boolean cantBeSmallUnitPrice10(Product product) {
		if (product.getCategoryId() == 3 && product.getUnitPrice() < 10) {
			System.out.println("3 numaralı kategoride fiyat 10'dan düşük olmamalıdır.");
			return false;
		}
		return true;
	}

}
