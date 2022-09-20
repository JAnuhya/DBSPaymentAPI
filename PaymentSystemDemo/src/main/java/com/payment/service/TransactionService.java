package com.payment.service;

import org.springframework.stereotype.Service;

import com.payment.entity.Transaction;


@Service
public interface TransactionService {

	public Transaction addTransaction(Transaction transaction);
	public Transaction saveTransaction(Transaction transaction);
	
	
	
	
}
