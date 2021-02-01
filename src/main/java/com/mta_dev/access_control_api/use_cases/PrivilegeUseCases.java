package com.mta_dev.access_control_api.use_cases;

import java.util.List;
import java.util.Optional;

import com.mta_dev.access_control_api.entities.Privilege;

public interface PrivilegeUseCases {

	public Privilege savePrivilege(Privilege privilege);
	public List<Privilege> getAllPrivileges();
	public Optional<Privilege> getPrivilege(Long id);
	public void deletePrivilege(Long id);
	
	//	"We cant do that like that because Privilege isnt the owner side in the many to many
	//	relationship with Profile"
	//  *****
	//	 Gets all the profiles related to a privilege
	//	public Collection<Profile> getProfilesOfPrivilege(Long id);
}
