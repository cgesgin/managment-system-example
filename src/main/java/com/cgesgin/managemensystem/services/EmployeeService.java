package com.cgesgin.managemensystem.services;



import java.util.List; 

import org.springframework.stereotype.Service;

import com.cgesgin.managemensystem.core.entity.Employee;
import com.cgesgin.managemensystem.core.services.IEmployeeService;
import com.cgesgin.managemensystem.respositories.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{

	private EmployeeRepository repository;
	
	public EmployeeService(EmployeeRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public Employee add(Employee entity) {
		return repository.save(entity);
	}

	@Override
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@Override
	public Employee getById(int id) {
		return this.repository.findById(id).orElseThrow(()->new RuntimeException("Data not found -> "+id));
	}

	@Override
	public Employee update(int id,Employee entity) {
		Employee existEntity = this.repository.findById(id).orElseThrow(()->new RuntimeException("Data not found ->"+id));
		
		existEntity.setFirstName(entity.getFirstName());
		existEntity.setLastName(entity.getLastName());
		existEntity.setEmail(entity.getEmail());
		existEntity.setCompany(entity.getCompany());
		
		this.repository.save(existEntity);
		
		return existEntity;
	}

	@Override
	public void delete(int id) {
		this.repository.findById(id).orElseThrow(()->new RuntimeException("Data not found ->"+id));
		this.repository.deleteById(id);	
	}
	

	
}
