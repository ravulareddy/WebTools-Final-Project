package com.neu.myhome.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.myhome.pojo.PropertyListingCategory;

public class PropertyListingCategoryValidator implements Validator {

	public PropertyListingCategoryValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(PropertyListingCategory.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PropertyListingCategory listingCategory = new PropertyListingCategory();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.listingCategory",
				"Listing Category is Required");
	}

}
