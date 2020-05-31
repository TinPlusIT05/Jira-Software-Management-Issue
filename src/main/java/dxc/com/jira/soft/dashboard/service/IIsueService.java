package dxc.com.jira.soft.dashboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dxc.com.jira.soft.dashboard.dao.issue.IssueData;
import dxc.com.jira.soft.dashboard.model.Issue;

@Service
public interface IIsueService {
	public List<Issue> getIssueDefault();
	
	public List<Issue> findIssueId(Long issueId);

	public List<IssueData> getIssueComplete();
	
	public List<IssueData> getIssueInComplete();
}
