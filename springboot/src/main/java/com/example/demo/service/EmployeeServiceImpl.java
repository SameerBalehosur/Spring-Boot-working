package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee addData(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public void delete(int id) {
		Employee employee= dao.findByEmpId(id);
				dao.delete(employee);
	}

	@Override
	public Employee update(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee getData(int id) {
		return dao.findByEmpId(id);
	}

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) dao.findAll();
	}

}
