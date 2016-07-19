package com.neu.myhome.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Listing;
import com.neu.myhome.pojo.Property;
import com.neu.myhome.pojo.PropertyListingCategory;

public class DisplayPropertyListingDAO extends DAO {

	public DisplayPropertyListingDAO() {

	}

	public long getCategoryId(String category) throws AdException {
		try {

			long categoryId = 0;

			Criteria listingCatCriteria = getSession().createCriteria(PropertyListingCategory.class);
			listingCatCriteria.add(Restrictions.like("title", category));
			PropertyListingCategory propListCategory = (PropertyListingCategory) listingCatCriteria.uniqueResult();

			if (propListCategory != null) {
				categoryId = propListCategory.getId();
			}

			return categoryId;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get ListingCategories ", e);
		}
	}

	public List<Property> getPropertyListingByAgentId(long agentId) throws AdException {
		try {
			System.out.println("getPropertyListingByAgentId agent ID " + agentId);
			List<Property> propertyListing = new ArrayList<Property>();
			String qs = "select ls.* from listing ls where ls.agent = :agentId";
			SQLQuery query = getSession().createSQLQuery(qs).addEntity(Listing.class);
			query.setLong("agentId", agentId);

			if (query != null) {
				System.out.println("listingCriteria>>>^^^^^^^^^^^>>>query>" + query.toString());
				List<Object[]> listre1 = query.list();
				System.out.println("rs.toString()>>>>>>>>>>>" + listre1.toString());
				for (Object obj : listre1) {
					Listing listing = (Listing) obj;
					System.out.println("listing>>>>>>>>>>" + listing.getProperty().toString());
					propertyListing.add(listing.getProperty());
				}
			}
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get getPropertyListingByAgentId ", e);
		}
	}

	public List<Listing> getApartmentsForRent(String category, String[] propertyType) throws AdException {
		try {
			List<Listing> propertyListing = null;
			begin();
			System.out.println("getApartmentsForRent>>>>>");
			long categoryId = getCategoryId(category);
			System.out.println("categoryId in getApartmentsForRent" + categoryId);
			if (categoryId != 0) {
				propertyListing = getPropListingwithPropType(categoryId, propertyType);
			}
			if (propertyListing != null && propertyListing.size() > 0) {
				System.out.println("propertyListing  >>>>" + propertyListing.size());
			}
			commit();
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get ListingCategories ", e);
		}
	}

	public List<Listing> getHomesForSaleByPrice(String category, float minPrice, float maxPrice) throws AdException {
		try {
			List<Listing> propertyListing = null;
			begin();
			System.out.println("v>>>>getHomesForSaleByPrice>");
			long categoryId = getCategoryId(category);
			System.out.println("categoryId in getHomesForSaleByPrice" + categoryId);
			if (categoryId != 0) {
				propertyListing = searchHomesForSaleByPrice(categoryId, minPrice, maxPrice);
			}
			if (propertyListing != null && propertyListing.size() > 0) {
				System.out.println("propertyListing getHomesForSaleByPrice >>>>" + propertyListing.size());
			}
			commit();
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get getHomesForSaleByPrice ", e);
		}
	}

	public List<Listing> searchHomesForSaleByAddress(String category, int zipcode, String city, String state)
			throws AdException {
		try {
			List<Listing> propertyListing = null;
			begin();
			System.out.println("v>>>>>");
			long categoryId = getCategoryId(category);
			System.out.println("categoryId in searchHomesForSaleByAddress" + categoryId);
			if (categoryId != 0) {
				propertyListing = getPropListingByAddress(categoryId, zipcode, city, state);
			}
			if (propertyListing != null && propertyListing.size() > 0) {
				System.out.println("propertyListing searchHomesForSaleByAddress >>>>" + propertyListing.size());
			}
			commit();
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get searchHomesForSaleByAddress ", e);
		}
	}

