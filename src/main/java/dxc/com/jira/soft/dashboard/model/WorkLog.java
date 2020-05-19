package dxc.com.jira.soft.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="WorkLog")
@Entity
public class WorkLog {

	@Id
	@Column(name="WorkLogId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long worklogId;
	
	@OneToOne
	@JoinColumn(name="EmployeeID")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="IssueID")
	private Issue issue;
	
	@Column(name="Time")
	private String time;
	
	@Column(name="Date")
	private String date;

	public WorkLog() {
		super();
	}

	public WorkLog(Employee employee, Issue issue, String time, String date) {
		super();
		this.employee = employee;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
