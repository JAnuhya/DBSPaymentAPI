package com.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, String>{

}