package com.neu.myhome.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Admin;
import com.neu.myhome.pojo.Agent;
import com.neu.myhome.pojo.Buyer;
import com.neu.myhome.pojo.Owner;
import com.neu.myhome.pojo.Person;

public class UserDAO extends DAO {

	public UserDAO() {

	}

	public Person get(String userName) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Person where name = :userName");
			q.setString("userName", userName);
			Person user = (Person) q.uniqueResult();

			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + userName, e);
		}
	}

	public Agent getAgentProfile(long personId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Agent where personId = :personId");
			q.setLong("personId", personId);
			Agent agent = (Agent) q.uniqueResult();

			commit();
			return agent;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get agent ", e);
		}
	}

	public boolean updateProfile(long PerId, Agent agent) throws AdException {
		try {
			System.out.println("query >>. uodate profile user" + agent.getPersonId());
			System.out.println("query >>. uodate profile agent" + agent.getPersonId());
			boolean chk;
			begin();
			Query q = getSession()
					.createQuery("update Person set firstName= :firstName, lastName= :lastName, emailId= :emailId,"
							+ "phoneNumber= :phoneNumber, name= :name, password= :password, role= :role where personId= :personId ");
			System.out.println("query >>. uodate profile " + q.getQueryString());
			q.setLong("personId", PerId);
			q.setString("firstName", agent.getFirstName());
			q.setString("lastName", agent.getLastName());
			q.setString("emailId", agent.getEmailId());
			q.setString("phoneNumber", agent.getPhoneNumber());
			q.setString("name", agent.getName());
			q.setString("password", agent.getPassword());
			q.setString("role", agent.getRole());
			int person = q.executeUpdate();

			Query agntQ = getSession().createQuery(
					"update Agent set agencyName= :agencyName, agentType= :agentType where personId= :personId ");
			agntQ.setLong("personId", PerId);
			agntQ.setString("agencyName", agent.getAgencyName());
			agntQ.setString("agentType", agent.getAgentType());
			int agentProf = agntQ.executeUpdate();
			if (person != 0 && agentProf != 0) {
				chk = true;
			} else {
				chk = false;
			}
			commit();
			return chk;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get agent ", e);
		}
	}

	public List<Person> findUserByrole(String role) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Person where role = :role");
			q.setString("role", role);
			List<Person> personList = (List<Person>) q.list();
			System.out.println("list with admin role >>>>>>>>" + personList.toString());
			commit();
			return personList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get findUserByrole ", e);
		}
	}

	public Person findUser(String userName, String password) throws AdException {
		try {
			begin();
			System.out.println("Inside find user");
			Person user = null;
			Query q = getSession().createQuery("from Person where name= :userName and password= :password");
			q.setString("userName", userName);
			q.setString("password", password);
			if (q != null) {
				user = (Person) q.uniqueResult();
				if (user != null) {
					System.out.println("user >>>>>>>" + user.getPersonId());
					System.out.println("user >>>>>>>" + user.getName());
					System.out.println("user >>>>>>>" + user.getPassword());
				}
				commit();
			}
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + userName, e);
		}
	}

	/*
	 * public String findUserType(User user, Set<UserTypes> userTypes) throws
	 * AdException { String userType =""; try { begin(); Criteria criteria =
	 * getSession().createCriteria(User.class); Iterator it =
	 * userTypes.iterator(); UserTypes ut = null; while(it.hasNext()) { ut =
	 * (UserTypes)it.next();
	 * 
	 * criteria.add(Restrictions.eq("userTypes.role",ut.getRole())); } commit();
	 * return ut.getRole(); } catch (HibernateException e) { rollback(); throw
	 * new AdException("Could not get user role " + user.getName(), e); }
	 * 
	 * }
	 */
	public Person create(String username, String password, String emailId, String firstName, String lastName,
			String phoneNumber, String role) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			Person person = null;

			// User user = new User(username,password, emailId, userType);
			if (role.equals("AGENT")) {
				person = new Agent();
			} else if (role.equals("ADMIN")) {
				person = new Admin();
			} else if (role.equals("BUYER")) {
				person = new Buyer();
			} else if (role.equals("OWNER")) {
				person = new Owner();
			}
			person.setRole(role);
			person.setFirstName(firstName);
			person.setEmailId(emailId);
			person.setLastName(lastName);
			person.setRole(role);
			person.setEmailId(emailId);
			person.setPhoneNumber(phoneNumber);
			person.setName(username);
			person.setPassword(password);
			getSession().save(person);

			commit();
			return person;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(Person user) throws AdException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete user " + user.getName(), e);
		}
	}
}
