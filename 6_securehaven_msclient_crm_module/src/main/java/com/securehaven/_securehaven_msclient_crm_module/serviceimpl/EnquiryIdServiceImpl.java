package com.securehaven._securehaven_msclient_crm_module.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securehaven._securehaven_msclient_crm_module.model.Inquiry_Id;
import com.securehaven._securehaven_msclient_crm_module.repository.EnquiryIdRepository;
import com.securehaven._securehaven_msclient_crm_module.servicei.EnquiryIdServiceI;
@Service
public class EnquiryIdServiceImpl implements EnquiryIdServiceI{

	@Autowired
	EnquiryIdRepository er;

	@Override
	public void saveInquiryId(List<Inquiry_Id> inquiry) {
		// TODO Auto-generated method stub
		er.saveAll(inquiry);
		
	}

	@Override
	public List<Inquiry_Id> getAllInquiries() {
		
		List<Inquiry_Id> list=er.findAll();
		
		return list;
	}

}
