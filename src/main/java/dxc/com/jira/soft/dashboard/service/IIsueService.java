package dxc.com.jira.soft.dashboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dxc.com.jira.soft.dashboard.dao.issue.IssueData;
import dxc.com.jira.soft.dashboard.model.IssueModel;

@Service
public interface IIsueService {
	public List<IssueModel> getIssueDefault();
	
	public List<IssueModel> findIssueId(Long issueId);

	public List<IssueData> getIssueComplete();
	
	public List<IssueData> getIssueInComplete();
	
	int getValueIssueComplete(String priority,String issueName);
	int getValueIssueInComplete(String priority,String issueName);
	
	//get catalog for Complete and InComplete
	public List<IssueData> getIssueCategory();
	public List<IssueData> getIssueCategoryIn();
	
	//get category issueName for 2 data table
	List<IssueData> getIssueNameCategory();
}
