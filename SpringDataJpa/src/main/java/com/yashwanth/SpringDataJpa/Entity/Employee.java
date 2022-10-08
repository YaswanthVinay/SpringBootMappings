package com.yashwanth.SpringDataJpa.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity

@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	private String name;
	private Integer age;
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber = (long) (Math.random() * Math.pow(10, 10));
	private String designation;
	private Double salary = Math.random() * 100000;

	public Employee() {
		super();
	}

	
	
}
