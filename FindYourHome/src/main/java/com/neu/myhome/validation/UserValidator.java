package com.neu.myhome.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.myhome.pojo.Person;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Person.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Person user = new Person();

		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.invalid.user", "First Name is Required");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.invalid.user", "Last Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.user", "Email is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.user",
				"Contact Number is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.user", "User Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "Password is Required");
		ValidationUtils.rejectIfEmpty(errors, "role", "error.invalid.user", "Role is Required");
	}

}
