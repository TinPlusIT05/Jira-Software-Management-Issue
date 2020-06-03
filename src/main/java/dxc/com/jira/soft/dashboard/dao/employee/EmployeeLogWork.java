package dxc.com.jira.soft.dashboard.dao.employee;

public class EmployeeLogWork {
	
	private String employeeName;
	private String dateWorkLog;
	private float timeTotalWorkLog;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDateWorkLog() {
		return dateWorkLog;
	}
	public void setDateWorkLog(String dateWorkLog) {
		this.dateWorkLog = dateWorkLog;
	}
	public float getTimeTotalWorkLog() {
		return timeTotalWorkLog;
	}
	public void setTimeWorkLog(float timeTotalWorkLog) {
		this.timeTotalWorkLog = timeTotalWorkLog;
	}
	@Override
	public String toString() {
		return "EmployeeSearchStory [employeeName=" + employeeName + ", dateWorkLog=" + dateWorkLog
				+ ", timeTotalWorkLog=" + timeTotalWorkLog + "]";
	}
	
	
	
}
