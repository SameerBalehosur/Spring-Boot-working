package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	public Employee findByEmpId(int id);
}
