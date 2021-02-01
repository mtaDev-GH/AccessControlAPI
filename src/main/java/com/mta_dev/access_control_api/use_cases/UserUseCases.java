package com.mta_dev.access_control_api.use_cases;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.mta_dev.access_control_api.entities.Profile;
import com.mta_dev.access_control_api.entities.User;

public interface UserUseCases {

	public User saveUser(User user);
	public List<User> getAllUsers();
	public Optional<User> getUser(Long id);
	public void deleteUser(Long id);
	
	// Gets all the profiles related to a user
	public Collection<Profile> getProfilesOfUser(Long id);
}
