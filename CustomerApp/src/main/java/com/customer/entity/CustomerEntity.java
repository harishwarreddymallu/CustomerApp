package com.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerEntity {
	
	
	
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@Column(name="LAST_NAME")
	private String lastname;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="EMAIL")
	@Id
	private String email;
	
	@Column(name="PHONE")
	private String phone;

	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}

	
	public void setStreet(String street) {
		this.street = street;
	}

	
	public String getState() {
		return state;
	}

	
	public void setState(String state) {
		this.state = state;
	}

	
	public String getPhone() {
		return phone;
	}

	
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public CustomerEntity() {
		
	}

	public CustomerEntity(String firstname, String lastname, String address, String city, String street,
			String state,String email, String phone) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.street = street;
		this.state = state;
		this.phone = phone;
	}
	


	@Override
	public String toString() {
		return "CustomerEntity [firstname=" + firstname + ", lastname=" + lastname + ", address="
				+ address + ", city=" + city + ", street=" + street + ", state=" + state + ",email=" + email + ", phone=" + phone + "]";
	}


	
	

}