	public List<Listing> searchHomesForSaleByPrice(long categoryId, float minPrice, float maxPrice) throws AdException {
		try {
			List<Listing> propertyListing = null;
			System.out.println("minPrice>>>" + minPrice + " >>maxPrice>>" + maxPrice);
			System.out.println("categoryId>>>>>>>>>>" + categoryId);
			String qs = "select ls.* from listing as ls inner join home as hm on ls.homeId = hm.homeId where hm.price between :minPrice and :maxPrice and ls.category= :categorId";
			SQLQuery query = getSession().createSQLQuery(qs).addEntity(Listing.class);
			query.setParameter("categorId", categoryId);
			query.setParameter("minPrice", minPrice);
			query.setParameter("maxPrice", maxPrice);

			if (query != null) {
				System.out
						.println("listingCriteria>>>^^^^^^searchHomesForSaleByPrice^^^^^>>>query>" + query.toString());
				List<Object[]> listre1 = query.list();
				if (listre1 != null && listre1.size() > 0) {
					propertyListing = new ArrayList<Listing>();
					System.out.println("rs.toString()>>>>>searchHomesForSaleByPrice>>>>>>" + listre1.toString());
					for (Object obj : listre1) {
						propertyListing.add((Listing) obj);
					}
				}
			}
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get searchHomesForSaleByPrice ", e);
		}
	}

	public List<Listing> getPropListingByAddress(long categoryId, int zipcode, String city, String state)
			throws AdException {
		try {
			List<Listing> propertyListing = new ArrayList<Listing>();
			System.out.println("zipcode>>>" + zipcode + " >>city>>" + city + ">>state" + state);
			System.out.println("categoryId>>>>>>>>>>" + categoryId);
			String qs = "select ls.* from listing as ls inner join home as hm where hm.homeId IN (select homeId from homeAddress where zipcode= :zipcode and city like :city and state like :state) and ls.category= :categorId";
			SQLQuery query = getSession().createSQLQuery(qs).addEntity(Listing.class);
			query.setParameter("categorId", categoryId);
			query.setParameter("zipcode", zipcode);
			query.setParameter("city", city);
			query.setParameter("state", state);
			if (query != null) {
				System.out.println("listingCriteria>>>^^^^^^getPropListingByAddress^^^^^>>>query>" + query.toString());
				List<Object[]> listre1 = query.list();
				if (listre1 != null && listre1.size() > 0) {
					System.out.println("rs.toString()>>>>>getPropListingByAddress>>>>>>" + listre1.toString());
					for (Object obj : listre1) {
						propertyListing.add((Listing) obj);
					}
				}
			}
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get getPropListingByAddress ", e);
		}
	}

	public List<Listing> getPropListingwithPropType(long categoryId, String[] homeTypeName) throws AdException {
		try {
			List<Listing> propertyListing = new ArrayList<Listing>();
			System.out.println("propertyType>>>>>>>>>" + homeTypeName.toString());
			System.out.println("categoryId>>>>>>>>>>" + categoryId);
			String qs = "select ls.* from listing as ls inner join home as hm on ls.homeId=hm.homeId where hm.propType IN (select homeTypeId from propertyType where homeTypeName= :homeTypeName) and ls.category= :categorId";
			SQLQuery query = getSession().createSQLQuery(qs).addEntity(Listing.class);
			query.setParameter("categorId", categoryId);
			for (int i = 0; i < homeTypeName.length; i++) {
				query.setParameter("homeTypeName", homeTypeName[i]);
				List<Object[]> listre1 = query.list();
				if (listre1 != null && listre1.size() > 0) {
					for (Object obj : listre1) {
						propertyListing.add((Listing) obj);
					}
				}
			}
			if (propertyListing != null) {
				System.out.println("propertyListing>>>>>getPropListingwithPropType>>>>>" + propertyListing.toString());
			}
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get getPropListingwithPropType ", e);
		}
	}

