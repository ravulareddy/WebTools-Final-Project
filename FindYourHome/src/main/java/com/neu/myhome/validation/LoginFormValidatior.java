package com.neu.myhome.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.myhome.pojo.Person;

public class LoginFormValidatior implements Validator {

	public LoginFormValidatior() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Person.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person user = new Person();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.user", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "Password Required");
	}

}
