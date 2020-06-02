package dxc.com.jira.soft.dashboard.clients;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

import dxc.com.jira.soft.dashboard.model.Employee;
import dxc.com.jira.soft.dashboard.model.Issue;
import dxc.com.jira.soft.dashboard.model.Project;
import dxc.com.jira.soft.dashboard.model.WorkLog;

public class JiraRestClientResult implements IJiraClient {
	
	private static final String JIRA_URL = "http://localhost:8080";
    private static final String JIRA_ADMIN_USERNAME = "tinnguyen.jira";
    private static final String JIRA_ADMIN_PASSWORD = "tincan123";
    
	public static void connectToJira(){	       
        URI uri = null;
		try {
			JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
			uri = new URI(JIRA_URL);
			JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);
	        System.out.println("JiraRestClient created successfully .. ");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			System.out.println("JiraRestClient error ! .. ");
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkLog> getAllWorkLogs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> getAllIssues() {
		// TODO Auto-generated method stub
		return null;
	}
}
