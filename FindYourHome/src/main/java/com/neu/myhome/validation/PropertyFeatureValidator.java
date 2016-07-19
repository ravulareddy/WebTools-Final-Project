package com.neu.myhome.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.myhome.pojo.PropertyFeatures;

public class PropertyFeatureValidator implements Validator {

	public PropertyFeatureValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(PropertyFeatures.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PropertyFeatures propertyFeatures = new PropertyFeatures();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "feature", "error.invalid.propertyFeatures",
				"Feature is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.propertyFeatures",
				"Feature Description is Required");

	}

}
