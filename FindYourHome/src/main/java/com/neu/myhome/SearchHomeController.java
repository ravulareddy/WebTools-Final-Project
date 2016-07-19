package com.neu.myhome;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myhome.business.ViewPropertyListingHelperService;
import com.neu.myhome.dao.DisplayPropertyListingDAO;
import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Property;

@Controller
public class SearchHomeController {

	private DisplayPropertyListingDAO listingForBuyerDAO;

	public SearchHomeController() {

	}

	@RequestMapping(value = "/searchButtonDisplay.htm", method = RequestMethod.GET)
	public ModelAndView searchForHome(@RequestParam("search_text") String search_text,
			@RequestParam("category") String category) throws AdException {

		ModelAndView mav = new ModelAndView();
		listingForBuyerDAO = new DisplayPropertyListingDAO();
		try {
			if (search_text != null && category != null) {
				List<Property> homeListing = ViewPropertyListingHelperService
						.searchAllHomesUsingButton(listingForBuyerDAO, search_text, category);
				// System.out.println(">>>>>>>homeListing>>>>>>>>>"+homeListing.size());
				if (homeListing != null && homeListing.size() > 0) {
					mav.addObject("homeListing", homeListing);
					mav.setViewName("searchHomeResult");
				} else {
					String errMsg = "Could not find any properties !!";
					mav.addObject("errorMsg", errMsg);
					mav.setViewName("displayerror");

				}
			} else {
				String errMsg = "Could not find any properties, Please search again";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");

			}
		} catch (Exception ex) {
			String errMsg = "Could not find any properties, Please search again";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");

		}
		return mav;

	}

}
