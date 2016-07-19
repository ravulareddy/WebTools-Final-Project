package com.neu.myhome.pojo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Contact {

	public Contact() {

	}

	@Size(min = 5, max = 30, message = "Your Title should have min 5 characters and max of 30 characters.")
	private String title;

	@Size(min = 10, max = 100, message = "Your Question must have min 10 characters and max of 100 characters.")
	private String question;

	@Size(min = 20, max = 150, message = "Your Question must have min 20 characters and max of 150 characters.")
	private String questionDetails;

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Enter Valid email address")
	private String emailId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionDetails() {
		return questionDetails;
	}

	public void setQuestionDetails(String questionDetails) {
		this.questionDetails = questionDetails;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
