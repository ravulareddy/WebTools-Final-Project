package com.neu.myhome.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({ @NamedQuery(name = "getFeaturesList", query = "from PropertyFeatures"),
		@NamedQuery(name = "getPropertyFeature", query = "from PropertyFeatures where feature= :feature") })

@Entity
@Table(name = "Features")
public class PropertyFeatures {

	public PropertyFeatures() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "featureId", unique = true, nullable = false)
	private Integer featureId;

	@Column(name = "feature")
	@NotBlank
	@Size(min = 1, max = 30, message = "Please Enter Valid feature For Property ")
	private String feature;

	@Column(name = "featureDescription")
	@NotBlank
	@Size(min = 1, max = 100, message = "Please Enter Valid description for the feature")
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "propfeat")
	private List<Property> property = new ArrayList<Property>();

	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}

	public Integer getFeatureId() {
		return featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
