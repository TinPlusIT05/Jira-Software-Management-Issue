package dxc.com.jira.soft.dashboard.dao.employee;

public class EmployeeNotLogWork {
	private String employeeName;
	private Integer totalNotLogWork;
	
	public EmployeeNotLogWork() {
		
	}
	
	public EmployeeNotLogWork(String employeeName, Integer totalNotLogWork) {
		super();
		this.employeeName = employeeName;
		this.totalNotLogWork = totalNotLogWork;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getTotalNotLogWork() {
		return totalNotLogWork;
	}
	public void setTotalNotLogWork(Integer totalNotLogWork) {
		this.totalNotLogWork = totalNotLogWork;
	}

	@Override
	public String toString() {
		return "EmployeeNotLogWork [employeeName=" + employeeName + ", totalNotLogWork=" + totalNotLogWork + "]";
	}
	
}
