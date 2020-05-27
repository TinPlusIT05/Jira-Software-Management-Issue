package dxc.com.jira.soft.dashboard.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import dxc.com.jira.soft.dashboard.model.Project;

@Repository
public class ProjectDAO implements IProjectDAO{
	
// define field for entity manager
	private EntityManager entityManager;
	
	//injection into object
	@Autowired
	public ProjectDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Project getProjectDefault() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		String queryString = "FROM project ";
		Query<Project> theQuery = currentSession.createQuery(queryString, Project.class);
		theQuery.setMaxResults(1);
		
		Project p = (Project)theQuery.uniqueResult();
		
		System.out.println(p.toString());
		return p;
	}

	@Override
	public List<String> findProjectNameByEmployee(String employeeName) {
		// TODO Auto-generated method stub
		Session currSession = entityManager.unwrap(Session.class);
		
		String queryString = "SELECT p.projectName "
				+ "FROM project p "
				+ "JOIN p.employees emps "
				+ "WHERE emps.employeeName=:uEmployeeName";
		Query<String> theQuery = currSession.createQuery(queryString, String.class);
		theQuery.setParameter("uEmployeeName", employeeName);
		List<String> row = theQuery.getResultList();
		List<String> rs = new ArrayList<String>();
		for(String empName : row) {
			rs.add(empName);
		}
		System.out.println(rs.toString());
		return rs;
	}

}
