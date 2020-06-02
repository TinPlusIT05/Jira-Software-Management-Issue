package dxc.com.jira.soft.dashboard.dao.issue;

import java.util.List;

import org.springframework.stereotype.Repository;

import dxc.com.jira.soft.dashboard.model.IssueModel;

@Repository
public interface IIssueDAO {
	//get all data from Issue
	public List<IssueModel> getIssueDefault();

	//get a issue by id
	public List<IssueModel> findIssueId(Long issueId);
	
	//get issue Complete
	public List<IssueData> getIssueComplete();
	
	//get issue InComplete
	public List<IssueData> getIssueInComplete();
	
	//get value issue Complete and Incomplete
	int getValueIssueComplete(String priority,String issueName);
	int getValueIssueInComplete(String priority,String issueName);
	
	//get catalog for Complete and InComplete
	public List<IssueData> getIssueCategory();
	public List<IssueData> getIssueCategoryIn();
	
	//get category issueName for 2 data table
	List<IssueData> getIssueNameCategory();

}
