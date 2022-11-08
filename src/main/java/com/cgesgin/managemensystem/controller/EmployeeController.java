package com.cgesgin.managemensystem.controller;

import java.util.List;

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

import com.cgesgin.managemensystem.core.entity.Employee;
import com.cgesgin.managemensystem.core.services.IEmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private IEmployeeService employeeService;

	public EmployeeController(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<Employee> add(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(this.employeeService.add(employee),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAll(){
		return this.employeeService.getAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getById(@PathVariable("id") int id){
		return new ResponseEntity<Employee>(this.employeeService.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> update(@PathVariable("id") int id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(this.employeeService.update(id,employee),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		this.employeeService.delete(id);
		return new ResponseEntity<String>("successfull",HttpStatus.OK);
	}
}
