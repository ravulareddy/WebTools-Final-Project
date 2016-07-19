package com.neu.myhome.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "homeExtraFeatures")
public class HomeExtraFeatures {

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "home"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "homeId", unique = true, nullable = false)
	private long homeId;

	@Column(name = "laundryType")
	private String laundryType;

	@Column(name = "garage")
	private boolean garage;

	@Column(name = "pool")
	private boolean pool;

	@Column(name = "patio")
	private boolean patio;

	@Column(name = "gym")
	private boolean gym;

	@Column(name = "gatedCommunity")
	private boolean gatedCommunity;

	@Column(name = "commuteToTstation")
	private String commuteToTstation;

	@Column(name = "nearBySchool")
	private boolean nearBySchool;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn()
	private Property home;

	public HomeExtraFeatures() {

	}

	public HomeExtraFeatures(Property home, String laundryType, boolean garage, boolean pool, boolean patio,
			boolean gym, boolean gatedCommunity, String commuteToTstation, boolean nearBySchool) {
		this.home = home;
		this.laundryType = laundryType;
		this.garage = garage;
		this.pool = pool;
		this.patio = patio;
		this.gym = gym;
		this.gatedCommunity = gatedCommunity;
		this.commuteToTstation = commuteToTstation;
		this.nearBySchool = nearBySchool;
	}

	public long getHomeId() {
		return homeId;
	}

	public void setHomeId(long homeId) {
		this.homeId = homeId;
	}

	public String getLaundryType() {
		return laundryType;
	}

	public void setLaundryType(String laundryType) {
		this.laundryType = laundryType;
	}

	public boolean isGarage() {
		return garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	public boolean isPool() {
		return pool;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}

	public boolean isPatio() {
		return patio;
	}

	public void setPatio(boolean patio) {
		this.patio = patio;
	}

	public boolean isGym() {
		return gym;
	}

	public void setGym(boolean gym) {
		this.gym = gym;
	}

	public boolean isGatedCommunity() {
		return gatedCommunity;
	}

	public void setGatedCommunity(boolean gatedCommunity) {
		this.gatedCommunity = gatedCommunity;
	}

	public String getCommuteToTstation() {
		return commuteToTstation;
	}

	public void setCommuteToTstation(String commuteToTstation) {
		this.commuteToTstation = commuteToTstation;
	}

	public boolean isNearBySchool() {
		return nearBySchool;
	}

	public void setNearBySchool(boolean nearBySchool) {
		this.nearBySchool = nearBySchool;
	}

}
