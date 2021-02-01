package com.mta_dev.access_control_api.use_cases;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.mta_dev.access_control_api.entities.Privilege;
import com.mta_dev.access_control_api.entities.Profile;

public interface ProfileUseCases {

	public Profile saveProfile(Profile profile);
	public List<Profile> getAllProfiles();
	public Optional<Profile> getProfile(Long id);
	public void deleteProfile(Long id);

	//	"We cant do that like that because Profile isnt the owner side in the many to many
	//	relationship with User"
	//	*****
	//	Gets all the users related with a profile
	//	public Collection<User> getUsersOfProfile(Long id);
	
	// Gets all the privileges related with a profile
	public Collection<Privilege> getPrivilegesOfProfile(Long id);
}
