package com.mta_dev.access_control_api.rest_services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mta_dev.access_control_api.entities.Profile;
import com.mta_dev.access_control_api.entities.User;
import com.mta_dev.access_control_api.use_cases.UserUseCases;

@Secured(value={ "ROLE_Read/Write" })
@RestController
public class UserRestServices {

	@Autowired
	private UserUseCases userUseCases;
    
	@RequestMapping (value="/users", method=RequestMethod.POST)
	@ResponseBody
	public User saveUser(@RequestBody User user) {	
		//		TODO see if we need to crypt the password before saving it
		return userUseCases.saveUser(user);
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() {
	//		TODO not send the password by defining a function in the repository
	//		that has a query that dont select the password 
		return userUseCases.getAllUsers();
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Optional<User> getUser(@PathVariable Long id) {
		return userUseCases.getUser(id);	
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		userUseCases.deleteUser(id);
	}
	
	@RequestMapping(value="/users/{id}/profiles",method=RequestMethod.GET)
	@ResponseBody
	public Collection<Profile> getProfilesOfUser(@PathVariable Long id) {
		return userUseCases.getProfilesOfUser(id);
	}
}
