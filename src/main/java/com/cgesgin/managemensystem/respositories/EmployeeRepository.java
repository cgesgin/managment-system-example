package com.cgesgin.managemensystem.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgesgin.managemensystem.core.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

}
