package com.neu.myhome.dao;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.User;
import com.neu.myhome.pojo.UserTypes;

public class UserDAObkp extends DAO {

	public UserDAObkp() {
	}

	public User get(String userName) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from User where name = :userName");
			q.setString("userName", userName);
			User user = (User) q.uniqueResult();
			System.out.println("user >>>>>>>" + user.getPersonID());
			System.out.println("user >>>>>>>" + user.getName());
			System.out.println("user >>>>>>>" + user.getPassword());
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + userName, e);
		}
	}

	public User findUser(String userName, String password) throws AdException {
		try {
			begin();
			System.out.println("Inside find user");
			Query q = getSession().createQuery("from User where name= :userName and password= :password");
			q.setString("userName", userName);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			System.out.println("user >>>>>>>" + user.getPersonID());
			System.out.println("user >>>>>>>" + user.getName());
			System.out.println("user >>>>>>>" + user.getPassword());
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + userName, e);
		}
	}

	public String findUserType(User user, Set<UserTypes> userTypes) throws AdException {
		String userType = "";
		try {
			begin();
			Criteria criteria = getSession().createCriteria(User.class);
			Iterator it = userTypes.iterator();
			UserTypes ut = null;
			while (it.hasNext()) {
				ut = (UserTypes) it.next();

				criteria.add(Restrictions.eq("userTypes.role", ut.getRole()));
			}
			commit();
			return ut.getRole();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user role " + user.getName(), e);
		}

	}

	public User create(String username, String password, String emailId, String firstName, String lastName)
			throws AdException {
		try {
			begin();
			System.out.println("inside DAO");

			// User user = new User(username,password, emailId, userType);

			User user = new User(username, password, emailId);

			user.setFirstName(firstName);
			user.setLastName(lastName);
			// user.setUserType(userType);
			user.setEmailId(emailId);

			getSession().save(user);

			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws AdException {
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