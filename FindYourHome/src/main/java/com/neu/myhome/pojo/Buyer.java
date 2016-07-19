package com.neu.myhome.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
@PrimaryKeyJoinColumn(name = "personId")
public class Buyer extends Person {

	@Column(name = "maxPrice")
	private int maxPrice;

	@Column(name = "minPrice")
	private int minPrice;

	public Buyer() {
		// TODO Auto-generated constructor stub
	}

}
