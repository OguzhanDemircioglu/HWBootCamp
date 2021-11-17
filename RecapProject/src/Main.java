import Business.abstracts.BrandService;
import Business.abstracts.CarService;
import Business.abstracts.ColorService;
import Business.concretes.BrandManager;
import Business.concretes.CarManager;
import Business.concretes.ColorManager;
import dataAccess.concretes.BrandDao;
import dataAccess.concretes.CarDao;
import dataAccess.concretes.ColorDao;
import entities.concretes.Brand;
import entities.concretes.Car;
import entities.concretes.Color;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IOC new'leticez
		Car car = new Car(1,1,1,1997,10.00,"Bu arabalar şahaneeee");
		Car car1 = new Car(2,1,1,1999,19.00,"İçinde Sigara Bile içilmedi");
		Car car2 = new Car(3,1,1,1,1.00,"Memurdan Satılık");
		
		CarService carService=new CarManager(new CarDao());
		
		carService.add(car);
		carService.add(car1);
		carService.add(car2);
		for (Car item : carService.getAll().getData()) {
			System.out.println(item.getDescription());
		}
		System.out.println("----");
		System.out.println("İstenilen Id'nin model yılı :  "+carService.getById(2).getData().getModelYear()); 
		System.out.println("----");
		
		carService.update(new Car(2,2,2,2020,10.10,"Audi"));
		for (Car item : carService.getAll().getData()) {
			System.out.println(item.getDescription());
		}
		
		System.out.println("----------");
		
		carService.delete(car);
		
		for (Car item : carService.getAll().getData()) {
			System.out.println(item.getDescription());
		}
		
		System.out.println("********************");
		
		Color color = new Color(1,"Mavi");
		Color color1 = new Color(1,"Yeşil");
		Color color2 = new Color(1,"Sarı");
		
		ColorService colorService = new ColorManager(new ColorDao());
		
		colorService.add(color);
		colorService.add(color1);
		colorService.add(color2);
		for (Color item : colorService.getAll().getData()) {
			System.out.println(item.getColorName());
		}
		
		System.out.println("----------");
		
		colorService.update(new Color(1, "Kırmızı"));
		
		for (Color item : colorService.getAll().getData()) {
			System.out.println(item.getColorName());
		}
		
		System.out.println("-----");
		
		
		colorService.delete(color);
		
		for (Color item : colorService.getAll().getData()) {
			System.out.println(item.getColorName());
		}
		
		System.out.println("**************************");
		
		Brand brand = new Brand(1,"Audi");
		Brand brand1= new Brand(1,"Mercedes");
		Brand brand2 = new Brand(2,"BMW");
		
		BrandService brandService = new BrandManager(new BrandDao());

		brandService.add(brand);
		brandService.add(brand1);
		brandService.add(brand2);
		for (Brand item : brandService.getAll().getData()) {
			System.out.println(item.getBrandName());
		}
		
		System.out.println();
		
		brandService.update(new Brand(1, "Fiat"));
		
		for (Brand item : brandService.getAll().getData()) {
			System.out.println(item.getBrandName());
		}
		System.out.println("-----");
		
		brandService.delete(brand);
		
		for (Brand item : brandService.getAll().getData()) {
			System.out.println(item.getBrandName());
		}
	}

}
