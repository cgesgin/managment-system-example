package com.cgesgin.managemensystem.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cgesgin.managemensystem.core.entity.Company; 
import com.cgesgin.managemensystem.core.services.ICompanyService; 
import com.cgesgin.managemensystem.respositories.CompanyRepository; 

@Service
public class CompanyService implements ICompanyService{

	private CompanyRepository repository;
	
	public CompanyService(CompanyRepository repository) {
		this.repository=repository;
	} 
	
	@Override
	public Company add(Company entity) {
		return this.repository.save(entity);
	}

	@Override
	public List<Company> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Company getById(int id) {
		return this.repository.findById(id).orElseThrow(()->new RuntimeException("Data not found -> "+id));
	}

	@Override
	public Company update(int id,Company entity) {
		Company existEntity = this.repository.findById(id).orElseThrow(()->new RuntimeException("Data not found ->"+id));
		
		existEntity.setName(entity.getName());
		existEntity.setEmail(entity.getEmail());
		
		this.repository.save(existEntity);
		
		return existEntity;
	}

	@Override
	public void delete(int id) {
		this.repository.findById(id).orElseThrow(()->new RuntimeException("Data not found ->"+id));
		this.repository.deleteById(id);
	}

}
