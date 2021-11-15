package workshop;

public class JbdcProductDao implements ProductDao{

	@Override
	public void save() {
		System.out.println("Jdbc ile eklendi");
		
	}

}
