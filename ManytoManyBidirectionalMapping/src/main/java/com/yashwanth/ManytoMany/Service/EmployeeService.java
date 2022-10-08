package com.yashwanth.ManytoMany.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yashwanth.ManytoMany.Entity.Employee;
import com.yashwanth.ManytoMany.Entity.Project;
import com.yashwanth.ManytoMany.Repository.EmployeeRepository;
import com.yashwanth.ManytoMany.Repository.ProjectRepository;

@Service

@SuppressWarnings({ "unchecked", "rawtypes" })

public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;
	public List<Employee> Save(List<Employee> emp) {

		return employeeRepository.saveAll(emp);
	}

	public List<Employee> GetDetailsOfEmployee() {

		return employeeRepository.findAll();

	}


	public ResponseEntity<Employee> getEmployeeDetails(int empid) {
		
		Optional<Employee> optional= employeeRepository.findById(empid);
		
		if (optional.isPresent()) {
	return new ResponseEntity(empid, HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity("empid not found",HttpStatus.NOT_FOUND);
		}
	}

	public List<Employee> getEmployeeDetailsByName(String name) {
		
		return employeeRepository.findByName(name);
	}

	public ResponseEntity<List<Employee>> deleteEmployeeDetailsByID(int empid) {
		Optional<Employee> empopt=employeeRepository.findById(empid);
		
		if (empopt.isPresent()) {
			 employeeRepository.deleteById(empid);
			 }
		else {
			return new ResponseEntity("Data Not Found With Id ~ "+empid,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Data Deleted",HttpStatus.OK);
		
	}

	public Employee AssignProjtoEmp(int empid, int proid) {
		
		
		Set<Project> projectset=null;
		Employee empl=employeeRepository.findById(empid).get();
		
		Project projkt=projectRepository.findById(proid).get();
		
		
		projectset=empl.getProjects();
		projectset.add(projkt);
		
		empl.setProjects(projectset);
		
		
		return employeeRepository.save(empl);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

