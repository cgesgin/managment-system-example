package com.cgesgin.managemensystem.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgesgin.managemensystem.core.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
