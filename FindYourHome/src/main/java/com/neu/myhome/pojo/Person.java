package com.neu.myhome.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED) // table per subclass
public class Person {

	public Person() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "personId", unique = true, nullable = false)
	private long personId;

	@Column(name = "firstName")
	@Size(min = 1, max = 30, message = "Your First Name should have min 1 characters and max of 30 characters.")
	@NotNull
	@NotBlank
	private String firstName;

	@Column(name = "lastName")
	@NotNull
	@NotBlank
	@Size(min = 1, max = 30, message = "Your Last Name should have min 1 characters and max of 30 characters.")
	private String lastName;

	@Column(name = "emailId")
	@NotNull
	@NotBlank
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Enter Valid email address")
	private String emailId;

	@Column(name = "phoneNumber")
	@NotNull
	@Pattern(regexp = "^[1-9]{1}+[0-9]{9}$", message = "Please Enter valid Phone Number")
	private String phoneNumber;

	@Column(name = "name")
	@NotBlank
	@Size(min = 1, max = 30, message = "Your user Name should have min 5 characters and max of 10 characters.")
	private String name;

	@Column(name = "password")
	@NotBlank
	@Pattern(regexp = "^([a-zA-Z+]+[0-9+]+[@#!%]+)$", message = "Please enter valid Password.Pattern should be Character followed by Number followed by ! or # or % or @")
	private String password;

	@Column(name = "role")
	@NotBlank
	private String role;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Person(String firstName, String lastName, String emailId, String name, String password, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
