package com.neu.myhome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myhome.business.ViewPropertyListingHelperService;
import com.neu.myhome.dao.DisplayPropertyListingDAO;
import com.neu.myhome.dao.ProperListingDAO;
import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Property;
import com.neu.myhome.pojo.PropertyFeatures;
import com.neu.myhome.pojo.PropertyType;

@Controller
public class ManageBuyerController {

	private DisplayPropertyListingDAO listingForBuyerDAO;
	private ProperListingDAO properListingDAO;

	public ManageBuyerController() {

	}

	@RequestMapping(value = "/buy_luxuryHome.htm", method = RequestMethod.GET)
	public ModelAndView buyLuxuryHome(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {

			listingForBuyerDAO = new DisplayPropertyListingDAO();
			List<Property> luxuryHomeListing = ViewPropertyListingHelperService
					.displayLuxuryHomesForSale(listingForBuyerDAO, "Sale");
			// System.out.println(">>>>>>>luxuryHomeListing>>>>>>>>>"+luxuryHomeListing.size());
			if (luxuryHomeListing != null && luxuryHomeListing.size() > 0) {
				mav.addObject("luxuryHomeListing", luxuryHomeListing);
				mav.addObject("listTitle", "Luxury");
				mav.setViewName("buy_luxuryHome");

			} else {
				String errMsg = "Luxury Homes Not available as of now, Please visit later";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");

			}
			return mav;
		} catch (NullPointerException npe) {
			String errMsg = "Luxury Homes Not available as of now, Please visit later";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}
	}

	@RequestMapping(value = "/buy_assistedLiving.htm", method = RequestMethod.GET)
	public ModelAndView buyHomeInAssistedCommunity(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {
			String[] features = new String[1];
			features[0] = "Assisted Community";
			listingForBuyerDAO = new DisplayPropertyListingDAO();
			List<Property> assitedLivingHomeListing = ViewPropertyListingHelperService
					.displayAssistedLivingHomesForSale(listingForBuyerDAO, "Sale", features);
			// System.out.println(">>>>>>>Assisted Living
			// Community>>>>>>>>>"+assitedLivingHomeListing.size());
			if (assitedLivingHomeListing != null && assitedLivingHomeListing.size() > 0) {
				mav.addObject("luxuryHomeListing", assitedLivingHomeListing);
				mav.addObject("listTitle", "Assisted Living Community");
				mav.setViewName("buy_luxuryHome");

			} else {
				String errMsg = "Assisted Living Community Homes Not available as of now, Please visit later";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");

			}
			return mav;
		} catch (NullPointerException npe) {
			String errMsg = "Assisted Living Community Homes Not available as of now, Please visit later";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}
	}

	@RequestMapping(value = { "/buy_searchAll.htm", "/buyhome.htm" }, method = RequestMethod.GET)
	public ModelAndView SearchAllPropertiesForSale(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {
			listingForBuyerDAO = new DisplayPropertyListingDAO();
			List<Property> searchAllHomeListing = ViewPropertyListingHelperService
					.searchAllHomesForSale(listingForBuyerDAO, "Sale");
			if (searchAllHomeListing != null && searchAllHomeListing.size() > 0) {
				// System.out.println(">>>>>>>searchAllHomesForSale>>>>>>>>>"+searchAllHomeListing.size());
				mav.addObject("luxuryHomeListing", searchAllHomeListing);
				mav.setViewName("buy_luxuryHome");
				mav.addObject("listTitle", "All");
			} else {
				String errMsg = "Homes Not available as of now, Please visit later";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");

			}
			return mav;
		} catch (NullPointerException npe) {
			String errMsg = "Homes Not available as of now, Please visit later";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}

	}

	@RequestMapping(value = "/buy_newHome.htm", method = RequestMethod.GET)
	public ModelAndView buyNewlyConstructedHome(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {
			String[] features = new String[1];
			features[0] = "New Construction";
			listingForBuyerDAO = new DisplayPropertyListingDAO();
			List<Property> newConstructionHomeForSale = ViewPropertyListingHelperService
					.displayAssistedLivingHomesForSale(listingForBuyerDAO, "Sale", features);
			// System.out.println(">>>>>>>New
			// Construction>>>>>>>>>"+newConstructionHomeForSale.size());
			if (newConstructionHomeForSale != null && newConstructionHomeForSale.size() > 0) {
				mav.addObject("luxuryHomeListing", newConstructionHomeForSale);
				mav.addObject("listTitle", "Newly Constructed");
				mav.setViewName("buy_luxuryHome");

			} else {
				String errMsg = "Newly Constructed Homes Not available as of now, Please visit later";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");

			}
			return mav;
		} catch (NullPointerException npe) {
			String errMsg = "Newly Constructed Homes Not available as of now, Please visit later";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}
	}

