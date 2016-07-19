package com.neu.myhome.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.myhome.pojo.Property;

public class HomeValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(Property.class);
	}

	public void validate(Object obj, Errors errors) {
		Property home = new Property();
		
		// ValidationUtils.rejectIfEmpty(errors, "gender", "error.invalid.user",
		// "Please select your gender");
		// ValidationUtils.rejectIfEmpty(errors, "phoneNumber",
		// "error.invalid.user", "Please enter your phoneNumber");
		// ValidationUtils.rejectIfEmpty(errors, "dateOfBirth",
		// "error.invalid.user", "Please Enter your date of birth");

	}

}
