package com.mta_dev.access_control_api.use_cases;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mta_dev.access_control_api.dao.ProfileRepository;
import com.mta_dev.access_control_api.entities.Privilege;
import com.mta_dev.access_control_api.entities.Profile;
import com.mta_dev.access_control_api.entities.User;

@Service
public class ProfileUseCasesImpl implements ProfileUseCases {

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile saveProfile(Profile profile) {
		return profileRepository.save(profile);
	}

	@Override
	public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}
	
	@Override
	public Optional<Profile> getProfile(Long id) {		
		return  profileRepository.findById(id);		
	}

	@Override
	public void deleteProfile(Long id) {
		profileRepository.deleteById(id);		
	}

	@Override
	public Collection<User> getUsersOfProfile(Long id) {
		return profileRepository.findById(id).get().getUsers();
	}

	@Override
	public Collection<Privilege> getPrivilegesOfProfile(Long id) {
		return profileRepository.getOne(id).getPrivileges();
	}

}
