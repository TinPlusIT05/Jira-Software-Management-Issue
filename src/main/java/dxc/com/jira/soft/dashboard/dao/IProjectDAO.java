package dxc.com.jira.soft.dashboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import dxc.com.jira.soft.dashboard.model.Project;


@Repository
public interface IProjectDAO {
	
	public Project getProjectDefault();
	public List<String> findProjectNameByEmployee(String employeeName);
}
