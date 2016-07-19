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
import com.neu.myhome.pojo.PropertyType;
import com.neu.myhome.validation.PropertyTypeValidator;

@Controller
@RequestMapping(value = "/addListingpropType.htm")
public class AddPropertyTypeController {

	public AddPropertyTypeController() {
		// TODO Auto-generated constructor stub
	}

	AdminDAO adminDAO;
	HttpSession session;

	@RequestMapping(method = RequestMethod.GET)
	public String addPropListingTypeGet(@ModelAttribute("listingpropType") PropertyType listingpropType,
			HttpServletRequest request) throws NullPointerException {

		session = request.getSession();
		if (session.getAttribute("user") != null) {
			Admin admin = (Admin) session.getAttribute("user");
			if (!admin.getName().isEmpty() && admin.getRole().equals("ADMIN") && admin != null) {
				return "createPropType";
			}

		}

		return "error";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String addPropListingType(@ModelAttribute("listingpropType") @Valid PropertyType listingpropType,
			BindingResult result) {
		System.out.println("Entering addPropListingType post");
		new PropertyTypeValidator().validate(listingpropType, result);
		if (result.hasErrors()) {
			return "createPropType";
		}

		try {
			adminDAO = new AdminDAO();
			String res = adminDAO.createPropertyType(listingpropType.getHomeTypeName());
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
