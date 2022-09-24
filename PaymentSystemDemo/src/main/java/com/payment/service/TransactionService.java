package com.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.payment.entity.Transaction;
import com.payment.entity.TransactionObject;
import com.payment.exception.ExceptionHandle;


@Service
public interface TransactionService {

	public Transaction addTransaction(Transaction transaction);
	//public Transaction saveTransaction(Transaction transaction);
	public List<Transaction> getAllTransactions();
	Optional<Transaction> getTransactionDetailById(int transactionId);
	
	public Transaction saveTransaction(TransactionObject transaction) throws ExceptionHandle;
	
	
	
	
	
	
}
