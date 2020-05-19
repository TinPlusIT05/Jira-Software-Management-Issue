package dxc.com.jira.soft.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dxc.com.jira.soft.dashboard.repository.EmployeeRepository;
import dxc.com.jira.soft.dashboard.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService iemployeeService;
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		model.addAttribute("employees", iemployeeService.findAllEmployee());
		System.out.println("Show all employee" + iemployeeService.findAllEmployee().toString());
		return "index";
	}
	

}
