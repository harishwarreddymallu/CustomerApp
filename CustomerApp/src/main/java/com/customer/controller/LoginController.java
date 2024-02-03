package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.entity.CustomerEntity;
import com.customer.service.HomePageService;
import com.customer.service.LoginService;

@Controller
public class LoginController {
	
	private LoginService loginservice;
	private HomePageService addmemberservice;
	
	@Autowired // // Constructor to inject dependencies
	LoginController(LoginService loginservice,HomePageService addmemberservice){
		this.loginservice=loginservice;
		this.addmemberservice=addmemberservice;
	}
	
	// Handles the request to get the homepage after login.
	@RequestMapping(value="/getHomePage")
	public String getRegisterPage(@RequestParam String username,
			  @RequestParam String password,Model model) {
		// Validate user credentials
		boolean isvalid=loginservice.valid(username, password);
		getallMemberDetails(model);
		if(isvalid) {
			model.addAttribute("responseMessage","Login successfull!!.......");
			return "/WEB-INF/homepage.jsp";
		}else {
		model.addAttribute("responseMessage","Credentials doesn't Match!! Please Try Again!!.......");
		}
		return "index.jsp";
		
	}
	
	//Handles the request to get all customer details for display.
	@RequestMapping(value="/getallCustomerDetails")
	public String getallMemberDetails(Model model) {
		System.out.println("getallCustomerDetails........!");
		System.out.println("session object in getallCustomerEntity().........");
		// Fetch all customer entities.
		List<CustomerEntity> allCustomerEntity=addmemberservice.getallCustomerEntity();
		// Set attributes for displaying customer details in the view.
		model.addAttribute("firstName", "FirstName");
		model.addAttribute("lastName", "LastName");
		model.addAttribute("address", "Address");
		model.addAttribute("street", "Street");
		model.addAttribute("city", "City");
		model.addAttribute("state", "State");
		model.addAttribute("email", "Email");
		model.addAttribute("phone", "Phone");
		model.addAttribute("EDIT", "Action");
		model.addAttribute("getCustomer",allCustomerEntity);
		return "/WEB-INF/homepage.jsp";
	}
		
}

