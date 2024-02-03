package com.customer.dao;

import java.util.List;

import com.customer.entity.CustomerEntity;

public interface HomePageDAO {
	
	boolean saveCustomerEntity(CustomerEntity entity);

	List<CustomerEntity> getAllCustomerEntity();

	boolean deleteCustomerEntity(String email);

	CustomerEntity getEntityByEmail(String email);

	boolean EditCustomerEntity(CustomerEntity entity);

	CustomerEntity getMemberByName(String searchby, String search);

	List<CustomerEntity> getSearchByCustomerEntity(String searchby, String search);

}
