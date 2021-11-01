package com.te.springmvcproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvcproject.dao.EmployeeDao;
import com.te.springmvcproject.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee authenticate(int id, String pass) {
		if (id <= 0) {
			return null;
		} else {
			return employeeDao.authenticate(id, pass);
		}

	}

	@Override
	public Employee getEmployee(int id) {

		if (id <= 0) {
			return null;
		} else {
			return employeeDao.getEmployee(id);
		}
	}

	@Override
	public boolean deleteEmployee(int id) {
		if (id <= 0) {
			return false;
		} else {
			return employeeDao.deleteEmployee(id);
		}
	}

	@Override
	public List<Employee> viewAllEmployee() {

		return employeeDao.viewAllEmployee();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public boolean updateEmployee(int id,String name, String pass, Date dob) {
		if(pass.length()<=3) {
		return false;
		}else {
			return employeeDao.updateEmployee(id,name, pass, dob);
		}
			
	}

}
