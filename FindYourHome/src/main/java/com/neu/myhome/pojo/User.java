package com.neu.myhome.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@PrimaryKeyJoinColumn(name = "personID")
public class User extends Personbkp {

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", inverseJoinColumns = @JoinColumn(name = "userTypeId"))
	private Set<UserTypes> userTypes = new HashSet<UserTypes>();

	public User(String name, String password, String emailId) {
		this.name = name;
		this.password = password;

	}

	public User() {
	}

	public Set<UserTypes> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(Set<UserTypes> userTypes) {
		this.userTypes = userTypes;
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

}