package dxc.com.jira.soft.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dxc.com.jira.soft.dashboard.dao.IProjectDAO;
import dxc.com.jira.soft.dashboard.dao.employee.EmployeeNotLogWork;
import dxc.com.jira.soft.dashboard.dao.employee.EmployeeSearchStory;
import dxc.com.jira.soft.dashboard.dao.employee.IEmployeeDAO;
import dxc.com.jira.soft.dashboard.dao.employee.ParamSearchEmployee;
import dxc.com.jira.soft.dashboard.model.Project;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeDAO iemployeeRepo;
	
	@Autowired
	private IProjectDAO iprojectRepo;
	
	@Override
	public Project searchProjectDefault() {
		// TODO Auto-generated method stub
		return iprojectRepo.getProjectDefault();
	}

	@Override
	public List<String> searchProjectNameByEmployee(String employeeName) {
		// TODO Auto-generated method stub
		return iprojectRepo.findProjectNameByEmployee(employeeName);
	}

	@Override
	public List<EmployeeSearchStory> searchEmpByParam(ParamSearchEmployee pse) {
		return iemployeeRepo.findEmployeeByParam(pse);
	}

	@Override
	public List<EmployeeNotLogWork> searchEmpNotLogWork(ParamSearchEmployee pse) {
		return iemployeeRepo.findEmployeeNotLogWork(pse);
	}
	
}
