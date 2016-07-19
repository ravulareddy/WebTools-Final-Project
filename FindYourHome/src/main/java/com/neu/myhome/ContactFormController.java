package com.neu.myhome;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myhome.business.SendEmailContactForm;
import com.neu.myhome.dao.UserDAO;
import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Contact;
import com.neu.myhome.pojo.Person;
import com.neu.myhome.validation.ContactFormValidator;

@Controller
public class ContactFormController {

	public ContactFormController() {

	}

	UserDAO userDAO;

	@RequestMapping(value = "/contact.htm", method = RequestMethod.GET)
	public String contactFormGet(@ModelAttribute("contact") Contact contact) {
		return "contact";

	}

	@RequestMapping(value = "/contact.htm", method = RequestMethod.POST)
	public ModelAndView contactFormPost(@ModelAttribute("contact") @Valid Contact contact, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		new ContactFormValidator().validate(contact, result);

		if (result.hasErrors()) {
			mav.setViewName("contact");
			return mav;
		} else {
			userDAO = new UserDAO();
			String emailMsg = SendEmailContactForm.buildEmailTxtMessage(contact.getTitle(), contact.getQuestion(),
					contact.getQuestionDetails(), contact.getEmailId());

			// System.out.println("emailMsg >>>>>>>>>>"+emailMsg);
			List<Person> personList;
			try {
				personList = userDAO.findUserByrole("ADMIN");

				List<String> emailId = new ArrayList<String>();
				StringBuilder adminEmailId = new StringBuilder();
				if (personList != null && personList.size() > 0) {
					for (Person admin : personList) {
						adminEmailId.append(admin.getEmailId());
						adminEmailId.append(',');
					}
					// System.out.println("adminEmailId before
					// deletion"+adminEmailId.toString());
					int length = adminEmailId.length() - 1;
					// System.out.println("length @@@@@@@@@@ "+length);
					adminEmailId.deleteCharAt(length);
					// System.out.println("adminEmailId after
					// deletion"+adminEmailId.toString());
				}

				// boolean sendEmail = SendEmailContactForm.sendEmail(emailMsg,
				// adminEmailId.toString());
				boolean sendEmail = SendEmailContactForm.sendEmail(emailMsg, "sruthi.ravula@gmail.com");

				if (sendEmail) {
					String successMsg = "Mail Sent Successfully, Click here to ask another question <a href='contact.htm' >Contact Form</a>";
					mav.addObject("successMsg", successMsg);
					mav.setViewName("displaysuccessMsg");
				} else {
					String errMsg = "Unable to send email, Please try later";
					mav.addObject("errorMsg", errMsg);
					mav.setViewName("displayerror");
				}
			} catch (AdException e) {
				String errMsg = "Unable to send email, Please try later";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");
			}
		}

		return mav;

	}

}
