package com.te.springmvcproject.dao;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springmvcproject.dto.Employee;
import com.te.springmvcproject.exception.EmployeeException;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

//	@PersistenceUnit
//	private EntityManagerFactory factory;

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("springmvcproject");
	EntityManager manager = factory.createEntityManager();

	@Override
	public Employee authenticate(int id, String pass) {
		Employee employee = manager.find(Employee.class, id);
		if (employee != null) {
			if (employee.getPassword().equals(pass)) {
				return employee;
			} else {
				throw new EmployeeException("Invalid Password");
			}
		}
		throw new EmployeeException("Invalid UserName");
	}

	@Override
	public Employee getEmployee(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springmvcproject");
		EntityManager manager = factory.createEntityManager();
		Employee employee = manager.find(Employee.class, id);
		if (employee != null) {
			return employee;
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springmvcproject");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		Employee employee = manager.find(Employee.class, id);
		if (employee != null) {
			manager.remove(employee);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> viewAllEmployee() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springmvcproject");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from Employee");
		List<Employee> employees = query.getResultList();
		if (employees != null) {
			return employees;
		} else {
			return null;
		}

	}

	@Override
	public boolean addEmployee(Employee employee) {
		boolean isAdded = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springmvcproject");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		if (!isAdded) {
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
			isAdded = true;
			return isAdded;
		} else {
			return isAdded;
		}

	}
	@Override
	public boolean updateEmployee(int id,String name, String pass, Date dob) {
		Employee employee=new Employee();
		
		boolean isAdded = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springmvcproject");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		if (!isAdded) {
			transaction.begin();
			Employee employee2= manager.find(Employee.class, id);
			employee2.setName(name);
			employee2.setPassword(pass);
			employee2.setDob(dob);
			transaction.commit();
			isAdded = true;
			return isAdded;
		
		} else {
			return isAdded;
		}
	}

}
