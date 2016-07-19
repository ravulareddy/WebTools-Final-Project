package com.neu.myhome.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.cache.annotation.Cacheable;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name = "agent")
@PrimaryKeyJoinColumn(name = "personId")
public class Agent extends Person {

	@NotBlank
	@Size(min = 1, max = 30, message = "Please Enter a valid agent name")
	@Column(name = "agencyName")
	private String agencyName;

	@NotBlank
	@Size(min = 1, max = 30, message = "Please Enter a valid agent Type")
	@Column(name = "agentType")
	private String agentType;

	public Agent() {

	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

}
