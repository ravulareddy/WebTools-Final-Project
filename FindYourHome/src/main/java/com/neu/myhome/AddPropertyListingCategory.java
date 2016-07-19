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
import com.neu.myhome.pojo.PropertyListingCategory;
import com.neu.myhome.validation.PropertyListingCategoryValidator;

@Controller
@RequestMapping(value = "/addListCategory.htm")
public class AddPropertyListingCategory {

	AdminDAO adminDAO;
	HttpSession session;

	public AddPropertyListingCategory() {

	}

	@RequestMapping(method = RequestMethod.GET)
	public String addListingCategory(@ModelAttribute("listingCategories") PropertyListingCategory listingCategories,
			HttpServletRequest request) throws NullPointerException {

		session = request.getSession();
		if (session.getAttribute("user") != null) {
			System.out.println("session.getAttribute admin is not null ");
			Admin admin = (Admin) session.getAttribute("user");
			if (!admin.getName().isEmpty() && admin.getRole().equals("ADMIN") && admin != null) {
				System.out.println("session.getAttribute admin success ");

				return "createlistingCategories";
			}

		}

		return "error";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String addPropListingCategory(
			@ModelAttribute("listingCategories") @Valid PropertyListingCategory listingCategories,
			BindingResult result) {
		System.out.println("Entering addPropListingCategory post");
		new PropertyListingCategoryValidator().validate(listingCategories, result);

		if (result.hasErrors()) {
			return "createlistingCategories";
		}

		try {
			adminDAO = new AdminDAO();
			String res = adminDAO.createlistingCategories(listingCategories.getTitle());
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
