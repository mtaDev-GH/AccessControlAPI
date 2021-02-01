package com.mta_dev.access_control_api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mta_dev.access_control_api.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	public List<Profile> findByName(String name); 

}
