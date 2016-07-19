package com.neu.myhome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.myhome.dao.UserDAO;
import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Person;
import com.neu.myhome.validation.LoginFormValidatior;

@Controller
public class LoginHomeController {

	UserDAO userDAO;

	@Autowired
	@Qualifier("loginFormValidator")
	LoginFormValidatior loginValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(loginValidator);
	}

	HttpSession session;

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String signInFormView(@ModelAttribute("user") Person user, HttpServletRequest request) {
		if (request.getAttribute("action") != null) {
			System.out.println("action not null");
			session = request.getSession();
			if (session.getAttribute("user") != null) {
				System.out.println("session not null");
				Person person = (Person) session.getAttribute("user");
				if (person.getRole().equals("ADMIN")) {
					return "login_admin";
				}
			}
		} else {
			System.out.println("session not null");
			System.out.println("action not null");
			return "login_Form";
		}
		return "login_Form";
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String loginSuccessView(@ModelAttribute("user") Person user, BindingResult result,
			HttpServletRequest request) {
		System.out.println("Entering login success");
		loginValidator.validate(user, result);
		if (result.hasErrors()) {
			return "login_Form";
		}

		try {
			System.out.println("Entering try block");
			// System.out.println("user.getName()"+user.getName());
			// System.out.println("user.getPassword()"+user.getPassword());
			userDAO = new UserDAO();
			// User user1 = userDAO.findUser(user.getName(),
			// user.getPassword());
			Person user1 = null;
			if (userDAO.get(user.getName()) != null) {
				user1 = userDAO.findUser(user.getName(), user.getPassword());
			}

			if (user1 != null) {
				session = request.getSession();

				String userType = user1.getRole();
				// System.out.println("user1.getRole()>>>>>>>>"+user1.getRole());
				if (userType.equals("ADMIN")) {
					session.setAttribute("user", user1);
					request.setAttribute("userId", user1.getPersonId());
					return "login_admin";
				} else if (userType.equals("BUYER")) {
					session.setAttribute("user", user1);
					request.setAttribute("userId", user1.getPersonId());
					return "login_buyer";
				} else if (userType.equals("OWNER")) {
					session.setAttribute("user", user1);
					request.setAttribute("userId", user1.getPersonId());
					return "login_owner";
				} else if (userType.equals("AGENT")) {
					// Agent agent = (Agent)user1;
					session.setAttribute("user", user1);
					session.setAttribute("person", user1);
					request.setAttribute("userId", user1.getPersonId());
					System.out.println("agent >>> sucess");
					return "login_agent";
				} else {
					return "login_success";
				}
			} else {
				request.setAttribute("errorMsg", "User does not exist, Please Signup to login");
				return "displayerror";
			}

		} catch (NullPointerException npe) {

			request.setAttribute("errorMsg", "User does not exist, Please Signup to login");
			return "displayerror";
		} catch (AdException e) {

			return "error";
		}

	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String signInFormViewLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "logout";
	}

}
