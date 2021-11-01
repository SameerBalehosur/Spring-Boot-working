package com.te.springmvcproject.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.springmvcproject.exception.EmployeeException;

@ControllerAdvice
public class EmployeeExcepController {

	@ExceptionHandler(EmployeeException.class)
	public String getException(HttpServletRequest request,EmployeeException exception) {
		request.setAttribute("errMsg", exception.getMessage());
		return "login";
		
	}
}
