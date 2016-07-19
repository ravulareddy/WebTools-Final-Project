
package com.neu.myhome.business;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author tejageetla
 */
public class EmailAuthenticator extends Authenticator {

	public static final String SMTP_AUTH_USER = "hearthelpbyvolunteer@gmail.com";
	public static final String SMTP_AUTH_PWD = "helpbyvolunteer";

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		String username = SMTP_AUTH_USER;
		String password = SMTP_AUTH_PWD;
		return new PasswordAuthentication(username, password);
	}

}
