package com.yashwanth.ManytoMany.Entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int proid;
	private String projname;



	@ManyToMany(mappedBy = "projects")
	@JsonIgnore
	private Set<Employee> employees;



	public int getProid() {
		return proid;
	}



	public void setProid(int proid) {
		this.proid = proid;
	}



	public String getProjname() {
		return projname;
	}



	public void setProjname(String projname) {
		this.projname = projname;
	}



	public Set<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}



	public Project(int proid, String projname, Set<Employee> employees) {
		super();
		this.proid = proid;
		this.projname = projname;
		this.employees = employees;
	}



	public Project() {
		super();
	}

}
