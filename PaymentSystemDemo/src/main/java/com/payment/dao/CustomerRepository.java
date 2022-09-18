package com.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}