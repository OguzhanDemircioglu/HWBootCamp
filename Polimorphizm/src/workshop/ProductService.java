package workshop;
import java.util.ArrayList;

public interface ProductService {
	void save(Product product);
	ArrayList<Product> list();
}
