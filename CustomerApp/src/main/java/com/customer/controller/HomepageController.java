package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.entity.CustomerEntity;
import com.customer.service.HomePageService;

@Controller
public class HomepageController<HttpServletRequest, HttpSession> {
    
    // Autowired instances of services used in the controller
    private HomePageService addmemberservice;
    private LoginController logincontroller;
    public static String search;
    
    // Constructor to inject dependencies
    @Autowired
    public HomepageController(HomePageService addmemberservice, LoginController logincontroller) {
        this.addmemberservice = addmemberservice;
        this.logincontroller = logincontroller;
    }

    // Handles the request for adding a new customer
    @RequestMapping(value = "/addCustomer")
    public String acceptFirstRequest(@RequestParam String firstname,
            @RequestParam String lastname, @RequestParam String street, @RequestParam String address,
            @RequestParam String city, @RequestParam String state, @RequestParam String email,
            @RequestParam String phone, Model model) {
        // Print received parameters for debugging
        System.out.println("firstname :" + firstname);
        System.out.println("lastname : " + lastname);
        // ... (similar print statements for other parameters)

        // Validate and add member based on validation result
        boolean isvalid = addmemberservice.validateAddmember(firstname, lastname, street, address, city, state, email, phone);

        if (isvalid) {
            model.addAttribute("responseMessage", "Registration Successful!!.......");
        } else {
            model.addAttribute("responseMessage", "Something went wrong!! Please Try Again!!.......");
        }
        // Fetch and display all member details after the operation
        logincontroller.getallMemberDetails(model);
        return "/WEB-INF/homepage.jsp";
    }

    // Handles the request for deleting a customer by email
    @RequestMapping(value = "/deleteCustomer/{email}")
    public String deleteMemberDetails(@PathVariable String email, Model model) {
        System.out.println("invoked updateAirport()");
        // Delete customer entity and fetch all members for display
        boolean result = addmemberservice.deleteCustomerEntity(email);
        logincontroller.getallMemberDetails(model);
        return "redirect:/homepagee";
    }

    // Handles the request for displaying the homepage
    @RequestMapping(value = "/homepagee")
    public String gethome(Model model) {
        // Fetch and display all member details
        logincontroller.getallMemberDetails(model);
        return "/WEB-INF/homepage.jsp";
    }

    // Handles the request for displaying the registration page
    @RequestMapping(value = "/register")
    public String getRegisterPage() {
        return "/WEB-INF/addcustomer.jsp";
    }

    // Handles the request for editing a customer by email
    @RequestMapping(value = "/editCustomer/{email}")
    public String editMemberDetails(@PathVariable String email, Model model) {
        // Fetch customer details by email and set attributes for editing
    	CustomerEntity entity=addmemberservice.getMemberByEmail(email);
		model.addAttribute("firstname",entity.getFirstname());
		model.addAttribute("lastname",entity.getLastname());
		model.addAttribute("address",entity.getAddress());
		model.addAttribute("street",entity.getStreet());
		model.addAttribute("city",entity.getCity());
		model.addAttribute("state",entity.getState());
		model.addAttribute("email",entity.getEmail());
		model.addAttribute("phone",entity.getPhone());
        
        return "/WEB-INF/editcustomer.jsp";
    }

    // Handles the request for updating a customer's details
    @RequestMapping(value = "/updateMember")
    public String updateAirport(@RequestParam String firstname, @RequestParam String lastname,
            @RequestParam String street, @RequestParam String address, @RequestParam String city,
            @RequestParam String state, @RequestParam String email, @RequestParam String phone, Model model) {
        System.out.println("invoked updateCustomerEntity");
        try {
            // Update customer entity and display appropriate response message
            boolean result = addmemberservice.updateCustomerEntity(firstname, lastname, street, address, city, state, email, phone);
            if (result) {
                model.addAttribute("responseMessage1", "Customer entity has been updated!!!");
            } else {
                model.addAttribute("responseMessage", "Something went Wrong!!!");
            }
        } catch (Exception e) {
            model.addAttribute("responseMessage", "Something went Wrong!!!");
        }
        return "redirect:/homepagee";
    }

    // Handles the search request based on specified criteria
    @RequestMapping(value = "/searchBy")
    public String onSearch(@RequestParam String searchby, @RequestParam String search, Model model) {
        // Fetch and display all member details
        logincontroller.getallMemberDetails(model);

        // Validate search criteria and perform search operation
        boolean res = addmemberservice.validateCustomerName(searchby, search);
        if (res) {
            List<CustomerEntity> entity = addmemberservice.getSearchbyCustomerEntity(searchby, search);
            if (entity != null && entity.size()>0) {
                model.addAttribute("responseMessagee",
                        "Record with column " + searchby + " and with value " + search + " was Found");
                // ... (similar statements for other attributes and display)
                model.addAttribute("M1","Firstname");
				model.addAttribute("M2","LastName");
				model.addAttribute("M3","Address");
				model.addAttribute("M4","Street");
				model.addAttribute("M5","City");
				model.addAttribute("M6","State");
				model.addAttribute("M7","Email");
				model.addAttribute("M8","Phone");
				model.addAttribute("getCustomerr",entity);
            } else {
                model.addAttribute("responseMessag", "Record with Name: " + search
                        + " not Found please enter valid Column Name and Valid Field");
            }
        } else {
            model.addAttribute("responseMessag", "Invalid.....Enter Valid Field Values.");
        }
        return "/WEB-INF/homepage.jsp";
    }
}
