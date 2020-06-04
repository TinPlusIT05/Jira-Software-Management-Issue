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

@Entity(name="issue")
@Table(name="Issue")
public class Issue {
	
	@Id
	@Column(name="IssueID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long issueId;
	
	@Column(name="IssueName")
	private String issueName;
	
	@ManyToOne
	@JoinColumn(name="ProjectID")
	private Project project;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Priority")
	private String priority;
	
	@OneToOne
	@JoinColumn(name="EmployeeID")
	private Employee employee;
	
	public Issue() {
	}

	public Issue(Long issueId, String issueName, Project project, String status, String description, String priority,
			Employee employee) {
		super();
		this.issueId = issueId;
		this.issueName = issueName;
		this.project = project;
		this.status = status;
		this.description = description;
		this.priority = priority;
		this.employee = employee;
	}

	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
