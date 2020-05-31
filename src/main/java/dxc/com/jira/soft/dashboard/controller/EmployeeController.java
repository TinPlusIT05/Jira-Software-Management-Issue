package dxc.com.jira.soft.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dxc.com.jira.soft.dashboard.dao.employee.ParamSearchEmployee;
import dxc.com.jira.soft.dashboard.model.Employee;
import dxc.com.jira.soft.dashboard.service.IEmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService iemployeeService;
	

	@RequestMapping(value = "/loadProjects", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody List<String> loadProjects(@RequestBody Employee e) {
		List<String> users = iemployeeService.searchProjectNameByEmployee(e.getEmployeeName());
		  return users;
	 }
	
	@GetMapping({"/","search"})
	public String searchEmpByAllParam( @RequestParam(name="projectName", required = false) String projectName,
			@RequestParam(name="employeeName", required=false) String employeeName,
			@RequestParam(name="dateFrom", required = false) String dateFrom,
			@RequestParam(name="dateTo", required=false) String dateTo,
			Model model) {
		ParamSearchEmployee pse = new ParamSearchEmployee(dateFrom, dateTo, projectName, employeeName);
		model.addAttribute("allEmployees", iemployeeService.getAllEmployee());
//		model.addAttribute("allProjects", iemployeeService.getAllProject());
		model.addAttribute("firstProject", iemployeeService.searchProjectDefault());
		model.addAttribute("employeeLogWork", iemployeeService.searchEmpByParam(pse));
		model.addAttribute("employeeNotLogWork", iemployeeService.searchEmpNotLogWork(pse));
		model.addAttribute("dateBetweenRanges", iemployeeService.getDaysBetweenDates(pse));
		model.addAttribute("mapBetweenDayTimeEmp", iemployeeService.getListTimeEmployee(pse));
		return "index";
	}
}
