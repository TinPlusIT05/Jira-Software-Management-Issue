package dxc.com.jira.soft.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dxc.com.jira.soft.dashboard.dao.employee.ParamSearchEmployee;
import dxc.com.jira.soft.dashboard.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService iemployeeService;
	
	@GetMapping("/project")
	public String searchProject(Model model) {
		model.addAttribute("resultProject", iemployeeService.searchProjectDefault());
		return "index";
	}
	
	@GetMapping("/project/{employeeName}")
	public String searchProjectByEmployeeName(@PathVariable String employeeName, Model model) {
		model.addAttribute("resultProjectByEmployee", iemployeeService.searchProjectNameByEmployee(employeeName));
		return "index";
	}
	
	@GetMapping("/employees/search")
	public String searchEmpByAllParam( @RequestParam(name="projectName", required = false) String projectName,
			@RequestParam(name="employeeName", required=false) String employeeName,
			@RequestParam(name="dateFrom", required = false) String dateFrom,
			@RequestParam(name="dateTo", required=false) String dateTo,
			Model model) {
		ParamSearchEmployee pse = new ParamSearchEmployee(dateFrom, dateTo, projectName, employeeName);
		model.addAttribute("employeeLogWork", iemployeeService.searchEmpByParam(pse));
		model.addAttribute("employeeNotLogWork", iemployeeService.searchEmpNotLogWork(pse));
		return "index";
	}
}
