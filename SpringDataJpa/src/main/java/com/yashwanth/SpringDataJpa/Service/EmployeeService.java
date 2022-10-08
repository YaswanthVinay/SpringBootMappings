package com.yashwanth.SpringDataJpa.Service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.yashwanth.SpringDataJpa.Entity.Employee;
import com.yashwanth.SpringDataJpa.Repository.EmployeeRepository;

@Service
@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> CreateEmployee(List<Employee> emplist) {

		return employeeRepository.saveAll(emplist);
	}

	public Employee SaveSingleEmployee(Employee emp) {

		return employeeRepository.save(emp);
	}

	public List<Employee> FetchAllEmployeeDetails() {

		return employeeRepository.findAll();
	}

	public ResponseEntity<Employee> GetEmployeeByEmpID(Long empId) {

		Optional<Employee> empOptional = employeeRepository.findById(empId);

		if (empOptional.isPresent() == true) {
			return new ResponseEntity(empOptional, HttpStatus.OK);

		} else
			return new ResponseEntity("Incorrect Data Entered", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Employee> GetEmployeeByEmpName(String name) {

		Optional<Employee> empOpt = employeeRepository.findByName(name);

		if (empOpt.isPresent() == true) {
			return new ResponseEntity(empOpt, HttpStatus.OK);

		}

		else

			return new ResponseEntity("Incorrect Data Entered", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Employee> GetEmployeeByEmpDesignation(String designation) {
		List<Employee> emp = employeeRepository.findByDesignation(designation);
		if (emp.isEmpty() == false) {
			return new ResponseEntity(emp, HttpStatus.OK);

		}

		else

			return new ResponseEntity("No Designation Matched With input : "+designation, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Employee> DeleteEmployeeByEmpID(Long empId) {
		Optional<Employee> DelempOpt = employeeRepository.findById(empId);
		if (DelempOpt.isPresent() == true) {

			employeeRepository.deleteById(empId);

			return new ResponseEntity("ok Data Deleted", HttpStatus.OK);
		}
		return new ResponseEntity("oops Data not found with id : " + empId, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Employee> UpdateEmployeeByEmpID(Long empId, Employee employee) {
		Optional<Employee> employeeOpt = employeeRepository.findById(empId);

		

		if (employeeOpt.isPresent()) {
			Employee employee2 = employeeOpt.get();

			employee2.setAge(employee.getAge());
			employee2.setDesignation(employee.getDesignation());

			employee2.setName(employee.getName());
			employee2.setPhoneNumber(employee.getPhoneNumber());
			employee2.setSalary(employee.getSalary());

			employeeRepository.save(employee2);
			return new ResponseEntity("ok Data Updated", HttpStatus.OK);
		} 
		return new ResponseEntity("oops Data does not exist with id : " + empId, HttpStatus.NOT_FOUND);
		

	}

	public Page<Employee> PaginationAndSorting(Integer pageNumber, Integer PageSize, Integer sortProperty) {

		Sort sortOrder = Sort.by(Sort.Order.asc("age"), Sort.Order.desc("salary"));
		Sort sortOrderone = Sort.by(Sort.Order.asc("age"), Sort.Order.desc("salary"));

		Pageable pageable = null;

		if (null != sortOrder) {
			pageable = PageRequest.of(pageNumber, PageSize, sortOrder);
		} else {
			return (Page<Employee>) new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return employeeRepository.findAll(pageable);

	}

	public Page<Employee> PaginationAndSortingByPage(Integer pageNumber, Integer pageSize) {

		Pageable page = PageRequest.of(pageNumber, pageSize);

		return employeeRepository.findAll(page);
	}

}
