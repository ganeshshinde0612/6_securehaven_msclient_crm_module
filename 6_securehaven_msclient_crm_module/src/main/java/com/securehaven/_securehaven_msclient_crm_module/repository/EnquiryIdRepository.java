package com.securehaven._securehaven_msclient_crm_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securehaven._securehaven_msclient_crm_module.model.Inquiry_Id;

@Repository
public interface EnquiryIdRepository extends JpaRepository<Inquiry_Id, Integer>{

}
