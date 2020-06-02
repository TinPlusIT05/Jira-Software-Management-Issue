package dxc.com.jira.soft.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="worklog")
@Table(name="WorkLog")
public class WorkLog {

	@Id
	@Column(name="WorkLogId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long worklogId;
	
	@ManyToOne
	@JoinColumn(name="IssueID")
	private IssueModel issue;
	
	@Column(name="Time")
	private Float time;
	
	@Column(name="Date")
	private String date;

	public WorkLog() {
		super();
	}

	public WorkLog(IssueModel issue, Float time, String date) {
		super();
		this.issue = issue;
		this.time = time;
		this.date = date;
	}

	public Long getWorklogId() {
		return worklogId;
	}

	public void setWorklogId(Long worklogId) {
		this.worklogId = worklogId;
	}

	public IssueModel getIssue() {
		return issue;
	}

	public void setIssue(IssueModel issue) {
		this.issue = issue;
	}

	public Float getTime() {
		return time;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
