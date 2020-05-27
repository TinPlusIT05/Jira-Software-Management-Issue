package dxc.com.jira.soft.dashboard.dao.employee;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ParamSearchEmployee {
	
	private String dateFrom; 
	private	String dateTo; 
	private String projectName;
	private String employeeName;
	
	public ParamSearchEmployee() {	
	}
	
	public ParamSearchEmployee(String dateFrom, String dateTo, String projectName, String employeeName) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.projectName = projectName;
		this.employeeName = employeeName;
	}



	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}	
	
	 // reflection toString from apache commons
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
	
}
