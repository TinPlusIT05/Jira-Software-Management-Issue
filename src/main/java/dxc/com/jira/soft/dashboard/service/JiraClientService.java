package dxc.com.jira.soft.dashboard.service;

import java.net.URI;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

public class JiraClientService {
	
	private static final String JIRA_URL = "http://localhost:8080";
    private static final String JIRA_ADMIN_USERNAME = "tinnguyen.jira";
    private static final String JIRA_ADMIN_PASSWORD = "tincan123";
    private JiraRestClient jiraClient;
    
    
    public JiraClientService() throws Exception {
		super();
		JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
		URI uri = new URI(JIRA_URL);
		JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);
	    System.out.println("JiraRestClient created successfully .. ");
	    
		this.jiraClient = client;
	}

	public JiraRestClient getJiraClient() {
		return jiraClient;
	}
    
}
