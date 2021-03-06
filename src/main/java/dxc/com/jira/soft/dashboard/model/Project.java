package dxc.com.jira.soft.dashboard.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="project")
@Table(name="Project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProjectID")
	private long projectId;
	
	@Column(name="ProjectName")
	private String projectName;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "projects")
	private List<Employee> employees;
	
	public Project() {
		
	}
	
	public Project(String projectName) {
		this.projectName = projectName;
	}
	
	public Project(String projectName, List<Employee> employees) {
		super();
		this.projectName = projectName;
		this.employees = employees;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	
	
	
	
}
