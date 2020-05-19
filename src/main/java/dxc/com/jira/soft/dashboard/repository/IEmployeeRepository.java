package dxc.com.jira.soft.dashboard.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import dxc.com.jira.soft.dashboard.model.Employee;

@Repository
public interface IEmployeeRepository {
		
	public List<Employee> findAllEmployee();
}
