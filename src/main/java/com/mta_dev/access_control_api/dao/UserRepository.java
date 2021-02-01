package com.mta_dev.access_control_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mta_dev.access_control_api.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {

	public User findByLogin(String login); 

}
