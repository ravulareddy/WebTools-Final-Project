package com.neu.myhome.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "userNew")
@Inheritance(strategy = InheritanceType.JOINED) // table per subclass
public class UserNew {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Transient
	@Column(name = "role")
	private String role;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "userNew")
	@PrimaryKeyJoinColumn(name = "personId")
	private Person person;

	public UserNew() {
		// TODO Auto-generated constructor stub
	}

	public UserNew(String name, String password, String emailId) {
		this.name = name;
		this.password = password;

	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
