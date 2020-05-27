package dxc.com.jira.soft.dashboard.dao.employee;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface IEmployeeDAO {
	public List<EmployeeSearchStory> findEmployeeByParam(ParamSearchEmployee pse);
	public List<EmployeeNotLogWork> findEmployeeNotLogWork(ParamSearchEmployee pse);
}
