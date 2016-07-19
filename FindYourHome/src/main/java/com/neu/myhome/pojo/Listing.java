package com.neu.myhome.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Table(name = "listing")
public class Listing {

	public Listing() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "homeId", unique = true, nullable = false)
	private long homeId;

	@Column(name = "title")
	private String title;

	@Column(name = "message")
	private String message;

	@Column(name = "startDate")
	private String startDate;

	@Column(name = "endDate")
	private String endDate;

	@Transient
	private String postedBy;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "agent")
	private Agent agent;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "listing", cascade = CascadeType.ALL)
	private Property property;

	@Transient
	private String category_name;

	@JoinColumn(name = "categoryid")
	private long category;

	public Listing(String title, String message, long category_id, String categoryName, Agent agent) {
		this.title = title;
		this.message = message;
		this.category = category_id;
		this.category_name = categoryName;
		this.agent = agent;
	}

	/*
	 * public long getPropListId() { return homeId; }
	 * 
	 * public void setPropListId(long homeId) { this.homeId = homeId; }
	 */

	public String getTitle() {
		return title;
	}

	public long getHomeId() {
		return homeId;
	}

	public void setHomeId(long homeId) {
		this.homeId = homeId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

}
