package dxc.com.jira.soft.dashboard.clients;

import java.util.List;

import dxc.com.jira.soft.dashboard.model.Employee;
import dxc.com.jira.soft.dashboard.model.Issue;
import dxc.com.jira.soft.dashboard.model.Project;
import dxc.com.jira.soft.dashboard.model.WorkLog;

public interface IJiraClient {
	
//  Get all user from Jira Server
	public List<Employee> getAllEmployees();
	
//  Get all project from Jira Server
	public List<Project> getAllProjects();
	
//  Get all worklog from Jira Server
	public List<WorkLog> getAllWorkLogs();
	
//  Get all issues from Jira Server
	public List<Issue> getAllIssues();
	
	
}
