package com.neu.myhome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myhome.pojo.Person;

@Controller
public class SaveSearchandHomeResultsController {

	HttpSession session;

	public SaveSearchandHomeResultsController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/savedHomes.htm", method = RequestMethod.GET)
	public ModelAndView savedHomes(HttpServletRequest request) {
		session = request.getSession();
		ModelAndView mav = new ModelAndView();

		if (session.getAttribute("user") != null) {
			Person person = (Person) session.getAttribute("user");

			if (person.getName().isEmpty() || person == null) {
				String errMsg = "Please Login view Saved Homes or to save homes";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");
			} else {
				if (session.getAttribute("savedHomes") != null) {

					mav.setViewName("savedHomes");
				}
				mav.setViewName("savedHomes");

			}
		} else {
			String errMsg = "Please Login to view Saved Homes or to save homes";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
		}

		return mav;
	}

}
