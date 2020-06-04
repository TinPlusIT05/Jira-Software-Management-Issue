package dxc.com.jira.soft.dashboard.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import dxc.com.jira.soft.dashboard.dao.employee.EmployeeNotLogWork;
import dxc.com.jira.soft.dashboard.dao.employee.EmployeeLogWork;
import dxc.com.jira.soft.dashboard.dao.employee.ParamSearchEmployee;
import dxc.com.jira.soft.dashboard.model.Employee;
import dxc.com.jira.soft.dashboard.model.Project;

@Service
public interface IEmployeeService {
	
	public Project searchProjectDefault();
	
	public List<String> searchProjectNameByEmployee(String employeeName);
		
	public List<Employee> getAllEmployee();
	
	public List<EmployeeLogWork> searchEmpByParam(ParamSearchEmployee pse);
	
	public List<EmployeeNotLogWork> searchEmpNotLogWork(ParamSearchEmployee pse);
	
	public List<String> getDaysBetweenDates(ParamSearchEmployee pse);
	
	public Set<String> getEmployeeSearch(List<EmployeeLogWork> empLogworks);
	
	public Map<String, List<String>> getListTimeEmployee(ParamSearchEmployee pse);
	
	public String getTimeDayByDay(String employeeName, String date, List<EmployeeLogWork> empLogworks);
	
	public void saveEmployee();
	
	public void saveProject();
}
