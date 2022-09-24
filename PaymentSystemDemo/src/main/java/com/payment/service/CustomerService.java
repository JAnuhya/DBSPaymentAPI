package com.payment.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;


import com.payment.entity.Customer;

@Service
public interface CustomerService {

	public Optional<Customer> getCustomerDetailsById(long customerId);
	public Customer addCustomerDetails(Customer customer);
	public List<Customer> getAllCustomerDetails();
	public Customer updateCustomer(long customerid,Customer customer);
	public void deleteCustomer(long customerid);
	
	public Customer getCustomer(long customerId);
	
	
}
