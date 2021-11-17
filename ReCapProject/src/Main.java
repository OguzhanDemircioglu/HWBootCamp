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

		Car car = new Car(1,1,1,1,1.00,"Mersedes");
		Car car1 = new Car(1,1,1,1,1.00,"BMW");
		Car car3 = new Car(1,1,1,1,1.00,"Þahin");
		
		CarService carService=new CarManager(new CarDao());
		
		carService.add(car);
		for (Car item : carService.getAll().getData()) {
			System.out.println(item.getDescription());
		}
		
		System.out.println();
		
		carService.update(car,car1);
		for (Car item : carService.getAll().getData()) {
			System.out.println(item.getDescription());
		}
		
		System.out.println();
		
		carService.add(car3);
		carService.delete(car);
		
		for (Car item : carService.getAll().getData()) {
			System.out.println(item.getDescription());
		}
		
		System.out.println("********************");
		
		Color color = new Color(1,"Mavi");
		Color color1 = new Color(1,"yeþil");
		Color color3 = new Color(1,"Sarý");
		
		ColorService colorService = new ColorManager(new ColorDao());
		
		colorService.add(color);
		for (Color item : colorService.getAll().getData()) {
			System.out.println(item.getColorName());
		}
		
		System.out.println();
		
		colorService.update(color,color1);
		
		for (Color item : colorService.getAll().getData()) {
			System.out.println(item.getColorName());
		}
		
		System.out.println();
		
		colorService.add(color3);
		colorService.delete(color);
		
		for (Color item : colorService.getAll().getData()) {
			System.out.println(item.getColorName());
		}
		
		System.out.println("**************************");
		
		Brand brand = new Brand(1,"AAA");
		Brand brand1= new Brand(1,"BBB");
		Brand brand2 = new Brand(2,"CCC");
		
		BrandService brandService = new BrandManager(new BrandDao());

		brandService.add(brand);
		for (Brand item : brandService.getAll().getData()) {
			System.out.println(item.getBrandName());
		}
		
		System.out.println();
		
		brandService.update(brand,brand1);
		
		for (Brand item : brandService.getAll().getData()) {
			System.out.println(item.getBrandName());
		}
		
		System.out.println();
		
		brandService.add(brand2);
		brandService.delete(brand);
		
		for (Brand item : brandService.getAll().getData()) {
			System.out.println(item.getBrandName());
		}
	}

}
