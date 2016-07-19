package com.neu.myhome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.myhome.dao.AdminDAO;
import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Admin;
import com.neu.myhome.pojo.PropertyFeatures;
import com.neu.myhome.validation.PropertyFeatureValidator;

@Controller
@RequestMapping(value = "/addPropFeatures.htm")
public class AddPropertyFeaturesController {

	public AddPropertyFeaturesController() {
		// TODO Auto-generated constructor stub
	}

	AdminDAO adminDAO;
	HttpSession session;

	@RequestMapping(method = RequestMethod.GET)
	public String addPropFeatureGet(@ModelAttribute("listingFeatures") PropertyFeatures listingFeatures,
			HttpServletRequest request) throws NullPointerException {

		session = request.getSession();
		if (session.getAttribute("user") != null) {
			Admin admin = (Admin) session.getAttribute("user");
			if (!admin.getName().isEmpty() && admin.getRole().equals("ADMIN") && admin != null) {
				return "addPropertyFeatures";
			}

		} else {

		}

		return "error";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String addPropFeatures(@ModelAttribute("listingFeatures") @Valid PropertyFeatures listingFeatures,
			BindingResult result) {
		System.out.println("Entering addPropListingCategory post");
		new PropertyFeatureValidator().validate(listingFeatures, result);
		if (result.hasErrors()) {
			return "addPropertyFeatures";
		}

		try {
			adminDAO = new AdminDAO();
			String res = adminDAO.createPropertyFeatures(listingFeatures.getFeature(),
					listingFeatures.getDescription());
			if (res.equals("success")) {
				return "login_admin";
			}
		}

		catch (AdException e) {

			return "error";
		}
		return "error";
	}

}
