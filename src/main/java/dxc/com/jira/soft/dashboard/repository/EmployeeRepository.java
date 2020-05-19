package dxc.com.jira.soft.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dxc.com.jira.soft.dashboard.model.Employee;

@Repository
public class EmployeeRepository implements IEmployeeRepository{
	
	// define field for entity manager
	private EntityManager entityManager;
	
	//injection into object
	@Autowired
	public EmployeeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		String queryString = "FROM Employee";
		Query<Employee> theQuery = currentSession.createQuery(queryString, Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}
	
	
}
