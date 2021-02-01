package com.mta_dev.access_control_api.use_cases;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mta_dev.access_control_api.dao.PrivilegeRepository;
import com.mta_dev.access_control_api.entities.Privilege;

@Service
public class PrivilegeUseCasesImpl implements PrivilegeUseCases {

	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	@Override
	public Privilege savePrivilege(Privilege Privilege) {
		return privilegeRepository.save(Privilege);
	}

	@Override
	public List<Privilege> getAllPrivileges() {
		return privilegeRepository.findAll();
	}

	@Override
	public Optional<Privilege> getPrivilege(Long id) {		
		return  privilegeRepository.findById(id);		
	}

	@Override
	public void deletePrivilege(Long id) {
		privilegeRepository.deleteById(id);
		
	}

	//	"We cant do that like that because Privilege isnt the owner side in the many to many
	//	relationship with Profile"
	//  *****
	//	@Override
	//	public Collection<Profile> getProfilesOfPrivilege(Long id) {
	//		System.out.println("in PrivilegeMetier \n ");
	//		return privilegeRepository.getOne(id).getProfiles();
	//	}
}
