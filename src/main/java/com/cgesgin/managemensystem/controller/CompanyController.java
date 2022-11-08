package com.cgesgin.managemensystem.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgesgin.managemensystem.core.dto.CompanyDto;
import com.cgesgin.managemensystem.core.entity.Company;
import com.cgesgin.managemensystem.core.services.ICompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	private ICompanyService companyService;
	private ModelMapper mapper;

	public CompanyController(ICompanyService companyService,ModelMapper mapper) {
		this.companyService = companyService;
		this.mapper=mapper;
	}
	
	@PostMapping
	public ResponseEntity<CompanyDto> add(@RequestBody CompanyDto companydto){
		Company company = this.companyService.add(mapper.map(companydto, Company.class));
		return new ResponseEntity<CompanyDto>(mapper.map(company, CompanyDto.class),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<CompanyDto> getAll(){
		List<Company> companyList = this.companyService.getAll();
		List<CompanyDto> companyDtoList = companyList.stream().map(company-> mapper.map(company, CompanyDto.class)).toList();
		return companyDtoList;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CompanyDto> getById(@PathVariable("id") int id){
		CompanyDto companydto = mapper.map(this.companyService.getById(id), CompanyDto.class);
		return new ResponseEntity<CompanyDto>(companydto,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CompanyDto> update(@PathVariable("id") int id,@RequestBody Company company){
		CompanyDto companyDto= mapper.map(this.companyService.update(id,company),CompanyDto.class);
		return new ResponseEntity<CompanyDto>(companyDto,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		this.companyService.delete(id);
		return new ResponseEntity<String>("successfull",HttpStatus.OK);
	}
}
