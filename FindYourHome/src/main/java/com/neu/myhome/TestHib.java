package com.neu.myhome;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.neu.myhome.pojo.Agent;
import com.neu.myhome.pojo.HomeAddress;
import com.neu.myhome.pojo.HomeExtraFeatures;
import com.neu.myhome.pojo.Person;
import com.neu.myhome.pojo.Property;
import com.neu.myhome.pojo.PropertyFeatures;
import com.neu.myhome.pojo.PropertyListing;
import com.neu.myhome.pojo.User;
import com.neu.myhome.pojo.UserTypes;

public class TestHib {

	public void createTables() {

		try {
			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			UserTypes userTypes = new UserTypes();
			userTypes.setRole("admin");
			userTypes.setRole("buyer");
			userTypes.setRole("seller");

			User user = new User();
			PropertyListing propertyListing = new PropertyListing();
			HomeAddress homeaddress = new HomeAddress();
			// HomeExtraFeatures homeExtraFeatures = new HomeExtraFeatures();
			PropertyFeatures propertyFeatures = new PropertyFeatures();
			Property home = new Property();

			session.save(user);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("*** EXCEPTION: " + e.getMessage());
		}
	}

	public void testnewuser() {
		Person user = new Person();
		user.setFirstName("test");
		user.setLastName("test");
		user.setEmailId("test");
		Agent u = new Agent();
		u.setPassword("test");
		u.setName("user");
		u.setRole("ADMIN");
		u.setAgencyName("agencynm");

		try {
			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			session.save(u);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("*** EXCEPTION: " + e.getMessage());
		}

	}

	public void testuser() {
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setEmailId("test");
		user.setPassword("test");
		user.setName("user");

		UserTypes userTypes = new UserTypes();
		userTypes.setRole("ADMIN");
		Set<UserTypes> ut = new HashSet<UserTypes>();
		ut.add(userTypes);
		user.setUserTypes(ut);

		try {
			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("*** EXCEPTION: " + e.getMessage());
		}

	}

	public void testHome() {

		Property home = new Property();
		HomeAddress homeaddress = new HomeAddress();
		homeaddress.setZipcode(02145);
		homeaddress.setCity("boston");
		homeaddress.setState("MA");
		HomeExtraFeatures homeExtraFeatures = new HomeExtraFeatures();
		homeExtraFeatures.setGarage(true);
		homeExtraFeatures.setGym(true);
		home.setHomeAddress(homeaddress);
		// home.setHomeExtraFeatures(homeExtraFeatures);
		// home.setHomeType("test");
		// home.setListingType("test");
		PropertyListing propertyListing = new PropertyListing();
		propertyListing.setCategory_name("Sell");
		propertyListing.setTitle("title");
		propertyListing.setMessage("msg");
		propertyListing.setPostedBy("postedby");

		try {
			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			session.save(home);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("*** EXCEPTION: " + e.getMessage());
		}

	}

	public void testPropList() {

		PropertyListing propertyListing = new PropertyListing();
		propertyListing.setTitle("title");
		propertyListing.setMessage("msg");
		propertyListing.setPostedBy("postedby");

		try {
			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			session.save(propertyListing);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("*** EXCEPTION: " + e.getMessage());
		}
	}

	public static void main(String args[]) {
		TestHib testHib = new TestHib();
		// testHib.testuser();
		// testHib.testHome();
		// testHib.testPropList();
		// testHib.createTables();

		testHib.testnewuser();

	}

}
