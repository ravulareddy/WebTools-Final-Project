package com.neu.myhome.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userTypes")
public class UserTypes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userTypeId", unique = true, nullable = false)
	private Integer id;

	@Column(name = "role")
	private String role;

	@Column(name = "description")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserTypes() {

	}

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<User> user = new HashSet<User>();

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
