package com.neu.myhome.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.myhome.pojo.PropertyType;

public class PropertyTypeValidator implements Validator {

	public PropertyTypeValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(PropertyType.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PropertyType propertyType = new PropertyType();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homeTypeName", "error.invalid.propertyType",
				"Property Type is Required");
	}

}