	@RequestMapping(value = "/buy_searchByCriteria.htm", method = RequestMethod.GET)
	public ModelAndView buySearchHomeByCriteriaGET(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {
			properListingDAO = new ProperListingDAO();
			List<PropertyFeatures> features = properListingDAO.getPropertyFeatures();
			List featuresList = new ArrayList<String>();
			Iterator featureIter = features.iterator();
			while (featureIter.hasNext()) {
				PropertyFeatures propertyFeatures = (PropertyFeatures) featureIter.next();
				featuresList.add(propertyFeatures.getFeature());

			}

			List<PropertyType> propertyTypes = properListingDAO.getPropertyTypeList();
			// System.out.println("propertyTypes$$$$$$$$$$"+propertyTypes);
			List propertyTypeList = new ArrayList<String>();
			Iterator propTypeIter = propertyTypes.iterator();
			while (propTypeIter.hasNext()) {
				PropertyType propertyType = (PropertyType) propTypeIter.next();
				propertyTypeList.add(propertyType.getHomeTypeName());
				System.out.println("propertyTypeList>>>>>>>>" + propertyTypeList.size());
			}
			mav.addObject("propertyTypeList", propertyTypeList);
			mav.addObject("featuresList", featuresList);
			mav.setViewName("buy_searchByCriteria");
			return mav;
		} catch (NullPointerException npe) {
			String errMsg = "Homes Not available for the search criteria, Please try with another criteria";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		} catch (AdException e) {
			String errMsg = "Homes Not available for the search criteria, Please try with another criteria";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}
	}

	@RequestMapping(value = { "/rent_all.htm", "/rentHome.htm" }, method = RequestMethod.GET)
	public ModelAndView SearchAllPropertiesForRent(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {
			listingForBuyerDAO = new DisplayPropertyListingDAO();
			List<Property> searchAllHomeListing = ViewPropertyListingHelperService
					.searchAllHomesForSale(listingForBuyerDAO, "Rent");
			if (searchAllHomeListing != null && searchAllHomeListing.size() > 0) {
				// System.out.println(">>>>>>>SearchAllPropertiesForRent>>>>>>>>>"+searchAllHomeListing.size());
				mav.addObject("luxuryHomeListing", searchAllHomeListing);
				mav.setViewName("buy_luxuryHome");
				mav.addObject("listTitle", "All");
			} else {
				String errMsg = "Homes Not available as of now, Please visit later";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");

			}
			return mav;
		} catch (NullPointerException npe) {
			String errMsg = "Homes Not available as of now, Please visit later";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}

	}

