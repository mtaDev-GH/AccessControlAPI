package com.mta_dev.access_control_api;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mta_dev.access_control_api.entities.Privilege;
import com.mta_dev.access_control_api.entities.Profile;
import com.mta_dev.access_control_api.entities.User;
import com.mta_dev.access_control_api.use_cases.PrivilegeUseCases;
import com.mta_dev.access_control_api.use_cases.ProfileUseCases;
import com.mta_dev.access_control_api.use_cases.UserUseCases;


@SpringBootApplication
public class AccessControlApiApplication {

	public static void main(String[] args) {		
		//		SpringApplication.run(AccessControlApiApplication.class, args);
		
		//------this is an initialization for tests only
		//------BEGIN 
		//		Dont forget to check if you need to comment or uncomment the first line of this main
		ApplicationContext ctx = SpringApplication.run(AccessControlApiApplication.class, args);
		
		//		creating privileges			
		Privilege privilege01 = new Privilege("Read/Write", null);
		Privilege privilege02 = new Privilege("Read", null);
		
		PrivilegeUseCases privilegeUseCases = ctx.getBean(PrivilegeUseCases.class);
		privilegeUseCases.savePrivilege(privilege01);		
		privilegeUseCases.savePrivilege(privilege02);
		
		//		creating profiles
		
		ProfileUseCases profileUseCases = ctx.getBean(ProfileUseCases.class);
		
		Collection<Privilege> privileges = new ArrayList<Privilege>();

		privileges.add(privilege02);				
		Profile profile02 = new Profile("USER", null, privileges);
		profileUseCases.saveProfile(profile02);
		
		privileges.add(privilege01);
		Profile profile01 = new Profile("ADMIN", null, privileges);
		profileUseCases.saveProfile(profile01);
		
		//		creating users
		
		UserUseCases userUseCases = ctx.getBean(UserUseCases.class);
		
		Collection<Profile> profiles = new ArrayList<Profile>();
		
		profiles.add(profile02);						
		User user02 = new User(null, null, null, null, "user", "123", null, profiles);
		userUseCases.saveUser(user02);
		
		profiles.add(profile01);
		User user01 = new User(null, null, null, null, "admin", "123", null, profiles);
					
		userUseCases.saveUser(user01);
		//------END		
	}
}
