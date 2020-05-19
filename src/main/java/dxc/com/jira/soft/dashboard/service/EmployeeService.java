package dxc.com.jira.soft.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dxc.com.jira.soft.dashboard.model.Employee;
import dxc.com.jira.soft.dashboard.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository iemployeeRepo;
	
	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return iemployeeRepo.findAllEmployee();
	}

}
