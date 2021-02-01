package com.mta_dev.access_control_api.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users") //We named it "users" because "User" is reserved in PostGres

public class User implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String lastName;
	private String firstName;
	private String tel;
	private String email;
	
	@NotEmpty(message="Veillez saisir un login")
	@Size(min=3,message="La taille du login doit être au min 3 caractères")
	@Column(unique=true)
//	@AlreadyExistes(message="existe déja",className="User")
	private String login;
	
	private String password;
	
//	TODO check if it should be named "enabled" instead of "activated"
	private Boolean activated;
	
//	TODO check if ill need that attribute
//	private boolean tokenExpired;

  @ManyToMany 
  @JoinTable(name="users_profiles", 
      joinColumns=@JoinColumn(name="user_id"),
      inverseJoinColumns=@JoinColumn(name="profile_id")) 
  private Collection<Profile> profiles;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String lastName, String firstName, String tel, String email,
			@NotEmpty(message = "Veillez saisir un login") @Size(min = 3, message = "La taille du login doit être au min 3 caractères") String login,
			String password, Boolean activated, Collection<Profile> profiles) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.tel = tel;
		this.email = email;
		this.login = login;
		this.password = password;
		this.activated = activated;
		this.profiles = profiles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public Collection<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Collection<Profile> profiles) {
		this.profiles = profiles;
	}

}
