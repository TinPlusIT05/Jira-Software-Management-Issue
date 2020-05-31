package dxc.com.jira.soft.dashboard.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dxc.com.jira.soft.dashboard.dao.issue.IIssueDAO;
import dxc.com.jira.soft.dashboard.dao.issue.IssueDAO;
import dxc.com.jira.soft.dashboard.dao.issue.IssueData;
import dxc.com.jira.soft.dashboard.model.Issue;

@Service
public class IssueService implements IIssueDAO {
	@Autowired
	private IssueDAO iisueRepo;
	
	
	public List<Issue> getIssueDefault()
	{
		return iisueRepo.getIssueDefault();
	}
	
	@Override
	public List<Issue> findIssueId(Long issueId){
		return iisueRepo.findIssueId(issueId);
	}
	
	@Override
	public List<IssueData> getIssueComplete() {
		return iisueRepo.getIssueComplete();
	}
	

	public List<IssueData> getIssueCategory() {
		
		return iisueRepo.getIssueCategory();
	}

	@Override
	public int getValueIssueComplete(String priority, String issueName) {
		// TODO Auto-generated method stub
		return iisueRepo.getValueIssueComplete(priority, issueName);
	}
}
