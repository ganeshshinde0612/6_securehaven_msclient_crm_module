package com.securehaven._securehaven_msclient_crm_module.servicei;

import java.util.List;

import com.securehaven._securehaven_msclient_crm_module.model.Application_No;
import com.securehaven._securehaven_msclient_crm_module.model.Inquiry_Id;

public interface EnquiryIdServiceI {

	public void saveInquiryId(List<Inquiry_Id> inquiry);

	public List<Inquiry_Id> getAllInquiries();


}
