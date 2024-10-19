package com.securehaven._securehaven_msclient_crm_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securehaven._securehaven_msclient_crm_module.model.Application_No;

@Repository
public interface ApplicationIdRepository extends JpaRepository<Application_No, Integer>{

}
