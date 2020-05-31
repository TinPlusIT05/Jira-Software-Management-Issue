package dxc.com.jira.soft.dashboard.dao.issue;

import java.util.List;

import org.springframework.stereotype.Repository;

import dxc.com.jira.soft.dashboard.model.Issue;

@Repository
public interface IIssueDAO {
	//get all data from Issue
	public List<Issue> getIssueDefault();

	//get a issue by id
	public List<Issue> findIssueId(Long issueId);
	
	//get issue Complete
	public List<IssueData> getIssueComplete();
	
	//get issue InComplete
//	public List<IssueData> getIssueInComplete();
	
	//get value issue Complete
	int getValueIssueComplete(String priority,String issueName);
	
	//get catalog
	public List<IssueData> getIssueCategory();
	
	
	
}
