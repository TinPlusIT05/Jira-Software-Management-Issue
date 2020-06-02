package dxc.com.jira.soft.dashboard.dao.issue;

import org.springframework.stereotype.Repository;

import dxc.com.jira.soft.dashboard.model.IssueModel;
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
	public List<IssueModel> getIssueDefault() {
		Session currentSession = entityManager.unwrap(Session.class);
		String queryString = "FROM issue";

		List<IssueModel> issue = currentSession.createQuery(queryString,IssueModel.class).getResultList();
		List<IssueModel> arrIssue = new ArrayList<IssueModel>();
		for(IssueModel i : issue) {
			arrIssue.add(i);	
		}
		System.out.println(arrIssue.toString());
		return arrIssue;
	}
	@Override
	public List<IssueModel> findIssueId(Long issueId){
		Session currSession = entityManager.unwrap(Session.class);
		String queryString = "FROM issue i "
				+ "WHERE i.issueId = :uIssueId";

		List<IssueModel> issueList = currSession.createQuery(queryString, IssueModel.class).setParameter("uIssueId", issueId).getResultList();

		List<IssueModel> arrIssue = new ArrayList<IssueModel>();
		for(IssueModel i : issueList ) {
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

	/*List Category for Complete Table*/
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
		

		return length;
	}

//Get Data InComplete
	public List<IssueData> getIssueInComplete() {
		Session session1 = entityManager.unwrap(Session.class);
		String query1 = "SELECT i.priority, COUNT(i.priority) AS total"
				+ " FROM issue i "
				+ "WHERE i.status In ('In Progress','To Do') "
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
					+ "WHERE i.status In ('In Progress','To Do') and i.priority In ('"+ item +"') "
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

	@Override
	@Transactional
	public int getValueIssueInComplete(String priority, String issueName) {
		Session session1 = entityManager.unwrap(Session.class);
		String query1 = "SELECT i.priority,i.issueName, COUNT(i.priority) AS total"
				+ " FROM issue i "
				+ "WHERE i.status In ('To Do','In Progress') AND i.priority = '"+  priority +"' AND  i.issueName = '"+issueName+"' "
				+ "GROUP BY i.priority,i.issueName ";
		List<Object[]> rows1 = session1.createQuery(query1.toString()).list();
		int length  = 0;
		for(Object[] row : rows1) {
			length  = Integer.parseInt(row[2].toString());
		}
		return length;
	}
	/*List Category for InComplete Table*/
	public List<IssueData> getIssueCategoryIn() {
		Session session1 = entityManager.unwrap(Session.class);
		String query1 = "SELECT i.priority, COUNT(i.priority) AS total"
				+ " FROM issue i "
				+ "WHERE i.status In ('To Do','In Progress') "
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
	//Name Category list for 2 table
		@Override
		public List<IssueData> getIssueNameCategory() {
			Session session1 = entityManager.unwrap(Session.class);
			String query1 = "SELECT i.issueName, COUNT(i.issueName) AS total"
					+ " FROM issue i "
					+ "GROUP BY i.issueName ";

			List<Object[]> rows1 = session1.createQuery(query1.toString()).list();
			List<String> issue1 = new ArrayList<String>();
			List<IssueData> issue = new ArrayList<IssueData>();
			for(Object[] row : rows1) {
				IssueData issdata = new IssueData();
				issdata.setNameIssue(row[0].toString());
				issdata.setTotal(Float.parseFloat(row[1].toString()));
				issue.add(issdata);
			}

			return issue;
			
		}

		


}
