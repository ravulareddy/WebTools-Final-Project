package com.neu.myhome.dao;

import org.hibernate.HibernateException;

import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.PropertyFeatures;
import com.neu.myhome.pojo.PropertyListingCategory;
import com.neu.myhome.pojo.PropertyType;

public class AdminDAO extends DAO {

	public AdminDAO() {
		// TODO Auto-generated constructor stub
	}

	public String createlistingCategories(String listingCategory) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			PropertyListingCategory propListingCategory = new PropertyListingCategory();
			propListingCategory.setTitle(listingCategory);

			getSession().save(propListingCategory);
			commit();

			return "success";
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating propListingCategory: " + e.getMessage());
		}

	}

	public String createPropertyType(String propType) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			PropertyType propertyType = new PropertyType();
			propertyType.setHomeTypeName(propType);

			getSession().save(propertyType);
			commit();

			return "success";
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating propertyType: " + e.getMessage());
		}

	}

	public String createPropertyFeatures(String feature, String description) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			PropertyFeatures propertyFeatures = new PropertyFeatures();
			propertyFeatures.setFeature(feature);
			propertyFeatures.setDescription(description);

			getSession().save(propertyFeatures);
			commit();

			return "success";
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating propertyFeatures: " + e.getMessage());
		}

	}

}
