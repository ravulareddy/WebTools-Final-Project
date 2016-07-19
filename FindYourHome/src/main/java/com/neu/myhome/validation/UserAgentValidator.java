package com.neu.myhome.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.myhome.pojo.Agent;

public class UserAgentValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Agent.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Agent agent = new Agent();

		ValidationUtils.rejectIfEmpty(errors, "agencyName", "error.invalid.agent", "Agency Name Required");
		ValidationUtils.rejectIfEmpty(errors, "agentType", "error.invalid.agent",
				"Agency Type is Required (Individual/Firm Name)");
	}

}
