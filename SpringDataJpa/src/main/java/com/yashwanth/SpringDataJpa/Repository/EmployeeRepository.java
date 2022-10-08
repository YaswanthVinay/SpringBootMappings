package com.yashwanth.SpringDataJpa.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yashwanth.SpringDataJpa.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

Optional<Employee> findByName(String name);
List<Employee> findByDesignation(String designation);

}
