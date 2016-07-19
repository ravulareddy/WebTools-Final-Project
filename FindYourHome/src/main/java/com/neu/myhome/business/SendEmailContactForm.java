package com.neu.myhome.business;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendEmailContactForm {

	public SendEmailContactForm() {
		// TODO Auto-generated constructor stub
	}

	private static String emailSubjectTxt = "Question from Find Your Dream Customers!!";
	private static String emailFromAddress = "hearthelpbyvolunteer@gmail.com";
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT_NUMBER = "587";
	private static StringBuilder emailMsgTxt;

	public static boolean sendEmail(String emailMessage, String emailId) {
		boolean isSent = true;

		try {
			Properties properties = new Properties();

			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", SMTP_HOST_NAME);
			properties.put("mail.smtp.port", SMTP_PORT_NUMBER);

			Authenticator mailAuthenticator = new EmailAuthenticator();

			Session mailSession = Session.getDefaultInstance(properties, mailAuthenticator);

			System.out.println("mailSession" + mailSession.toString());
			Message message = new MimeMessage(mailSession);
			InternetAddress fromAddress;
			InternetAddress toAddress;
			try {
				fromAddress = new InternetAddress(emailFromAddress);
				toAddress = new InternetAddress(emailId);
			}

			catch (AddressException ae) {
				ae.printStackTrace();
				isSent = false;
				return isSent;
			}
			System.out.println("fromAddress" + fromAddress.toString());
			System.out.println("toAddress" + toAddress);

			message.setFrom(fromAddress);
			message.setRecipient(RecipientType.TO, toAddress);
			message.setSubject(emailSubjectTxt);
			message.setText(emailMessage);

			Transport.send(message);
			System.out.println("Email Sent sucessfully!");
		} catch (MessagingException mex) {
			isSent = false;
			mex.printStackTrace();
			System.out.println("MessagingException >>>>>!" + mex.getMessage());
			return isSent;

		}

		catch (Exception e) {
			isSent = false;
			e.printStackTrace();
			System.out.println("MessagingException >>Exception>>>!" + e.getMessage());
		}

		return isSent;

	}

	public static String buildEmailTxtMessage(String title, String questions, String questiondetails, String emailId) {
		StringBuilder emailMsgTxt = new StringBuilder();
		emailMsgTxt.append("Please find the question and details below:");
		emailMsgTxt.append(System.lineSeparator());
		emailMsgTxt.append("Title : ".concat(title));
		emailMsgTxt.append(System.lineSeparator());
		emailMsgTxt.append("Question : ".concat(questions));
		emailMsgTxt.append(System.lineSeparator());
		emailMsgTxt.append("Details About the question : ".concat(questiondetails));
		emailMsgTxt.append(System.lineSeparator());
		emailMsgTxt.append("EmailId of the Sender : ".concat(emailId));
		emailMsgTxt.append(System.lineSeparator());
		emailMsgTxt.append("Thank You");
		emailMsgTxt.append("FindYourDreamHome");

		return emailMsgTxt.toString();
	}
}
