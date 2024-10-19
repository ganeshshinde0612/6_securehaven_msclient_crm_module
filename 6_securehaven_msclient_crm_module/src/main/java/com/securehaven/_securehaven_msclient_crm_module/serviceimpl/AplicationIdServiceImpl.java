package com.securehaven._securehaven_msclient_crm_module.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securehaven._securehaven_msclient_crm_module.model.Application_No;
import com.securehaven._securehaven_msclient_crm_module.repository.ApplicationIdRepository;
import com.securehaven._securehaven_msclient_crm_module.servicei.ApplicationIdServiceI;
@Service
public class AplicationIdServiceImpl implements ApplicationIdServiceI{

	@Autowired
	ApplicationIdRepository ar;
	
	@Override
	public void saveApplicationId(List<Application_No> a) {
		ar.saveAll(a);
	}

	@Override
	public List<Application_No> getAllLoanApp() {
		
		return ar.findAll();
	}

}
