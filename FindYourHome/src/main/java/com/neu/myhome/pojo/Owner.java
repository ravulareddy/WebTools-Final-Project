package com.neu.myhome.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
@PrimaryKeyJoinColumn(name = "personId")
public class Owner extends Person {

	public Owner() {

	}
	
}
