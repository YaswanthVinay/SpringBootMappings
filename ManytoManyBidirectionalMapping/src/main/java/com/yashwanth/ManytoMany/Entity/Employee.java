package com.yashwanth.ManytoMany.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int empid;
	private String name;
	private String designation;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Employee_Project", 
	
	joinColumns = @JoinColumn
	(name = "Employee_id", referencedColumnName = "empid"),
	inverseJoinColumns = @JoinColumn
	(name = "Project_id", referencedColumnName = "proid"))
	
	private Set<Project> projects;


	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	
	public Employee(int empid, String name, String designation, Set<Project> projects) {
		super();
		this.empid = empid;
		this.name = name;
		this.designation = designation;
		this.projects = projects;
	}

	public Employee() {
		super();
	}

}
