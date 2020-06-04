package dxc.com.jira.soft.dashboard.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="employee")
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EmployeeID")
	private long employeeId;
	
	@Column(name="EmployeeName", nullable = false)
	private String employeeName;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ProjectEmployee", 
        joinColumns = @JoinColumn(name = "EmployeeID"),
        inverseJoinColumns = @JoinColumn(name = "ProjectID"))
	private List<Project> projects;
	
	public Employee() {
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Employee(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
}
