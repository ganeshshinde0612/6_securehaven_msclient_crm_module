package com.securehaven._securehaven_msclient_crm_module.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.securehaven._securehaven_msclient_crm_module.model.Application_No;
import com.securehaven._securehaven_msclient_crm_module.model.Customer_Enquiry;
import com.securehaven._securehaven_msclient_crm_module.model.Customer_Loan_Application;
import com.securehaven._securehaven_msclient_crm_module.model.Inquiry_Id;
import com.securehaven._securehaven_msclient_crm_module.servicei.ApplicationIdServiceI;
import com.securehaven._securehaven_msclient_crm_module.servicei.EnquiryIdServiceI;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController 
public class CRMController {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	EnquiryIdServiceI esi;
	
	@Autowired
	ApplicationIdServiceI asi;
	
	
	@GetMapping(value = "/get_enquiries")
	public ResponseEntity<List<Customer_Enquiry>> crm_get_enquiries()
	{
		String url="http://localhost:9090/customer/enquiry/get_enquiries";
		
		Customer_Enquiry[] ce=rt.getForObject(url, Customer_Enquiry[].class);
		
		List<Customer_Enquiry> list= new ArrayList<Customer_Enquiry>(Arrays.asList(ce));
		
		return new ResponseEntity<List<Customer_Enquiry>> (list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/get_loan_application")
	public ResponseEntity<List<Customer_Loan_Application>> getAllapplication()
	{
		String url="http://localhost:9092/get_all_loan_application";
		Customer_Loan_Application[] cla=rt.getForObject(url, Customer_Loan_Application[].class);
	
		List<Customer_Loan_Application> list=new ArrayList<Customer_Loan_Application>(Arrays.asList(cla));
		
		return new ResponseEntity<List<Customer_Loan_Application>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/save_applicationid")
	public ResponseEntity<Application_No> saveApplicationId(@RequestBody List<Application_No> a )
	{
		asi.saveApplicationId(a);
		return new ResponseEntity<Application_No>(HttpStatus.CREATED);
	}

	@PostMapping("/save_inquiryid")
	public ResponseEntity<Inquiry_Id> saveInquiryId(@RequestBody List<Inquiry_Id> inquiry)
	{
		esi.saveInquiryId(inquiry);
		return new ResponseEntity<Inquiry_Id>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/forward_inquiry")
	public ResponseEntity<List<Customer_Enquiry>> forwardInquiryId()
	{
		List<Inquiry_Id> list=esi.getAllInquiries();
		
//		List<String> id=new ArrayList<String>();
//		
//		for(Inquiry_Id a:list)
//		{
//			id.add(a.getId());
//		}
		 
		String url="http://localhost:9090/customer/enquiry/fetch_inquiry";
		
		Customer_Enquiry[] ce=rt.postForObject(url, list,Customer_Enquiry[].class);
		
		List<Customer_Enquiry> list2=new ArrayList<Customer_Enquiry>(Arrays.asList(ce));
		
		return new ResponseEntity<List<Customer_Enquiry>>(list2, HttpStatus.OK);
	}
	
	@GetMapping(value = "/forward_loan_application")
	public ResponseEntity<List<Customer_Loan_Application>> forawrdLoanApp()
	{
		List<Application_No> list=asi.getAllLoanApp();
		
//		List<String> id=new ArrayList<String>();
//		
//		for(Inquiry_Id a:list)
//		{
//			id.add(a.getId());
//		}
		 
		String url="http://localhost:9092/fetch_loan_app";
		
		Customer_Loan_Application[] ca=rt.postForObject(url, list,Customer_Loan_Application[].class);
		
		List<Customer_Loan_Application> list2=new ArrayList<Customer_Loan_Application>(Arrays.asList(ca));
		
		return new ResponseEntity<List<Customer_Loan_Application>>(list2, HttpStatus.OK);
	}
	
}
