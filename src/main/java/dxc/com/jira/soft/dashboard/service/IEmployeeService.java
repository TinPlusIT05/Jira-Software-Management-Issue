package dxc.com.jira.soft.dashboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dxc.com.jira.soft.dashboard.model.Employee;

@Service
public interface IEmployeeService {
	
	public List<Employee> findAllEmployee();
}