	public List<Listing> getAssistedLivingHomeForSale(String category, String[] feature) throws AdException {
		try {
			List<Listing> propertyListing = null;
			begin();
			System.out.println("getAssistedLivingHomeForSale>>>>>");
			long categoryId = getCategoryId(category);
			System.out.println("categoryId in getAssistedLivingHomeForSale" + categoryId);
			if (categoryId != 0) {
				propertyListing = getPropListingwithFeature(categoryId, feature);
			}
			System.out.println("propertyListing  getAssistedLivingHomeForSale >>>>" + propertyListing.size());
			commit();
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get getAssistedLivingHomeForSale ", e);
		}
	}

	public List<Listing> getLuxuryHomeForSale(String category) throws AdException {
		try {
			List<Listing> propertyListing = null;
			begin();
			System.out.println("getLuxuryHomeForSale>>>>>");
			long categoryId = getCategoryId(category);
			System.out.println("categoryId in getLuxuryHomeForSale" + categoryId);
			if (categoryId != 0) {
				propertyListing = getPropListing(categoryId);
			}
			System.out.println("propertyListing  getLuxuryHomeForSale >>>>" + propertyListing.size());
			commit();
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get getLuxuryHomeForSale ", e);
		}
	}

	public List<Listing> getAllHomeForSale(String category) throws AdException {
		try {
			List<Listing> propertyListing = null;
			begin();
			System.out.println("getAllHomeForSale>>>category>>" + category);
			long categoryId = getCategoryId(category);
			System.out.println("categoryId in getAllHomeForSale" + categoryId);
			if (categoryId != 0) {
				propertyListing = getPropListing(categoryId);
			}
			System.out.println("propertyListing  getAllHomeForSale >>>>" + propertyListing.size());
			commit();
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get getAllHomeForSale ", e);
		}
	}

	public List<Listing> getPropListing(long categoryId) throws AdException {
		try {
			List<Listing> propertyListing = null;
			Query listingCriteria = getSession().createQuery("from Listing where category= :categorId");
			listingCriteria.setLong("categorId", categoryId);
			if (listingCriteria != null) {
				System.out.println("listingCriteria>>>>>>query>" + listingCriteria.toString());
				propertyListing = (List<Listing>) listingCriteria.list();
			}
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get ListingCategories ", e);
		}
	}

