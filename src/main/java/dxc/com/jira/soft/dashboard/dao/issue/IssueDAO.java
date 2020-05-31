package dxc.com.jira.soft.dashboard.dao.issue;

import org.springframework.stereotype.Repository;

import dxc.com.jira.soft.dashboard.model.Issue;
import dxc.com.jira.soft.dashboard.model.Project;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class IssueDAO implements IIssueDAO {
	private EntityManager entityManager;
	
	@Autowired
	public IssueDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Issue> getIssueDefault() {
		Session currentSession = entityManager.unwrap(Session.class);
		String queryString = "FROM issue";

		List<Issue> issue = currentSession.createQuery(queryString,Issue.class).getResultList();
		List<Issue> arrIssue = new ArrayList<Issue>();
		for(Issue i : issue) {
			arrIssue.add(i);	
		}
		System.out.println(arrIssue.toString());
		return arrIssue;
	}
	@Override
	public List<Issue> findIssueId(Long issueId){
		Session currSession = entityManager.unwrap(Session.class);
		String queryString = "FROM issue i "
				+ "WHERE i.issueId = :uIssueId";
							
		List<Issue> issueList = currSession.createQuery(queryString, Issue.class).setParameter("uIssueId", issueId).getResultList();
		
		List<Issue> arrIssue = new ArrayList<Issue>();
		for(Issue i : issueList ) {
			arrIssue.add(i);
		}
		System.out.println(arrIssue.toString());
		return arrIssue;
	}
	//Get Complete ISSUE
	@Override
	public List<IssueData> getIssueComplete() {
		Session session1 = entityManager.unwrap(Session.class);
		String query1 = "SELECT i.priority, COUNT(i.priority) AS total"
				+ " FROM issue i "
				+ "WHERE i.status In ('Done') "
				+ "GROUP BY i.priority ";

		List<Object[]> rows1 = session1.createQuery(query1.toString()).list();
		List<String> issue1 = new ArrayList<String>();
		for(Object[] row1 : rows1) {
			issue1.add(row1[0].toString());
		}
		List<IssueData> issue = new ArrayList<IssueData>();

		for (String item : issue1){
			Session session2 = entityManager.unwrap(Session.class);

			String query2 = "SELECT i.issueName, COUNT(i.priority) AS total"
					+ " FROM issue i "
					+ "WHERE i.status In ('Done') and i.priority In ('"+ item +"') "
					+ "GROUP BY i.issueName ";

			List<Object[]> rows2 = session2.createQuery(query2.toString()).list();

			for(Object[] row : rows2) {
				IssueData issdata = new IssueData();
				issdata.setNameIssue(row[0].toString());
				issdata.setTotal(Float.parseFloat(row[1].toString()));
				issdata.setNamePriority(item);
				issue.add(issdata);
			}
		}

		return issue;
	}
	
	/*List Category*/
	public List<IssueData> getIssueCategory() {
		Session session1 = entityManager.unwrap(Session.class);
		String query1 = "SELECT i.priority, COUNT(i.priority) AS total"
				+ " FROM issue i "
				+ "WHERE i.status In ('Done') "
				+ "GROUP BY i.priority ";

		List<Object[]> rows1 = session1.createQuery(query1.toString()).list();
		List<String> issue1 = new ArrayList<String>();
		List<IssueData> issue = new ArrayList<IssueData>();
		for(Object[] row : rows1) {
			IssueData issdata = new IssueData();
			issdata.setNamePriority(row[0].toString());
			issdata.setTotal(Float.parseFloat(row[1].toString()));
			issue.add(issdata);
		}
		
		return issue;
	}

	@Override
	@Transactional
	public int getValueIssueComplete(String priority, String issueName) {
		Session session1 = entityManager.unwrap(Session.class);
		String query1 = "SELECT i.priority,i.issueName, COUNT(i.priority) AS total"
				+ " FROM issue i "
				+ "WHERE i.status In ('Done') AND i.priority = '"+  priority +"' AND  i.issueName = '"+issueName+"' "
				+ "GROUP BY i.priority,i.issueName ";
		List<Object[]> rows1 = session1.createQuery(query1.toString()).list();
		int length  = 0;
		for(Object[] row : rows1) {
			length  = Integer.parseInt(row[2].toString());
		}
		System.out.println("legth"+ length);
		
		return length;
	}
	
	

	


	


}
