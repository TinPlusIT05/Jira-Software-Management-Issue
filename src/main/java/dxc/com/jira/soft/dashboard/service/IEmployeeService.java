package dxc.com.jira.soft.dashboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dxc.com.jira.soft.dashboard.dao.employee.EmployeeNotLogWork;
import dxc.com.jira.soft.dashboard.dao.employee.EmployeeSearchStory;
import dxc.com.jira.soft.dashboard.dao.employee.ParamSearchEmployee;
import dxc.com.jira.soft.dashboard.model.Project;

@Service
public interface IEmployeeService {
	
	public Project searchProjectDefault();
	public List<String> searchProjectNameByEmployee(String employeeName);
	
	public List<EmployeeSearchStory> searchEmpByParam(ParamSearchEmployee pse);
	
	public List<EmployeeNotLogWork> searchEmpNotLogWork(ParamSearchEmployee pse);
}
