package com.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dao.CustomerRepository;
import com.payment.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Optional<Customer> getCustomerDetailsById(long customerId) {
		
		return customerRepository.findById(customerId);
	}

	@Override
	public Customer addCustomerDetails(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(long customerid, Customer customer) {
		if(customerRepository.findById(customerid).isPresent()) {
			return customerRepository.save(customer);
		}
		return null;
	}

	@Override
	public void deleteCustomer(long customerid) {
		customerRepository.deleteById(customerid);
		
	}
	
	
}
