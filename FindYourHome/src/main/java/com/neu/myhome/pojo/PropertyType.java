package com.neu.myhome.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({ @NamedQuery(name = "getPropertyTypeList", query = "from PropertyType"),
		@NamedQuery(name = "getPropertyTypeId", query = "from PropertyType where homeTypeName= :homeTypeName") }

)

@Entity
@Table(name = "propertyType")
public class PropertyType {

	public PropertyType() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "homeTypeId", unique = true, nullable = false)
	private long homeTypeId;

	@Column(name = "homeTypeName")
	@NotBlank
	@Size(min = 1, max = 30, message = "Please Enter Valid Home Type for the Properties to be Listed")
	private String homeTypeName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propType")
	private Set<Property> property = new HashSet<Property>();

	public long getHomeTypeId() {
		return homeTypeId;
	}

	public void setHomeTypeId(long homeTypeId) {
		this.homeTypeId = homeTypeId;
	}

	public String getHomeTypeName() {
		return homeTypeName;
	}

	public void setHomeTypeName(String homeTypeName) {
		this.homeTypeName = homeTypeName;
	}

	public Set<Property> getProperty() {
		return property;
	}

	public void setProperty(Set<Property> property) {
		this.property = property;
	}

}
