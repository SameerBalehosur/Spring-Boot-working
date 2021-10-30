package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Employee;

public interface EmployeeService {

	public Employee addData(Employee employee);
		
	public void delete(int id);
	
	public Employee update(Employee employee);
	
	
	public Employee getData(int id);
	
	public List<Employee> findAll(); 
	
	
}
