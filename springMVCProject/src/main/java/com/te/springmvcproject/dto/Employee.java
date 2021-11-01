package com.te.springmvcproject.dto;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="emp_details")
public class Employee {
	@Id
	@Column(name="emp_Id")
	private int id;
	@Column(name="emp_Name")
	private String name;
	@Column(name="emp_Pass")
	private String password;
	@Column(name="emp_Dob")
	private Date dob;

}
