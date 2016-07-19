package com.neu.myhome;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.myhome.dao.UserDAO;
import com.neu.myhome.pojo.Person;
import com.neu.myhome.validation.UserValidator;

@Controller
public class SignInController {

	UserDAO userDAO;

	@RequestMapping(value = "/signIn.htm", method = RequestMethod.GET)
	public String signInFormView(@ModelAttribute("user") Person user) {

		return "signIn_Form";
	}

	@RequestMapping(value = "/signIn.htm", method = RequestMethod.POST)
	public String signInFormCreateUser(HttpServletRequest request, @ModelAttribute("user") @Valid Person user,
			BindingResult result) throws Exception {
		try {
			// System.out.println("user 1 >>>>>>>"+user.getName());
			// System.out.println("user 1 >>>>>>>"+user.getRole());

			new UserValidator().validate(user, result);
			if (result.hasErrors()) {
				return "signIn_Form";
			}
			userDAO = new UserDAO();

			if (userDAO.get(user.getName()) != null) {
				request.setAttribute("errorMsg", "Username already exist, Please Signup with new username");
				return "displayerror";
			} else {
				userDAO.create(user.getName(), user.getPassword(), user.getEmailId(), user.getFirstName(),
						user.getLastName(), user.getPhoneNumber(), user.getRole());
				return "signIn_success";
			}

		} catch (Exception e) {
			// System.out.println("Exception: " + e.getMessage());
			request.setAttribute("errorMsg", "Unable to create user, Please Signup with new username");
			return "displayerror";
		}

	}
}