	public List<Listing> getPropListingBySearchText(long categoryId, String searchText) throws AdException {
		try {
			System.out.println("categoryId>>>>>>>>>>>>" + categoryId);
			List<Listing> propertyListing = new ArrayList<Listing>();
			List<String> listtext = new ArrayList<String>();
			StringTokenizer strToken = new StringTokenizer(searchText, ",");
			String[] values = new String[strToken.countTokens()];
			int i = 0;
			while (strToken.hasMoreElements()) {
				values[i++] = (String) strToken.nextElement();
			}
			System.out.println("values[0] **************" + values[0]);
			System.out.println("values.length>>>>>>>>>" + values.length);
			SQLQuery query;
			if (values.length > 2) {
				System.out.println("length>2  ");
				String qs1 = "select ls.* from listing ls where ls.homeId IN " + "(select hadrs.hid from "
						+ "(select ha.homeId as hid, concat_ws(' ', ha.city, ha.state , ha.zipcode) as addr"
						+ " from homeAddress ha ) as hadrs"
						+ " where LOCATE( :city,hadrs.addr)>0 and LOCATE( :state,hadrs.addr)>0 and"
						+ " LOCATE( :zipcode,hadrs.addr)>0) and ls.category= :categoryId";

				query = getSession().createSQLQuery(qs1).addEntity(Listing.class);

				query.setParameter("categoryId", categoryId);
				query.setParameter("city", values[0]);
				query.setParameter("state", values[1]);
				query.setParameter("zipcode", values[2]);

				System.out.println("qs1 %%%%%%%   " + qs1);
			} else if (values.length == 2) {
				System.out.println("length = 2  ");
				String qs2 = "select ls.* from listing ls where ls.homeId IN " + "(select hadrs.hid from "
						+ "(select ha.homeId as hid, concat_ws(' ', ha.city, ha.state , ha.zipcode) as addr"
						+ " from homeAddress ha ) as hadrs"
						+ " where LOCATE( :city,hadrs.addr)>0 and LOCATE( :state,hadrs.addr)>0) and ls.category= :categoryId";

				query = getSession().createSQLQuery(qs2).addEntity(Listing.class);
				query.setParameter("categoryId", categoryId);
				query.setParameter("city", values[0]);
				query.setParameter("state", values[1]);

				System.out.println("qs2 %%%%%%%   " + qs2);
			} else if (values.length == 1) {
				System.out.println("length = 1  ");
				String qs3 = "select ls.* from listing ls where ls.homeId IN " + "(select hadrs.hid from "
						+ "(select ha.homeId as hid, concat_ws(' ', ha.city, ha.state , ha.zipcode) as addr"
						+ " from homeAddress ha ) as hadrs"
						+ " where LOCATE( :city,hadrs.addr)>0) and ls.category= :categoryId";

				query = getSession().createSQLQuery(qs3).addEntity(Listing.class);
				query.setParameter("categoryId", categoryId);
				query.setParameter("city", values[0]);

				System.out.println("qs3 %%%%%%%   " + qs3);
			} else {
				String qs = "select ls.* from listing ls where ls.homeId IN " + "(select hadrs.hid from "
						+ "(select ha.homeId as hid, concat_ws(' ', ha.city, ha.state , ha.zipcode) as addr"
						+ " from homeAddress ha ) as hadrs"
						+ " where LOCATE( :city,hadrs.addr)>0 and LOCATE( :state,hadrs.addr)>0 and"
						+ " LOCATE( :searchText,hadrs.addr)>0) and ls.category= :categoryId";

				query = getSession().createSQLQuery(qs).addEntity(Listing.class);
				query.setParameter("categoryId", categoryId);
				query.setParameter("searchText", searchText);

				System.out.println("qs1 else %%%%%%%   " + qs);
			}

			if (query != null) {
				System.out.println("listingCriteria>>>^^^^^^^^^^^>>>query>" + query.toString());
				List<Object[]> listre1 = query.list();
				System.out.println("rs.toString()>>>>>>>>>>>" + listre1.toString());
				for (Object obj : listre1) {
					propertyListing.add((Listing) obj);
				}
			}
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get getPropListingBySearchText ", e);
		}
	}

	public List<Listing> getPropListingwithFeature(long categoryId, String[] features) throws AdException {
		try {
			List<Listing> propertyListing = new ArrayList<Listing>();

			String qs = "select ls.* from listing as ls inner join (select ps.homeId from home as ps inner join property_features as pfs on ps.homeId=pfs.homeId inner join Features as fs on pfs.featureId=fs.featureId where fs.feature= :feature) as hs on ls.homeId=hs.homeId where ls.category = :categorId";

			SQLQuery query = getSession().createSQLQuery(qs).addEntity(Listing.class);

			query.setParameter("categorId", categoryId);
			for (int i = 0; i < features.length; i++) {
				query.setParameter("feature", features[i]);
				List<Object[]> listre1 = query.list();
				if (listre1 != null && listre1.size() > 0) {
					for (Object obj : listre1) {
						propertyListing.add((Listing) obj);
					}
				}
			}
			if (propertyListing != null) {
				System.out.println("propertyListing>>>>>getPropListingwithFeature>>>>>" + propertyListing.toString());
			}

			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get getPropListingwithFeature ", e);
		}
	}

	// need to work on this
	public List<Listing> getAllHomesBySearchText(String searchText, String category) throws AdException {
		try {
			List<Listing> propertyListing = null;
			begin();
			System.out.println("getAllHomesBySearchText>>>>>");
			long categoryId = getCategoryId(category);
			System.out.println("categoryId in getAllHomesBySearchText" + categoryId);
			if (categoryId != 0) {
				propertyListing = getPropListingBySearchText(categoryId, searchText);
			}
			System.out.println("propertyListing  getAllHomesBySearchText >>>>" + propertyListing.size());
			commit();
			return propertyListing;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get getAllHomesBySearchText ", e);
		}
	}

}
