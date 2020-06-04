package dxc.com.jira.soft.dashboard.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.api.domain.User;

import dxc.com.jira.soft.dashboard.clients.JiraRestClientResult;
import dxc.com.jira.soft.dashboard.dao.employee.EmployeeLogWork;
import dxc.com.jira.soft.dashboard.dao.employee.EmployeeNotLogWork;
import dxc.com.jira.soft.dashboard.dao.employee.IEmployeeDAO;
import dxc.com.jira.soft.dashboard.dao.employee.ParamSearchEmployee;
import dxc.com.jira.soft.dashboard.dao.project.IProjectDAO;
import dxc.com.jira.soft.dashboard.model.Employee;
import dxc.com.jira.soft.dashboard.model.Project;
import dxc.com.jira.soft.dashboard.util.DateFomatUtils;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeDAO iemployeeRepo;
	
	@Autowired
	private IProjectDAO iprojectRepo;
	
	@Autowired
	private JiraRestClientResult jiraClient;
	
	@Override
	public Project searchProjectDefault() {
		// TODO Auto-generated method stub
		return iprojectRepo.getProjectDefault();
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		return iemployeeRepo.getAllEmplopyee();
	}
	
	@Override
	public List<String> searchProjectNameByEmployee(String employeeName) {
		// TODO Auto-generated method stub
		return iprojectRepo.findProjectNameByEmployee(employeeName);
	}

	@Override
	public List<EmployeeLogWork> searchEmpByParam(ParamSearchEmployee pse) {
		return iemployeeRepo.findEmployeeLogwork(pse);
	}

	@Override
	public List<EmployeeNotLogWork> searchEmpNotLogWork(ParamSearchEmployee pse) {
		return iemployeeRepo.findEmployeeNotLogWork(pse);
	}
	
//	list of day by day base on day range
	@Override
	public List<String> getDaysBetweenDates(ParamSearchEmployee pse){
		
		List<String> dateCurrentWeek = DateFomatUtils.dateCurrentWeek();
		
		List<String> daysBetween = new ArrayList<String>();
		
		
		LocalDate dateFromLocal = null , dateToLocal = null;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		if(pse.getDateFrom() == null && pse.getDateTo() == null) {
			dateFromLocal = LocalDate.parse(dateCurrentWeek.get(0), formatter);
			dateToLocal = LocalDate.parse(dateCurrentWeek.get(1), formatter);
		}
		else if (pse.getDateFrom() != null && pse.getDateTo() != null){
			dateFromLocal = LocalDate.parse(pse.getDateFrom(), formatter); 
			dateToLocal = LocalDate.parse(pse.getDateTo(), formatter); 
		}
		
		while(!dateFromLocal.isAfter(dateToLocal)) {
			daysBetween.add(dateFromLocal.format(formatter));
			dateFromLocal = dateFromLocal.plusDays(1);
		}
		return daysBetween;
	}
	
//	list time day by day(day range) of all employee a row  
	@Override
	public String getTimeDayByDay(String employeeName, String date, List<EmployeeLogWork> empLogworks) {
		
		String getTimeEmp = "0.0";
		for(EmployeeLogWork empLogwork : empLogworks) {
			if(empLogwork.getDateWorkLog().equals(date) && empLogwork.getEmployeeName().equals(employeeName))
				getTimeEmp = String.valueOf(empLogwork.getTimeTotalWorkLog());
		}
		return getTimeEmp;
	}

	@Override
	public Set<String> getEmployeeSearch(List<EmployeeLogWork> empLogworks) {
		// TODO Auto-generated method stub
		Set<String> employees = new HashSet<String>();
		
		for(EmployeeLogWork empLogwork : empLogworks)
			employees.add(empLogwork.getEmployeeName());
		return employees;
	}

//	map consit of key: name of employee & value : list time day by day(func above) 
	@Override
	public Map<String, List<String>> getListTimeEmployee(ParamSearchEmployee pse) {
		// TODO Auto-generated method stub
		List<EmployeeLogWork> empLogworks = iemployeeRepo.findEmployeeLogwork(pse);
		List<String> daysBetween = getDaysBetweenDates(pse);
		Set<String> employees = getEmployeeSearch(empLogworks);
		
		Map<String, List<String>> mapEmpTimeDayByDay = new HashMap<String, List<String>>();
		
		for (String emp : employees) {
			List<String> timeEmployeeBetweenDays = new ArrayList<String>();
			for(String day : daysBetween) {
				timeEmployeeBetweenDays.add(getTimeDayByDay(emp, day, empLogworks));
			}
			mapEmpTimeDayByDay.put(emp, timeEmployeeBetweenDays);
		}
		return mapEmpTimeDayByDay;
	}


	@Override
	public void saveEmployee() {
		// TODO Auto-generated method stub
		// Get data user from database
		List<Employee> employees = iemployeeRepo.getAllEmplopyee();
		Map<String, Employee> mapEmployeeDB = new HashMap<String, Employee>();
		if(mapEmployeeDB != null) {
			for(Employee emp : employees) {
				mapEmployeeDB.put(emp.getEmployeeName(), emp);
			}
		}
		// Get data user from jira
		Iterable<User> users = jiraClient.getAllEmployees();
        for(User user : users ) {
        	String employeeName = user.getName();
        	
        	if(!mapEmployeeDB.containsKey(employeeName)) {
        		Employee emp = new Employee();
        		emp.setEmployeeName(employeeName);
//        		emp.setProjects(getPorjectsForEmployee(employeeName));
        		iemployeeRepo.save(emp);
        	}
        }
	}
	
	public List<Project> getPorjectsForEmployee(String employeeName){
		
		List<BasicProject> projects = jiraClient.getProjectsForEmployee(employeeName);
		List<Project> projectsDB = new ArrayList<Project>();
		Project p;
		for(BasicProject bp : projects) {
			p = new Project();
			p.setProjectId(bp.getId());
			p.setProjectName(bp.getName());
			projectsDB.add(p);
		}
		return projectsDB;
	}
	
	public List<Employee> getEmpForProject(String projectName){
		List<User> users = jiraClient.getEmployeesForProject(projectName);
		List<Employee> employeesDB = new ArrayList<Employee>();
		if(users != null ) {
			for(User user : users) {
				Employee e = new Employee();
				e.setEmployeeName(user.getName());
				employeesDB.add(e);
			}
		}
		return employeesDB;
	}
	

	@Override
	public void saveProject() {
		// TODO Auto-generated method stub
		// Get data project from database
		List<Project> projects = iprojectRepo.getAllProject();
		Map<String, Project> mapProjectDB = new HashMap<String, Project>();
		if(projects != null)
			for(Project project : projects)
				mapProjectDB.put(project.getProjectName(), project);
		
		// Get data project from jira
		Iterable<BasicProject> projectsJira = jiraClient.getAllProject();
        for(BasicProject projectJira : projectsJira ) {
        	String projectName = projectJira.getName();
        	if(!mapProjectDB.containsKey(projectName)) {
        		Project p = new Project(projectName);
            	iprojectRepo.save(p);
            }
        }
	}

}
