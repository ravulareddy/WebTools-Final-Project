package com.neu.myhome;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myhome.business.ViewPropertyListingHelperService;
import com.neu.myhome.dao.DisplayPropertyListingDAO;
import com.neu.myhome.pojo.Property;

@Controller
// @SessionAttributes("user")
public class ShowPropertyListingController {

	DisplayPropertyListingDAO displayProperListingDAO;

	public ShowPropertyListingController() {

	}

	@RequestMapping(value = "/rent_apartment.htm", method = RequestMethod.GET)
	public ModelAndView displayApartmentsForRent(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		try {
			displayProperListingDAO = new DisplayPropertyListingDAO();
			// System.out.println("category>>>>>>>>"+category);
			// System.out.println("catName$$$$$$$$$$$$$$"+catName);
			String[] propType = new String[1];
			propType[0] = "Apartment";
			List<Property> rentAptListing = ViewPropertyListingHelperService
					.displayApartmentsForRent(displayProperListingDAO, "Rent", propType);
			if (rentAptListing != null && rentAptListing.size() > 0) {
				// System.out.println(">>>>>>>rentAptListing>>>>>>>>>"+rentAptListing.size());

				mav.addObject("rentAptListing", rentAptListing);
				mav.setViewName("rent_apartment");
			} else {
				String errMsg = "Apartment Homes Not available as of now, Please visit later";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");

			}
			return mav;

		} catch (NullPointerException npe) {
			String errMsg = "Apartment Homes Not available as of now, Please visit later";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}

	}

}
