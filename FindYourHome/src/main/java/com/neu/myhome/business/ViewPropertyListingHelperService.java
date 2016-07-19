package com.neu.myhome.business;

import java.util.ArrayList;
import java.util.List;

import com.neu.myhome.dao.DisplayPropertyListingDAO;
import com.neu.myhome.pojo.Listing;
import com.neu.myhome.pojo.Property;

public class ViewPropertyListingHelperService {

	public static List<Property> displayApartmentsForRent(DisplayPropertyListingDAO displayPropertyListingDAO,
			String category, String[] propertyType) {
		try {
			List<Property> propertiesList = null;
			List<Listing> propListRent = new ArrayList<Listing>();

			System.out.println("inside displayApartmentsForRent");
			propListRent = displayPropertyListingDAO.getApartmentsForRent(category, propertyType);
			if (propListRent != null && !propListRent.isEmpty() && propListRent.size() > 0) {
				propertiesList = new ArrayList<Property>();
				for (Listing listing : propListRent) {
					propertiesList.add(listing.getProperty());
				}
			}
			return propertiesList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Property> displayHomesForSaleByFeatures(DisplayPropertyListingDAO displayPropertyListingDAO,
			String category, String[] features) {
		try {
			List<Property> propertiesList = null;
			List<Listing> propListRent = new ArrayList<Listing>();

			System.out.println("inside displayHomesForSaleByFeatures >>>>>>>>>>");

			propListRent = displayPropertyListingDAO.getAssistedLivingHomeForSale(category, features);
			if (propListRent != null && !propListRent.isEmpty() && propListRent.size() > 0) {
				propertiesList = new ArrayList<Property>();
				for (Listing listing : propListRent) {
					propertiesList.add(listing.getProperty());
				}
			}

			return propertiesList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Property> displayHomesForSaleByPropType(DisplayPropertyListingDAO displayPropertyListingDAO,
			String category, String[] propType) {
		try {
			List<Property> propertiesList = null;
			List<Listing> propListRent = new ArrayList<Listing>();

			System.out.println("inside displayHomesForSaleByPropType >>>>>>>>>>");

	//		System.out.println("propType[i]<>>>>>>>>>>>>" + propType.toString());
			propListRent = displayPropertyListingDAO.getApartmentsForRent(category, propType);
			if (propListRent != null && !propListRent.isEmpty() && propListRent.size() > 0) {
				propertiesList = new ArrayList<Property>();
				for (Listing listing : propListRent) {
					propertiesList.add(listing.getProperty());
				}
		//		System.out.println("propertiesList $$$$$$$$$$$$$" + propertiesList.toString());
			}

			return propertiesList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Property> displayHomesForSaleByPrice(DisplayPropertyListingDAO displayPropertyListingDAO,
			String category, float minPrice, float maxPrice) {
		try {
			List<Property> propertiesList = null;
			List<Listing> propListRent = new ArrayList<Listing>();

			System.out.println("inside displayHomesForSaleByPrice >>>>>>>>>>");
			propListRent = displayPropertyListingDAO.getHomesForSaleByPrice(category, minPrice, maxPrice);
			if (propListRent != null && !propListRent.isEmpty() && propListRent.size() > 0) {
				propertiesList = new ArrayList<Property>();
				for (Listing listing : propListRent) {
					propertiesList.add(listing.getProperty());
				}
			}
			return propertiesList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Property> displayHomesForSaleInTheArea(DisplayPropertyListingDAO displayPropertyListingDAO,
			String category, int zipcode, String city, String state) {
		try {
			List<Property> propertiesList = null;
			List<Listing> propListRent = new ArrayList<Listing>();

			System.out.println("inside displayHomesForSaleInTheArea");
			propListRent = displayPropertyListingDAO.searchHomesForSaleByAddress(category, zipcode, city, state);
			if (propListRent != null && !propListRent.isEmpty() && propListRent.size() > 0) {
				propertiesList = new ArrayList<Property>();
				for (Listing listing : propListRent) {
					propertiesList.add(listing.getProperty());
				}
			}
	//		System.out.println("propertiesList>>>>>> size" + propertiesList.size());
	//		System.out.println("propListRent>>>>>> size" + propListRent.size());
			return propertiesList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Property> displayAssistedLivingHomesForSale(DisplayPropertyListingDAO listingForBuyerDAO,
			String category, String[] feature) {
		try {
			List<Property> propertiesList = new ArrayList<Property>();
			List<Listing> propListRent = new ArrayList<Listing>();

			System.out.println("inside displayAssistedLivingHomesForSale >>>>.");
			propListRent = listingForBuyerDAO.getAssistedLivingHomeForSale(category, feature);
			if (propListRent != null && !propListRent.isEmpty() && propListRent.size() > 0) {
				for (Listing l : propListRent) {
					propertiesList.add(l.getProperty());
				}
			}
			return propertiesList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Property> displayLuxuryHomesForSale(DisplayPropertyListingDAO listingForBuyerDAO,
			String category) {
		try {
			List<Property> propertiesList = new ArrayList<Property>();
			List<Listing> propListRent = new ArrayList<Listing>();

			System.out.println("inside displayLuxuryHomesForSale>>>>.");
			propListRent = listingForBuyerDAO.getLuxuryHomeForSale(category);
			for (Listing listing : propListRent) {
				propertiesList.add(listing.getProperty());
			}
			return propertiesList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Property> searchAllHomesForSale(DisplayPropertyListingDAO listingForBuyerDAO, String category) {
		try {
			List<Property> propertiesList = new ArrayList<Property>();
			List<Listing> propListSale = new ArrayList<Listing>();

			System.out.println("inside searchAllHomesForSale>>>>.");
			propListSale = listingForBuyerDAO.getAllHomeForSale(category);
			for (Listing listing : propListSale) {
				propertiesList.add(listing.getProperty());
			}
			return propertiesList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Property> searchAllHomesUsingButton(DisplayPropertyListingDAO listingForBuyerDAO,
			String searchText, String category) {
		try {
			List<Property> propertiesList = new ArrayList<Property>();
			List<Listing> propListSale = new ArrayList<Listing>();

			System.out.println("inside searchAllHomesForSale>>>>.");

			propListSale = listingForBuyerDAO.getAllHomesBySearchText(searchText, category);
			for (Listing listing : propListSale) {
				propertiesList.add(listing.getProperty());
			}
			return propertiesList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * public static List<Property>
	 * searchAllHomesByCriteria(DisplayPropertyListingDAO listingForBuyerDAO,
	 * String searchText) { try { List<Property> propertiesList = new
	 * ArrayList<Property>(); List<Listing> propListSale = new
	 * ArrayList<Listing>();
	 * 
	 * System.out.println("inside searchAllHomesForSale>>>>."); propListSale =
	 * listingForBuyerDAO.getAllHomesBySearchText(searchText, category);
	 * for(Listing listing : propListSale) {
	 * propertiesList.add(listing.getProperty()); } return propertiesList; }
	 * catch(Exception e) { e.printStackTrace(); }
	 * 
	 * return null; }
	 */

}
