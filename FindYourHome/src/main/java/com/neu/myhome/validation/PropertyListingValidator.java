package com.neu.myhome.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.neu.myhome.pojo.Listing;

public class PropertyListingValidator implements Validator {

	public PropertyListingValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Listing.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Listing listing = new Listing();
		ValidationUtils.rejectIfEmpty(errors, "title", "error.invalid.listing", "Listing title is Required");
		
	}


}
