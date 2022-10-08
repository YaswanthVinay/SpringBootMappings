package com.yashwanth.SpringDataJpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yashwanth.SpringDataJpa.Entity.Employee;
import com.yashwanth.SpringDataJpa.Service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired

	private EmployeeService employeeService;

	@PostMapping("/CreateEmp")
	public List<Employee> CreateEmployee(@RequestBody List<Employee> emplist) {
		return employeeService.CreateEmployee(emplist);
	}

	@PostMapping("/CreateOneEmp")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Employee SingleEmp(@RequestBody Employee emp) {
		return employeeService.SaveSingleEmployee(emp);
	}

	@GetMapping("/GetAllEmployeeDetails")
	public List<Employee> GetAllEmployeeDetails() {
		return employeeService.FetchAllEmployeeDetails();
	}

	@GetMapping("/GetEmployeeByID/{empId}")

	public ResponseEntity<Employee> GetEmployeeByID(@PathVariable Long empId) {
		return employeeService.GetEmployeeByEmpID(empId);
	}

	@GetMapping("/GetEmployeeByName/{name}")

	public ResponseEntity<Employee> GetEmployeeByName(@PathVariable String name) {
		return employeeService.GetEmployeeByEmpName(name);
	}

	@GetMapping("/GetEmployeeBydesignation/{designation}")

	public ResponseEntity<Employee> GetEmployeeByDesignation(@PathVariable String designation) {
		return employeeService.GetEmployeeByEmpDesignation(designation);
	}
	
	@DeleteMapping("/DeleteEmployeeByID/{empId}")
	public ResponseEntity<Employee> DeleteEmployeeByID(@PathVariable Long empId) {
		return employeeService.DeleteEmployeeByEmpID(empId);
	}

	@PutMapping("/UpdateEmployeeByID/{empId}")
	public ResponseEntity<Employee> UpdateEmployeeByID(@PathVariable Long empId,@RequestBody Employee employee) {
		return employeeService.UpdateEmployeeByEmpID(empId,employee);
	}
	
	
	@GetMapping("/PagingAndSorting/{PageNumber}/{PageSize}/{SortProperty}")
	public Page<Employee> PagingAndSorting(@PathVariable Integer PageNumber,
											@PathVariable Integer PageSize,
											@PathVariable Integer SortProperty){
		return employeeService.PaginationAndSorting(PageNumber,PageSize,SortProperty);
		
	}
	
	@GetMapping("/PagingAndSorting/{PageNumber}/{PageSize}")
	public Page<Employee> PagingAndSortingThroughIntFormat(@PathVariable Integer PageNumber,
											@PathVariable Integer PageSize
											)
	{
		return employeeService.PaginationAndSortingByPage(PageNumber,PageSize);
		
	}
	
}
