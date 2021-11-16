package northwind.business.concretes;

import java.util.List;

import northwind.business.abstracts.EmployeeService;
import northwind.dataAccess.abstracts.EmployeeRepository;
import northwind.entities.concretes.Employee;

public class EmployeeManager implements EmployeeService{

	private EmployeeRepository employeeRepository;
	public EmployeeManager(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void add(Employee employee) {
		employeeRepository.add(employee);
		
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.getAll();
	}

}
