package com.mta_dev.access_control_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mta_dev.access_control_api.entities.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long>  {

}
