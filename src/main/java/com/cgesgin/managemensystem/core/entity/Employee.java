package com.cgesgin.managemensystem.core.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "cmail")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;
}
