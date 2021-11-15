package workshop;
import java.io.File;

public class Main {

	public static void main(String[] args) {
		
//		CustomerManager customerManager=new CustomerManager(new JdbcCustomerDao());
//		customerManager.save(null);
		
		
		ProductManager productManager=new ProductManager(new JbdcProductDao(),new LoggerManager(new FileLogger(),new DbLogger()));
		productManager.save(null);
		//save log -- log -- save --save --log --save log 
		ProductManager a1=new ProductManager(new LoggerManager(new FileLogger()));
		a1.save(null);
	}

}
