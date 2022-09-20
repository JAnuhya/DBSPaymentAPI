package com.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dao.BankRepository;
import com.payment.dao.CurrencyRepository;
import com.payment.dao.CustomerRepository;
import com.payment.dao.MessageRepository;
import com.payment.dao.SanctionListRepository;
import com.payment.dao.TransactionRepository;
import com.payment.dao.TransferTypeRepository;
import com.payment.entity.Customer;
import com.payment.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	SanctionListRepository sanctionListRepository;
	
	@Autowired
	CustomerService customerService;
	
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired
	BankRepository bankrepository;
	
	@Autowired
	TransferTypeRepository transferTypeRepository;
	
	@Autowired
	MessageRepository messageRepository;
/*
	@Override
	public Transaction addTransaction(Transaction transaction) {
		
		//sender details validate
		
		
		
		//receiver-blocklist
		
		
		//transaction amount- 
		
		/**
		  Recevier blocklist
			transfertype checking
			amount check(includes transferfee)
	 not possible check overdraft
		 
		
		//transaction.getCustomer().getCustomerId()
		Optional<Customer> temp = customerService.getCustomerDetailsById(1);
		if(false) {
			//check blocklist in blocklist table
		}
		
		
		else if(transaction.getAmount()<=temp.get().getClearBalance()){
			//allow transaction(calculate total amt with transaction fees)
		}
		else {
			//check transfer type
			if(transaction.getTransferType().getTransferTypeCode().equalsIgnoreCase("cus")) {
				//entered amount should come here
			}
			
		}
		
		return transactionRepository.save(transaction);
	}
	*/
	
	@Override
    public Transaction saveTransaction(Transaction transaction) {
        
        String receiverName=transaction.getReceiverAccountHolderName();
        if(sanctionListRepository.findById(receiverName)!=null) {
            //return exception message sender in block list
        }
        Customer sender=customerRepository.getCustomer(transaction.getCustomer().getCustomerId());
        double amount=transaction.getAmount();
        double tranferFee=amount*(0.2);
        double totalAmount=amount+tranferFee;
                
        System.out.println("transfer fee: " + tranferFee);

        if(sender.getClearBalance()<totalAmount) {
            
        	if(!sender.isOverDraftStatus()) {
        		//send low balance message(exception)
        	}
        	
        }
        Customer recevier=customerRepository.getCustomer(transaction.getReciverAccountHolderNumber());
        System.out.print(transaction.getTransferType());
        if(transaction.getTransferType().getTransferTypeCode().equalsIgnoreCase("BANK")) {
            if(sender.getBank().getBankName()!="HDFC" || recevier.getBank().getBankName()!="HDFC") {
                //throw exception message incorrect transfertype
            }
        }
        
        System.out.println("befor : " + sender.getClearBalance() + " " + recevier.getClearBalance());
        double senderamo=sender.getClearBalance();
        
         sender.setClearBalance(senderamo-totalAmount);
         double ra=recevier.getClearBalance();
        recevier.setClearBalance(ra+amount);
        
        System.out.println("After : " + sender.getClearBalance() + " " + recevier.getClearBalance());

        
        transaction.setTransferFees(tranferFee);
        transaction.setTotalAmount(totalAmount);
        
        
        
        return transactionRepository.save(transaction);
    }
@Override
public Transaction addTransaction(Transaction transaction) {
	// TODO Auto-generated method stub
	return null;
}
	
}
