package dxc.com.jira.soft.dashboard.clients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.api.domain.User;

import dxc.com.jira.soft.dashboard.service.JiraClientService;
import io.atlassian.util.concurrent.Promise;

@Component
public class JiraRestClientResult {
	
	private JiraRestClient JiraRestClient;
	
	private JiraRestClientResult() throws Exception {
		
		JiraClientService  jiraService = new JiraClientService();
		this.JiraRestClient = jiraService.getJiraClient();
	}
	
	public Iterable<User> getAllEmployees() {
        // Get all user from Jira Server 
        Iterable<User> users = JiraRestClient.getUserClient().findUsers(".").claim();
        
        return users;
	}
	
	public Iterable<BasicProject> getAllProject(){
		//get all project from jira
		Iterable<BasicProject> projects = JiraRestClient.getProjectClient().getAllProjects().claim();
		
		return projects;
		
	}
    
	public List<BasicProject> getProjectsForEmployee(String employeeName){
	
		List<BasicProject> projects = new ArrayList<BasicProject>();
		String searchJql = "assignee =" + employeeName;
	    Promise<SearchResult> searchJqlPromise = JiraRestClient.getSearchClient().searchJql(searchJql);
	   	for(Issue issue : searchJqlPromise.claim().getIssues()) {
	   		projects.add(issue.getProject());
	   	}
	   	return projects;
	}
    
	public List<User> getEmployeesForProject(String projectName){
			
		List<User> users = new ArrayList<User>();
		String searchJql = "project =" + projectName;
	    Promise<SearchResult> searchJqlPromise = JiraRestClient.getSearchClient().searchJql(searchJql);
	   	for(Issue issue : searchJqlPromise.claim().getIssues()) {
	   		users.add(issue.getAssignee());
	   	}
	   	return users;
	}
   
	
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

	
//	public static List<Project> getAllProject() throws
	
	
//	public List<Project> getProjectsForEmployee(String employeeName, JiraRestClient client){
//		
//		List<Project> setProjectsForEmp = new ArrayList<Project>();
//		Project project;
//		
//		String searchJql = "assignee =" + employeeName;
//        Promise<SearchResult> searchJqlPromise = client.getSearchClient().searchJql(searchJql);
//       	for(Issue issue : searchJqlPromise.claim().getIssues()) {
//       		project = new Project();
//       		String projectName = issue.getAssignee().getName();
//       		project.setProjectName(projectName);
//       		project.setDescription("Demo Jira Server");
//       		project.setEmployees(employees);
//       		String projectName = issue.getProject().getName();
//       		
//       	}
//		
//	}
//	
//	public List<Employee> getEmployeesForProject(String projectName, JiraRestClient client){
//		List<Employee> listEmpForProject = new ArrayList<Employee>();
//		Employee emp;
//		
//		String searchJql = "project =" + projectName;
//		Promise<SearchResult> searchJqlPromise = client.getSearchClient().searchJql(searchJql);
//       	for(Issue issue : searchJqlPromise.claim().getIssues()) {
//       		emp = new Employee();
//       		String employeeName = issue.getAssignee().getName();
//       		emp.setEmployeeName(employeeName);
//       		emp.setRole("Dev");
//       	}
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public List<Project> getAllProjects() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