	@RequestMapping(value = "/buy_searchByCriteria.htm", method = RequestMethod.POST)
	public ModelAndView buySearchHomeByCriteriaPOST(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		listingForBuyerDAO = new DisplayPropertyListingDAO();
		try {
			String action = request.getParameter("action");
			// System.out.println("action :::::::::::::"+action);
			String category = request.getParameter("category");
			// System.out.println("category :::::::::::::"+category);
			List<Property> searhByCriteriaList = null;
			if (action.equals("searchByAddress")) {
				if (request.getParameter("zipcode") != null && request.getParameter("city") != null
						&& request.getParameter("state") != null) {
					int zipcode = Integer.parseInt(request.getParameter("zipcode"));
					String city = request.getParameter("city");
					String state = request.getParameter("state");
					searhByCriteriaList = ViewPropertyListingHelperService
							.displayHomesForSaleInTheArea(listingForBuyerDAO, category, zipcode, city, state);
					if (searhByCriteriaList != null && searhByCriteriaList.size() > 0) {
						mav.addObject("luxuryHomeListing", searhByCriteriaList);
						mav.addObject("listTitle", "Homes By Address");
						mav.setViewName("buy_luxuryHome");
					} else {
						String errMsg = "Homes Not available for the search criteria, Please search again!";
						mav.addObject("errorMsg", errMsg);
						mav.setViewName("displayerror");
					}
					return mav;
				}

				else {
					String errMsg = "Homes Not available for the search criteria, Please enter another price and search again!";
					mav.addObject("errorMsg", errMsg);
					mav.setViewName("displayerror");
				}
				return mav;
			} else if (action.equals("searchByPrice")) {
				if (request.getParameter("minPrice") != null && request.getParameter("maxPrice") != null) {
					float minPrice = Float.parseFloat(request.getParameter("minPrice"));
					float maxPrice = Float.parseFloat(request.getParameter("maxPrice"));
					searhByCriteriaList = ViewPropertyListingHelperService
							.displayHomesForSaleByPrice(listingForBuyerDAO, category, minPrice, maxPrice);
					if (searhByCriteriaList != null && searhByCriteriaList.size() > 0) {
						// System.out.println(">>>>>>>searhByCriteriaList>>>>searchByPrice>>>>>"+searhByCriteriaList.size());
						mav.addObject("luxuryHomeListing", searhByCriteriaList);
						mav.addObject("listTitle", "Homes By Price");
						mav.setViewName("buy_luxuryHome");
					} else {
						String errMsg = "Homes Not available for the search criteria, Please enter another price and search again!";
						mav.addObject("errorMsg", errMsg);
						mav.setViewName("displayerror");
					}
					return mav;
				} else {
					String errMsg = "Homes Not available for the search criteria, Please enter another price and search again!";
					mav.addObject("errorMsg", errMsg);
					mav.setViewName("displayerror");
				}
				return mav;
			}

			else if (action.equals("searchByFeatures")) {
				if (request.getParameterValues("features[]") != null) {
					String[] features = request.getParameterValues("features[]");

					searhByCriteriaList = ViewPropertyListingHelperService
							.displayHomesForSaleByFeatures(listingForBuyerDAO, category, features);

					if (searhByCriteriaList != null && searhByCriteriaList.size() > 0) {
						// System.out.println(">>>>>>>searhByCriteriaList>>>>>>>>>"+searhByCriteriaList.size());
						mav.addObject("luxuryHomeListing", searhByCriteriaList);
						mav.addObject("listTitle", "Homes By Price");
						mav.setViewName("buy_luxuryHome");
					} else {
						String errMsg = "Homes Not available for the search criteria, Please select other features and search again!";
						mav.addObject("errorMsg", errMsg);
						mav.setViewName("displayerror");
					}
					return mav;
				} else {
					String errMsg = "Homes Not available for the search criteria, Please select other features and search again!";
					mav.addObject("errorMsg", errMsg);
					mav.setViewName("displayerror");
				}
				return mav;
			} else if (action.equals("searchByPropType")) {
				if (request.getParameterValues("homeType[]") != null) {
					String[] homeType = request.getParameterValues("homeType[]");

					// System.out.println("homeType>>>>>>>>>"+homeType.toString());
					searhByCriteriaList = ViewPropertyListingHelperService
							.displayHomesForSaleByPropType(listingForBuyerDAO, category, homeType);

					if (searhByCriteriaList != null && searhByCriteriaList.size() > 0) {
						// System.out.println(">>>>>>>searhByCriteriaList>>>>>>>>>"+searhByCriteriaList.size());
						mav.addObject("luxuryHomeListing", searhByCriteriaList);
						mav.addObject("listTitle", "Homes By Property Type");
						mav.setViewName("buy_luxuryHome");
					} else {
						String errMsg = "Homes Not available for the search criteria, Please enter another price and search again!";
						mav.addObject("errorMsg", errMsg);
						mav.setViewName("displayerror");
					}
					return mav;
				} else {
					String errMsg = "Homes Not available for the search criteria, Please select other property types and search again!";
					mav.addObject("errorMsg", errMsg);
					mav.setViewName("displayerror");

				}
				return mav;
			} else {
				String errMsg = "Homes Not available for the search criteria, Not a Valid search, Please search again!";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");
				return mav;
			}

		} catch (NumberFormatException nfe) {
			String errMsg = "Homes Not available for the search criteria, Please search again!";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		} catch (NullPointerException npe) {
			String errMsg = "Homes Not available for the search criteria, Please search again!";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		} catch (Exception e) {
			String errMsg = "Homes Not available for the search criteria, Please search again!";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}
	}

	@RequestMapping(value = "/sellhome.htm", method = RequestMethod.GET)
	public ModelAndView displayPropertiesForSale(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {
			listingForBuyerDAO = new DisplayPropertyListingDAO();
			List<Property> searchAllHomeListing = ViewPropertyListingHelperService
					.searchAllHomesForSale(listingForBuyerDAO, "Sale");
			if (searchAllHomeListing != null && searchAllHomeListing.size() > 0) {
				// System.out.println(">>>>>>>searchAllHomesForSale>>>>>>>>>"+searchAllHomeListing.size());
				mav.addObject("luxuryHomeListing", searchAllHomeListing);
				mav.setViewName("buy_luxuryHome");
				mav.addObject("listTitle", "All");
			} else {
				String errMsg = "Homes Not available as of now, Please visit later";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");

			}
			return mav;
		} catch (NullPointerException npe) {
			String errMsg = "Homes Not available as of now, Please visit later";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}

	}
}
