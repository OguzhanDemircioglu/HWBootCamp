package workshop;
import java.util.ArrayList;

public class ProductManager implements ProductService {

	private ProductDao productDao;
	private LoggerService loggerService;
	

	public ProductManager(ProductDao productDao,LoggerService loggerService) {
		super();
		this.productDao = productDao;
		this.loggerService=loggerService;
	}
	
	public ProductManager(LoggerService loggerService) {
		super();
		this.loggerService=loggerService;
	}

	@Override
	public void save(Product product) {
		
		loggerService.log();
	}

	@Override
	public ArrayList<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
