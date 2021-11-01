package com.te.springmvcproject.dao;

import java.util.Date;
import java.util.List;

import com.te.springmvcproject.dto.Employee;

public interface EmployeeDao {
	Employee authenticate(int id, String pass);

	Employee getEmployee(int id);

	boolean deleteEmployee(int id);

	List<Employee> viewAllEmployee();

	boolean addEmployee(Employee employee);
	
	boolean updateEmployee(int id,String name,String pass,Date dob);

}
