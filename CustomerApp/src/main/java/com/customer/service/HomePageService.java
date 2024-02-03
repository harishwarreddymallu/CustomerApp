package com.customer.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.customer.dao.HomePageDAO;
import com.customer.entity.CustomerEntity;

@Component
public class HomePageService {
	private HomePageDAO addmemberdao;
	
	@Autowired
	public HomePageService(HomePageDAO addmemberdao) {
		this.addmemberdao=addmemberdao;
	}
	// Validate and save a new customer entity
	public boolean validateAddmember(String firstname, String lastname, String street, String address, String city,
			String state, String email, String phone) {
		
		CustomerEntity entity=new CustomerEntity(firstname,lastname,street,address,city,state,email,phone);
		System.out.println("I am AddMemberService Validateaddmember()");
		boolean flag=false;
		// Validate each input field
		if(firstname!=null && !firstname.isEmpty()&& !firstname.isBlank()) {
			flag=true;
		}else {
			flag= false;
		}
		if(lastname!=null&& !lastname.isEmpty()&& !lastname.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		
		if(street!=null&& !street.isEmpty()&& !street.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		
		if(address!=null&& !address.isEmpty()&& !address.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		
		if(city!=null&& !city.isEmpty()&& !city.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		
		if(state!=null&& !state.isEmpty()&& !state.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		
		if(email!=null&& !email.isEmpty()&& !email.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		
		if(phone!=null&& !phone.isEmpty()&& !phone.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		// If all fields are valid, save the customer entity
		if(flag) {
			boolean fl=addmemberdao.saveCustomerEntity(entity);
			if(fl) {
				flag=true;
			}else {
				flag=false;
			}
			
		}
		return flag;
	}
	
	// Retrieve all customer entities
	public List<CustomerEntity> getallCustomerEntity() {
		System.out.println("Invoked getAllMemberEntity");
		if(addmemberdao.getAllCustomerEntity().size()!=0) {
			return addmemberdao.getAllCustomerEntity();			
		}
		return null;
	}
	
	// Delete a customer entity based on email
	public boolean deleteCustomerEntity(String email) {
		System.out.println("invoked deleteCustomerEntity in Service class");
		return addmemberdao.deleteCustomerEntity(email);
	}
	
	// Get a customer entity by email
	public CustomerEntity getMemberByEmail(String email) {
		System.out.println("validate.....id by ");
		return addmemberdao.getEntityByEmail(email);
	}
	
	// Update (edit) a customer entity
	public boolean updateCustomerEntity(String firstname, String lastname, String street, String address, String city,
			String state, String email, String phone) {
		System.out.println("invoked updateAirportEntity");
		CustomerEntity entity=new CustomerEntity(firstname,lastname,street,address,city,state,email,phone);
		return addmemberdao.EditCustomerEntity(entity);
	}
	
	// Validate if search criteria are valid
	public boolean validateCustomerName(String searchby, String search) {
		boolean flag=false;
		if(searchby!=null && !searchby.isEmpty()&& !searchby.isBlank()) {
			flag=true;
		}else {
			flag= false;
		}
		if(flag) {
			if(search!=null&& !search.isEmpty()&& !search.isBlank()){
				flag=true;
			}else {
				flag= false;
			}	
		}else {
			flag=false;
		}
		return flag;
	}

	// Validate and search for a customer entity
	public CustomerEntity validateSearch(String searchby, String search) {
		// TODO Auto-generated method stub
		CustomerEntity entity=new CustomerEntity();
		System.out.println("i m in the fistname search of service class");
		boolean flag=false;
		
		if(search!=null && !search.isEmpty()&& !search.isBlank()) {
			flag=true;
		}else {
			flag= false;
		}
		
		if(flag) {
			entity=addmemberdao.getMemberByName(searchby,search);
		}
		return entity;
	}

	// Retrieve a list of customer entities based on the provided search criteria
	public List<CustomerEntity> getSearchbyCustomerEntity(String searchby, String search) {
		System.out.println("Invoked getAllMemberEntity");
		if(addmemberdao.getAllCustomerEntity().size()!=0) {
			return addmemberdao.getSearchByCustomerEntity(searchby,search);			
		}
		return null;
	}

	

}
