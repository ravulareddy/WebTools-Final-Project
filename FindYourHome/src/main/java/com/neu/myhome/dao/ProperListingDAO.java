package com.neu.myhome.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Listing;
import com.neu.myhome.pojo.PropertyFeatures;
import com.neu.myhome.pojo.PropertyListingCategory;
import com.neu.myhome.pojo.PropertyType;

public class ProperListingDAO extends DAO {

	public ProperListingDAO() {

	}

	public List<PropertyListingCategory> getListingCategories() throws AdException {
		try {
			begin();
			List<PropertyListingCategory> propListCategory;
			Query query = getSession().getNamedQuery("getListingCategories");
			System.out.println("query>>>>" + query);
			propListCategory = (List<PropertyListingCategory>) query.list();
			System.out.println("propListCategory >>>>>>>" + propListCategory.size());

			commit();
			return propListCategory;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get ListingCategories ", e);
		}
	}

	public List<PropertyType> getPropertyTypeList() throws AdException {
		try {
			begin();
			List<PropertyType> propertyTypes;
			Query query = getSession().getNamedQuery("getPropertyTypeList");
			System.out.println("query>>>>" + query);
			propertyTypes = (List<PropertyType>) query.list();
			System.out.println("propertyTypes >>>>>>>" + propertyTypes.size());

			commit();
			return propertyTypes;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get ListingHomeTypes ", e);
		}
	}

	public List<PropertyFeatures> getPropertyFeatures() throws AdException {
		try {
			begin();
			Query namedQuery = getSession().getNamedQuery("getFeaturesList");
			System.out.println("query>>namedQuery>>" + namedQuery);
			List<PropertyFeatures> featuresList = (List<PropertyFeatures>) namedQuery.list();
			System.out.println("featuresList >>>>>>>" + featuresList.size());
			commit();
			return featuresList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get FeaturesList ", e);
		}
	}

	public PropertyFeatures getPropertyFeatures(String feature) throws AdException {
		try {
			begin();
			Query namedQuery = getSession().getNamedQuery("getPropertyFeature");
			namedQuery.setString("feature", feature);
			System.out.println("query>>namedQuery>>" + namedQuery);
			PropertyFeatures propFeature = (PropertyFeatures) namedQuery.uniqueResult();
			System.out.println("propFeature >>>>>>>" + propFeature);
			commit();
			return propFeature;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get FeaturesList ", e);
		}
	}

	public long getCategoryId(String category) throws AdException {
		try {
			begin();
			Query namedQuery = getSession().getNamedQuery("getCategoryId");
			namedQuery.setString("category", category);
			System.out.println("query>>namedQuery>>category>>>>>" + category);
			PropertyListingCategory propertyListingCategory = (PropertyListingCategory) namedQuery.uniqueResult();
			long categoryId = propertyListingCategory.getId();
			System.out.println("categoryId >>>>categoryId>>>" + categoryId);
			commit();
			return categoryId;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get FeaturesList ", e);
		}
	}

	public long getPropertyId(String propType) throws AdException {
		try {
			begin();
			Query namedQuery = getSession().getNamedQuery("getPropertyTypeId");
			namedQuery.setString("homeTypeName", propType);
			System.out.println("query>>namedQuery>>propertyType>>>>>" + propType);
			PropertyType propertyType = (PropertyType) namedQuery.uniqueResult();
			long propTypeId = propertyType.getHomeTypeId();
			System.out.println("propTypeId >>>>propTypeId>>>" + propTypeId);
			commit();
			return propTypeId;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get propTypeId ", e);
		}
	}

	public Listing savePropListing(Listing listing) throws AdException {
		try {
			begin();

			System.out.println("listing>>>>>>>" + listing.getTitle());
			System.out.println("listing>>getProperty>>>>>" + listing.getProperty().getHomeId());
			System.out.println("listing>>>getHomeAddress>>>>" + listing.getProperty().getHomeAddress().getHomeId());
			System.out.println("query>>namedQuery>>listing>>>>>" + listing);
			// HomeAddress homeAddress = listing.getProperty().getHomeAddress();
			// Property property = listing.getProperty();
			// getSession().save(homeAddress);
			// getSession().save(property);
			getSession().save(listing);
			// System.out.println("listing
			// >>>>listing....id>>>"+listing.getPropListId());
			System.out.println("listing >>>>listing....id>>>" + listing.getHomeId());
			commit();
			return listing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get FeaturesList ", e);
		}
	}

}
