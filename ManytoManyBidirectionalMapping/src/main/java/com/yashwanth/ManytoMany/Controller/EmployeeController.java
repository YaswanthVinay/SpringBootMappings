package com.yashwanth.ManytoMany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yashwanth.ManytoMany.Entity.Employee;
import com.yashwanth.ManytoMany.Service.EmployeeService;

@RestController

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/SaveEmp")
	public List<Employee> SaveEmp(@RequestBody List<Employee> emp) {
		return employeeService.Save(emp);

	}

	@GetMapping("/GetDetails")
	public List<Employee> GetDetails() {
		return employeeService.GetDetailsOfEmployee();
	}

	@GetMapping("/getEmployees/{empid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int empid) {
		return employeeService.getEmployeeDetails(empid);
	}

	@GetMapping("/getEmployeeDetailsByName/{name}")
	public List<Employee> GetEmployeeDetailsByName(@PathVariable String name) {
		return employeeService.getEmployeeDetailsByName(name);
	}

	@DeleteMapping("/deleteEmployeeDetailsByID/{empid}")
	public ResponseEntity<List<Employee>> DeleteEmployeeDetailsByName(@PathVariable int empid) {
		return employeeService.deleteEmployeeDetailsByID(empid);
	}

	
	@PutMapping("/{empid}/proj/{proid}")
	
	public Employee AssignProj(@PathVariable int empid,
									 @PathVariable int proid)
	{
		return employeeService.AssignProjtoEmp(empid,proid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
