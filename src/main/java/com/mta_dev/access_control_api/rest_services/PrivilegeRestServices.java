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
import com.mta_dev.access_control_api.use_cases.PrivilegeUseCases;

@RestController
public class PrivilegeRestServices {

	@Autowired
	private PrivilegeUseCases privilegeUseCases;
	
	@RequestMapping (value="/privileges", method=RequestMethod.POST)
	@ResponseBody
	public Privilege savePrivilege(@RequestBody Privilege privilege) {
		return privilegeUseCases.savePrivilege(privilege);
	}
	
	@RequestMapping(value="/privileges",method=RequestMethod.GET)
	@ResponseBody
	public List<Privilege> getAllPrivileges() {
		return privilegeUseCases.getAllPrivileges();
	}
	
	@RequestMapping(value="/privileges/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Optional<Privilege> getPrivilege(@PathVariable Long id) {
		return privilegeUseCases.getPrivilege(id);
	}

	@RequestMapping(value="/privileges/{id}",method=RequestMethod.DELETE)
	public void deletePrivilege(@PathVariable Long id) {
		privilegeUseCases.deletePrivilege(id);
	}
		
		@RequestMapping(value="/privileges/{id}/profiles",method=RequestMethod.GET)
		@ResponseBody
		public Collection<Profile> getProfilesOfPrivilege(@PathVariable Long id) {
			return privilegeUseCases.getProfilesOfPrivilege(id);
		}

}
