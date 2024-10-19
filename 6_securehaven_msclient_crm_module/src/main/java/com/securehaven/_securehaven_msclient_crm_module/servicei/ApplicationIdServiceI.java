package com.securehaven._securehaven_msclient_crm_module.servicei;

import java.util.List;

import com.securehaven._securehaven_msclient_crm_module.model.Application_No;

public interface ApplicationIdServiceI {

	public void saveApplicationId(List<Application_No> a);

	public List<Application_No> getAllLoanApp();

}
