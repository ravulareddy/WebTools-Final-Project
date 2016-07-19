package com.neu.myhome.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.myhome.pojo.Contact;

public class ContactFormValidator implements Validator {

	public ContactFormValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Contact.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Contact contact = new Contact();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.contact", "Title is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "question", "error.invalid.contact",
				"Question/Query is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "questionDetails", "error.invalid.contact",
				"Question Details is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.contact", "Email ID Required");

	}

}
