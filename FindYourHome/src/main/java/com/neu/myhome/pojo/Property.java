package com.neu.myhome.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "home")

public class Property {

	public Property() {

	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "listing"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "homeId", unique = true, nullable = false)
	private long homeId;


	@Column(name = "noOfBaths")
	private int noOfBaths;

	@Column(name = "noOfBedrooms")
	private int noOfBedrooms;

	@Column(name = "yearBuilt")
	private int yearBuilt;

	@JoinColumn(name = "homeTypeId")
	private long propType;

	@Column(name = "imagePath")
	private String imagePath;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "home", cascade = CascadeType.ALL)
	private HomeAddress homeAddress;

	// @OneToOne(fetch=FetchType.LAZY, mappedBy="home", cascade=CascadeType.ALL)
	// private HomeExtraFeatures homeExtraFeatures;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "property_features", joinColumns = { @JoinColumn(name = "homeId") }, inverseJoinColumns = {
			@JoinColumn(name = "featureId") })
	private List<PropertyFeatures> propfeat = new ArrayList<PropertyFeatures>();

	public List<PropertyFeatures> getPropertyFeatures() {
		return propfeat;
	}

	public void setPropertyFeatures(List<PropertyFeatures> propfeat) {
		this.propfeat = propfeat;
	}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	// @Column(name="listingType")
	// private String listingType;

	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name="property_listing",
	 * joinColumns={@JoinColumn(name="homeId")},
	 * inverseJoinColumns={@JoinColumn(name="propListId")}) private
	 * Set<PropertyListing> propertyListing = new HashSet<PropertyListing>();
	 */

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name = "propListId")
	private Listing listing;

	@Column(name = "listedBy")
	private String listedBy;

	@Column(name = "price")
	private float price;

	public long getHomeId() {
		return homeId;
	}

	public void setHomeId(long homeId) {
		this.homeId = homeId;
	}

	public long getPropType() {
		return propType;
	}

	public void setPropType(long propType) {
		this.propType = propType;
	}

	public List<PropertyFeatures> getPropfeat() {
		return propfeat;
	}

	public void setPropfeat(List<PropertyFeatures> propfeat) {
		this.propfeat = propfeat;
	}

	public int getNoOfBaths() {
		return noOfBaths;
	}

	public void setNoOfBaths(int noOfBaths) {
		this.noOfBaths = noOfBaths;
	}

	public int getNoOfBedrooms() {
		return noOfBedrooms;
	}

	public void setNoOfBedrooms(int noOfBedrooms) {
		this.noOfBedrooms = noOfBedrooms;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public HomeAddress getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(HomeAddress homeAddress) {
		this.homeAddress = homeAddress;
	}

	/*
	 * public HomeExtraFeatures getHomeExtraFeatures() { return
	 * homeExtraFeatures; }
	 * 
	 * public void setHomeExtraFeatures(HomeExtraFeatures homeExtraFeatures) {
	 * this.homeExtraFeatures = homeExtraFeatures; }
	 */

	public String getListedBy() {
		return listedBy;
	}

	public void setListedBy(String listedBy) {
		this.listedBy = listedBy;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
