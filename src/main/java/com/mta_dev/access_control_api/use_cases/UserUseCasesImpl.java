package com.mta_dev.access_control_api.use_cases;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mta_dev.access_control_api.dao.UserRepository;
import com.mta_dev.access_control_api.entities.Profile;
import com.mta_dev.access_control_api.entities.User;

@Service
public class UserUseCasesImpl implements UserUseCases {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	//  private BCryptPasswordEncoder passwordEncoder;
	private PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
//		System.out.println("\n\n passwordBefore: "+user.getPassword()+"\n\n");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		System.out.println("\n\n passwordAfter: "+user.getPassword()+"\n\n");
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUser(Long id) {		
		return  userRepository.findById(id);		
	}
	
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public Collection<Profile> getProfilesOfUser(Long id){	
//		return userRepository.getOne(id).getProfiles();
		return userRepository.findById(id).get().getProfiles();
	}

}
