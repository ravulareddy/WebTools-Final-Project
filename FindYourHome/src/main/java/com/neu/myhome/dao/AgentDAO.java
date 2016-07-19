package com.neu.myhome.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Agent;

public class AgentDAO extends DAO {

	public AgentDAO() {

	}

	public Agent findAgentByName(String name) throws AdException {
		try {
			begin();
			Criteria agentCrit = getSession().createCriteria(Agent.class);
			agentCrit.add(Restrictions.eq("role", "AGENT"));
			Criterion firstName = Restrictions.like("firstName", name);
			Criterion lastName = Restrictions.like("lastName", name);
			LogicalExpression leOr = Restrictions.or(firstName, lastName);
			agentCrit.add(leOr);

			Agent user = (Agent) agentCrit.uniqueResult();
			if (user != null) {
				System.out.println("user >>>>>>>" + user.getPersonId());
				System.out.println("user >>>>>>>" + user.getName());
				System.out.println("user >>>>>>>" + user.getPassword());
			}
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + name, e);
		}
	}

	public List<Agent> findAllAgents() throws AdException {
		try {
			begin();
			Criteria agentCrit = getSession().createCriteria(Agent.class);
			agentCrit.add(Restrictions.eq("role", "AGENT"));
			agentCrit.setFirstResult(0);
			agentCrit.setMaxResults(10);
			List<Agent> results = (List<Agent>) agentCrit.list();
			commit();
			return results;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get results for findAllAgents ", e);
		}
	}

}
