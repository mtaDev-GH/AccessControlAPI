package com.mta_dev.access_control_api.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="privileges") //Because "Privilege" might be reserved in PostGres
public class Privilege implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy="privileges")	
	private Collection<Profile> profiles;

	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Privilege(String name, Collection<Profile> profiles) {
		super();
		this.name = name;
		this.profiles = profiles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Collection<Profile> getProfiles() {
		return profiles;
	}

	@JsonSetter
	public void setProfiles(Collection<Profile> profiles) {
		this.profiles = profiles;
	}
}
