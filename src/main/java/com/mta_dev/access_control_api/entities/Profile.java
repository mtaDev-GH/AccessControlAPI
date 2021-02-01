package com.mta_dev.access_control_api.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="profiles") //Because "Privilege" might be reserved in PostGres
public class Profile implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy="profiles")
	private Collection<User> users;
	
	@ManyToMany
	  @JoinTable(name="profiles_privileges", 
    joinColumns=@JoinColumn(name="profile_id"),
    inverseJoinColumns=@JoinColumn(name="privilege_id")) 
	private Collection<Privilege> privileges;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(String name, Collection<User> users, Collection<Privilege> privileges) {
		super();
		this.name = name;
		this.users = users;
		this.privileges = privileges;
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
	public Collection<User> getUsers() {
		return users;
	}

	@JsonSetter
	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}
}
