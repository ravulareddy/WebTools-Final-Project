package com.neu.myhome;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myhome.dao.DisplayPropertyListingDAO;
import com.neu.myhome.dao.UserDAO;
import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Agent;
import com.neu.myhome.pojo.Person;
import com.neu.myhome.pojo.Property;

@Controller
@RequestMapping(value = "viewMyListing.htm")
public class ViewListingPostedByAgentController {

	HttpSession session;

	public ViewListingPostedByAgentController() {

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewListingOfAgentGet(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		UserDAO userDAO = new UserDAO();
		session = request.getSession();
		try {
			if (session.getAttribute("user") != null) {
				// System.out.println("session not null>>>>>");
				Person person = (Person) session.getAttribute("user");
				if (!person.getRole().equals("AGENT")) {
					String errMsg = "You are not authorized to view Listings";
					mav.addObject("errorMsg", errMsg);
					mav.setViewName("displayerror");
					return mav;
				} else {
					// System.out.println("person.getPersonId()
					// >>>>>>"+person.getPersonId());
					Agent agent = (Agent) userDAO.getAgentProfile(person.getPersonId());
					DisplayPropertyListingDAO displayProperListingDAO = new DisplayPropertyListingDAO();
					List<Property> agentPostListing = displayProperListingDAO
							.getPropertyListingByAgentId(agent.getPersonId());
					// System.out.println(">>>>>>>agentPostListing>>>>>>>>>"+agentPostListing.size());
					if (agentPostListing != null && agentPostListing.size() > 0) {
						mav.addObject("luxuryHomeListing", agentPostListing);
						mav.addObject("listTitle",
								"Listing Posted By Agent " + agent.getFirstName() + " " + agent.getLastName());
						mav.setViewName("buy_luxuryHome");
						return mav;
					} else {
						String errMsg = "Property Listings Not available as of now, Please post listing to view";
						mav.addObject("errorMsg", errMsg);
						mav.setViewName("displayerror");
						return mav;

					}
				}

			} else {
				String errMsg = "Please Login to view Property Listings";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");
				return mav;
			}

		} catch (AdException e) {
			String errMsg = "Unable To Fetch Property Listings";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}
	}

}
