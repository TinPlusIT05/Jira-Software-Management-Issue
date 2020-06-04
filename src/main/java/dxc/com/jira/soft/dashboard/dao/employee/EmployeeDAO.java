package dxc.com.jira.soft.dashboard.dao.employee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dxc.com.jira.soft.dashboard.model.Employee;
import dxc.com.jira.soft.dashboard.util.DateFomatUtils;

@Repository
public class EmployeeDAO implements IEmployeeDAO{
	
	// define field for entity manager
	private EntityManager entityManager;
	
	//injection into object
	@Autowired
	public EmployeeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> getAllEmplopyee() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		String queryString = "FROM employee ";
		Query<Employee> theQuery = currentSession.createQuery(queryString, Employee.class);
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}
	
	@Override
	public List<EmployeeLogWork> findEmployeeLogwork(ParamSearchEmployee pse) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		String queryString = "SELECT e.employeeName, w.date, SUM(w.time)"
				+ "FROM issue i "
				+ "JOIN employee e ON i.employee.employeeId = e.employeeId "
				+ "JOIN worklog w ON w.issue.issueId = i.issueId "
				+ "WHERE (:uEmployeeName IS NULL OR e.employeeName=:uEmployeeName) "
				+ "AND (:uProjectName IS NULL OR i.project.projectName=:uProjectName) "
				+ "AND (:uDateFrom IS NULL OR :uDateTo IS NULL OR "
				+ "(w.date BETWEEN :uDateFrom AND :uDateTo)) "
				+ "GROUP BY e.employeeName, w.date";
		
		Query<Object[]> theQuery = currentSession.createQuery(queryString, Object[].class);
		
		// get date of current week from monday to friday
		List<String> dateCurrentWeek = DateFomatUtils.dateCurrentWeek();
		
		if(pse.getDateFrom() == null && pse.getDateTo() == null) {
			theQuery.setParameter("uDateFrom", dateCurrentWeek.get(0));
			theQuery.setParameter("uDateTo", dateCurrentWeek.get(1));
		}
		else if (pse.getDateFrom() != null && pse.getDateTo() != null){
			theQuery.setParameter("uDateFrom", pse.getDateFrom());
			theQuery.setParameter("uDateTo", pse.getDateTo());
		}
		theQuery.setParameter("uEmployeeName", pse.getEmployeeName());
		
		theQuery.setParameter("uProjectName", pse.getProjectName());
		
		// save value  hibernate query to EmployeeSearchStory 
		List<EmployeeLogWork> rs = new ArrayList<EmployeeLogWork>();
		List<Object[]> rows = theQuery.getResultList();
		for(Object[] row : rows) {
			EmployeeLogWork emplw = new EmployeeLogWork();
			emplw.setEmployeeName(row[0].toString());
			// parse format dateWorkLog	
			emplw.setDateWorkLog(DateFomatUtils.dateFomat(row[1].toString()));
			emplw.setTimeWorkLog(Float.parseFloat(row[2].toString()));
			rs.add(emplw);
			System.out.println(rs.toString());
		}
		return rs;
	}

	@Override
	public List<EmployeeNotLogWork> findEmployeeNotLogWork(ParamSearchEmployee pse) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		String queryString = "SELECT e.employeeName, COUNT(*) "
				+ "FROM issue i, employee e "
				+ "WHERE i.employee.employeeId = e.employeeId "
				+ "AND i.issueId NOT IN (SELECT wk.issue.issueId FROM worklog wk) "
				+ "AND i.status = 'Done' "
				+ "AND (:uEmployeeName IS NULL OR e.employeeName=:uEmployeeName) "
				+ "AND (:uProjectName IS NULL OR i.project.projectName=:uProjectName) "
				+ "GROUP BY e.employeeName";
	
		Query<Object[]> theQuery = currentSession.createQuery(queryString, Object[].class);
		
		theQuery.setParameter("uEmployeeName", pse.getEmployeeName());
	
		theQuery.setParameter("uProjectName", pse.getProjectName());
		
		// save value  hibernate query to EmployeeSearchStory 
		List<EmployeeNotLogWork> rs = new ArrayList<EmployeeNotLogWork>();
		List<Object[]> rows = theQuery.getResultList();
		for(Object[] row : rows) {
			EmployeeNotLogWork eNotLogWork = new EmployeeNotLogWork();
			eNotLogWork.setEmployeeName(row[0].toString());
			eNotLogWork.setTotalNotLogWork(Integer.parseInt(row[1].toString()));
			rs.add(eNotLogWork);
			System.out.println(rs.toString());
		}
		return rs;
	}

	@Override
	public void save(Employee e) {
		// TODO Auto-generated method stub
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create the user ... finally LOL
		currentSession.save(e);
	}

	
}
