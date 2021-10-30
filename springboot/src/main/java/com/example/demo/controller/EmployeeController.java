package com.example.demo.controller;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	/*
	 * @PostMapping("/add") public ResponseEntity<?> addData(@RequestBody Employee
	 * employee) {
	 * 
	 * try { service.addData(employee); return new
	 * ResponseEntity<>("data added surely", HttpStatus.ACCEPTED.OK); } catch
	 * (Exception e) { return new ResponseEntity<>("Check your face properly",
	 * HttpStatus.INTERNAL_SERVER_ERROR.BAD_REQUEST); }
	 * 
	 * }
	 */
	@PostMapping("/add") 
	public Employee addData(@RequestBody Employee employee) {
		return service.addData(employee);

	}


	/*
	 * @GetMapping("/get") public ResponseEntity<?> getData(@RequestBody int id) {
	 * try { service.getData(id); return new ResponseEntity<>("data fetched surely",
	 * HttpStatus.ACCEPTED.OK); } catch (Exception e) { return new
	 * ResponseEntity<>("Check your face properly",
	 * HttpStatus.INTERNAL_SERVER_ERROR.BAD_REQUEST); } }
	 */
	@GetMapping("/get")
	public Employee getData(int id) {
		return service.getData(id);

	}
	@PostMapping("/getall")
	public List<Employee> findAll() {
		return service.findAll();
	}

	@PutMapping(path="/update",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Employee update(@RequestBody Employee employee) {
		return service.update(employee);
	}
	@DeleteMapping("/delete")
	public void delete(int id) {
		service.delete(id);;
	}

}
