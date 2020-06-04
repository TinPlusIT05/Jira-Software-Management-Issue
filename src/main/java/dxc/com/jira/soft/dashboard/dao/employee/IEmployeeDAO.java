package dxc.com.jira.soft.dashboard.dao.employee;

import java.util.List;

import org.springframework.stereotype.Repository;

import dxc.com.jira.soft.dashboard.model.Employee;


@Repository
public interface IEmployeeDAO {
	
	public List<Employee> getAllEmplopyee();
	public List<EmployeeLogWork> findEmployeeLogwork(ParamSearchEmployee pse);
	public List<EmployeeNotLogWork> findEmployeeNotLogWork(ParamSearchEmployee pse);
	
	public void save(Employee e);
	
}
