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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({ @NamedQuery(name = "getListingCategories", query = "from PropertyListingCategory"),
		@NamedQuery(name = "getCategoryId", query = "from PropertyListingCategory where title= :category")

}

)

@Entity
@Table(name = "listingcategory")
public class PropertyListingCategory {

	public PropertyListingCategory() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryid", unique = true, nullable = false)
	private long id;

	@Column(name = "title")
	@NotBlank
	@Size(min = 1, max = 10, message = "Please Enter Valid Title For Listing Category")
	private String title;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private Set<Listing> propertyListings = new HashSet<Listing>();

	public PropertyListingCategory(String title) {
		this.title = title;
		this.propertyListings = new HashSet<Listing>();
	}

	public Set<Listing> getPropertyListings() {
		return propertyListings;
	}

	public void setPropertyListings(Set<Listing> propertyListings) {
		this.propertyListings = propertyListings;
	}

	public void addPropertyListings(Listing propertyListings) {
		getPropertyListings().add(propertyListings);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}