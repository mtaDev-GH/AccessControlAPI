package com.mta_dev.access_control_api.rest_services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mta_dev.access_control_api.entities.Privilege;
import com.mta_dev.access_control_api.entities.Profile;
import com.mta_dev.access_control_api.use_cases.ProfileUseCases;

@RestController
public class ProfileRestServices {

	@Autowired
	private ProfileUseCases profileUseCases;
	
	@RequestMapping (value="/profiles", method=RequestMethod.POST)
	@ResponseBody
	public Profile saveProfile(@RequestBody Profile profile) {
		return profileUseCases.saveProfile(profile);
	}
	
	@RequestMapping(value="/profiles",method=RequestMethod.GET)
	@ResponseBody
	public List<Profile> getAllProfiles() {
		return profileUseCases.getAllProfiles();
	}
	
	@RequestMapping(value="/profiles/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Optional<Profile> getProfile(@PathVariable Long id) {
		return profileUseCases.getProfile(id);
	}
	
	@RequestMapping(value="/profiles/{id}",method=RequestMethod.DELETE)
	public void deleteProfile(@PathVariable Long id) {
		profileUseCases.deleteProfile(id);
	}
	
	@RequestMapping(value="/profiles/{id}/privileges",method=RequestMethod.GET)
	@ResponseBody
	public Collection<Privilege> getPrivilegesOfProfile(@PathVariable Long id) {
		return profileUseCases.getPrivilegesOfProfile(id);
	}
	
	//	"We cant do that like that because Profile isnt the owner side in the many to many
	//	relationship with User"
	//	*****
	//	@RequestMapping(value="/profiles/{id}/users",method=RequestMethod.GET)
	//	@ResponseBody
	//	public Collection<User> getUsersOfProfile(@PathVariable Long id) {
	//		System.out.println("\n in the service \n");
	//		return profileUseCases.getUsersOfProfile(id);
	//	}

}
