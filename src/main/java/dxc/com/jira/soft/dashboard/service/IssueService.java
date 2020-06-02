package dxc.com.jira.soft.dashboard.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dxc.com.jira.soft.dashboard.dao.issue.IIssueDAO;
import dxc.com.jira.soft.dashboard.dao.issue.IssueDAO;
import dxc.com.jira.soft.dashboard.dao.issue.IssueData;
import dxc.com.jira.soft.dashboard.model.IssueModel;

@Service
public class IssueService implements IIssueDAO {
	@Autowired
	private IssueDAO iisueRepo;
	
	@Override
	public List<IssueModel> getIssueDefault()
	{
		return iisueRepo.getIssueDefault();
	}
	
	@Override
	public List<IssueModel> findIssueId(Long issueId){
		return iisueRepo.findIssueId(issueId);
	}
	
	@Override
	public List<IssueData> getIssueComplete() {
		return iisueRepo.getIssueComplete();
	}
	@Override
	public List<IssueData> getIssueInComplete() {
		
		return iisueRepo.getIssueInComplete();
	}
	@Override
	public List<IssueData> getIssueCategory() {
		
		return iisueRepo.getIssueCategory();
	}
	
	public List<IssueData> getIssueCategoryIn() {
		
		return iisueRepo.getIssueCategoryIn();
	}

	@Override
	public int getValueIssueComplete(String priority, String issueName) {
		
		return iisueRepo.getValueIssueComplete(priority, issueName);
	}

	@Override
	public List<IssueData> getIssueNameCategory() {
		
		return iisueRepo.getIssueNameCategory();
	}

	@Override
	public int getValueIssueInComplete(String priority, String issueName) {
		
		return iisueRepo.getValueIssueInComplete(priority, issueName);
	}

	

	
}
