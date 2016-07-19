package com.neu.myhome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.myhome.dao.UserDAO;
import com.neu.myhome.pojo.Agent;
import com.neu.myhome.pojo.Person;
import com.neu.myhome.validation.UserAgentValidator;
import com.neu.myhome.validation.UserValidator;

@Controller
@RequestMapping(value = "/updateProfile.htm")
public class ManageAgentController {

	UserDAO userDAO;
	HttpSession session;

	public ManageAgentController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.GET)
	public String updateProfile(ModelMap model, HttpServletRequest request) {
		try {
			userDAO = new UserDAO();
			session = request.getSession();
			if (session.getAttribute("user") != null) {
				Person person = (Person) session.getAttribute("user");
				if (!person.getRole().equals("AGENT")) {
					request.setAttribute("errorMsg", "You are not authorized to update profile");
					return "displayerror";
				} else {
					// System.out.println("person.getPersonId()
					// >>>>>>"+person.getPersonId());
					Agent agent = (Agent) userDAO.getAgentProfile(person.getPersonId());
					// model.addAttribute("user", person);
					model.addAttribute("agent", agent);
					return "updateProfile";
				}
			} else {
				request.setAttribute("errorMsg", "Please Login to update profile");
				return "displayerror";
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", "You are not authorized to update profile");
			return "displayerror";
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String updateProfilePst(@ModelAttribute("agent") Agent agent, BindingResult result1,
			HttpServletRequest request) {
		try {
			new UserValidator().validate(agent, result1);
			if (result1.hasErrors()) {
				return "updateProfile";
			}

			new UserAgentValidator().validate(agent, result1);
			if (result1.hasErrors()) {
				return "updateProfile";
			}

			session = request.getSession();

			if (agent != null) {
				// System.out.println("person.getPersonId()
				// >>>>>>"+agent.getFirstName());
				// System.out.println("person.getPersonId()
				// >>>>>>"+agent.getAgentType());
			}
			if (session.getAttribute("user") != null) {
				// System.out.println("session not null"+session.getId());
				Person pers = (Person) session.getAttribute("user");

				userDAO = new UserDAO();
				boolean chk = userDAO.updateProfile(pers.getPersonId(), agent);
				if (chk) {
					request.setAttribute("successMsg", "Profile has been updated successfully");
					return "login_agent";
				} else {
					request.setAttribute("errorMsg", "Unable to update profile, Please try later !");
					return "displayerror";
				}
			} else {
				request.setAttribute("errorMsg", "Unable to update profile, Please try later !");
				return "displayerror";
			}

		}

		catch (Exception e) {

			request.setAttribute("errorMsg", "Unable to create user, Please Signup with new username");
			return "displayerror";
		}

	}

}
