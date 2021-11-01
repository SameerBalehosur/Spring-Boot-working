package com.te.springmvcproject.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import com.te.springmvcproject.dto.Employee;
import com.te.springmvcproject.service.EmployeeService;

@Controller
public class EmployeeController {


	@InitBinder
	private void initDateConvert(WebDataBinder binder) {

		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);

		binder.registerCustomEditor(Date.class, editor);
	}


	@Autowired
	private EmployeeService service;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String authentication(ModelMap map, int id, String pwd, HttpServletRequest request) {
		Employee employee = service.authenticate(id, pwd);
		HttpSession session = request.getSession();
		session.setAttribute("sessionKey", employee);
		if (employee != null) {
			map.addAttribute("name", employee.getName());
			return "home";
		} else {
			map.addAttribute("errMsg", "Invalid Credentials");
			return "login";
		}

	}

	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		session.invalidate();
		map.addAttribute("msg", "Logout Sucessfully");
		return "login";

	}

	@GetMapping("/search")
	public String getEmployeeSearch(ModelMap map,
			@SessionAttribute(name = "sessionKey", required = false) Employee employee) {
		if (employee != null) {
			return "searchpage";
		} else {
			map.addAttribute("errMsg", "Please Login First ");
			return "login";
		}

	}

	@PostMapping("/search")
	public String getEmployee(ModelMap map, @SessionAttribute(name = "sessionKey", required = false) Employee employee,
			int empId) {
		Employee employee2 = service.getEmployee(empId);
		if (employee != null) {
			if (employee2 != null) {
				map.addAttribute("details", employee2);

			} else {
				map.addAttribute("msg", "  Employee Id Not Present");
			}
			return "searchpage";
		} else {
			map.addAttribute("msg", "Please Login First");
			return "login";
		}

	}

	@GetMapping("/delete")
	public String removeEmployee(ModelMap map,
			@SessionAttribute(name = "sessionKey", required = false) Employee employee) {
		if (employee != null) {
			return "deletepage";
		} else {
			map.addAttribute("errMsg", "Please Login First ");
			return "login";
		}
	}

	@PostMapping("/delete")
	public String deleteEmployee(ModelMap map,
			@SessionAttribute(name = "sessionKey", required = false) Employee employee, int empId) {
		boolean output = service.deleteEmployee(empId);
		if (employee != null) {
			if (output != false) {
				map.addAttribute("delete", empId + " :Id Deleted Sucessfully ");

			} else {
				map.addAttribute("msg", "  Employee Id Not Present");
			}
			return "deletepage";
		} else {
			map.addAttribute("msg", "Please Login First");
			return "login";
		}

	}

	@GetMapping("/viewall")
	public String viewAllEmployees(ModelMap map,
			@SessionAttribute(name = "sessionKey", required = false) Employee employee) {
		List<Employee> employees=service.viewAllEmployee();
		if (employee != null) {
			if (employees != null) {
				map.addAttribute("viewall",employees);

			} else {
				map.addAttribute("msg", "  Employee DataBase Is Empty");
			}
			return "viewallpage";
		} else {
			map.addAttribute("msg", "Please Login First");
			return "login";
		}
	}

	@GetMapping("/add")
	public String addEmployee(ModelMap map,
			@SessionAttribute(name = "sessionKey", required = false) Employee employee) {
		if (employee != null) {
			return "addpage";
		} else {
			map.addAttribute("errMsg", "Please Login First ");
			return "login";
		}
	}

	@PostMapping("/add")
	public String addEmployees(ModelMap map,
			@SessionAttribute(name = "sessionKey", required = false) Employee employee, Employee employee2) {
		boolean added = service.addEmployee(employee2);
		if (employee != null) {
			if (added != false) {
				map.addAttribute("msg", "Employee Details Added Sucessfully ");

			} else {
				map.addAttribute("msg", "Something Went Wrong Please Check");
			}
			return "addpage";
		} else {
			map.addAttribute("msg", "Please Login First");
			return "login";
		}
	}

	@GetMapping("/update")
	public String updateEmployee(ModelMap map,
			@SessionAttribute(name = "sessionKey", required = false) Employee employee) {
		if (employee != null) {
			return "updatepage";
		} else {
			map.addAttribute("errMsg", "Please Login First ");
			return "login";
		}
	}
@PostMapping("/update")
	public String updateEmployees(ModelMap map, int id,String name,String password,Date dob, 
			@SessionAttribute(name = "sessionKey", required = false) Employee employee) {
		if (employee != null) {
			if (service.updateEmployee(id,name,password,dob)) {
				map.addAttribute("msg", "Employee Details Updated Sucessfully ");
				return "updatepage";

			} else {
				map.addAttribute("msg", " Something went wrong");
			}
			return "updatepage";
		} else {
			map.addAttribute("msg", "Please Login First");
			return "login";
		}

	}
}
