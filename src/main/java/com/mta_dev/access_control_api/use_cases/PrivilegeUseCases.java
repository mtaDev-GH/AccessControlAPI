package com.mta_dev.access_control_api.use_cases;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.mta_dev.access_control_api.entities.Privilege;
import com.mta_dev.access_control_api.entities.Profile;

public interface PrivilegeUseCases {

	public Privilege savePrivilege(Privilege privilege);
	public List<Privilege> getAllPrivileges();
	public Optional<Privilege> getPrivilege(Long id);
	public void deletePrivilege(Long id);
	
	//	 Gets all the profiles related to a privilege
	public Collection<Profile> getProfilesOfPrivilege(Long id);
}
