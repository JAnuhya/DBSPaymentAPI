package com.payment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dao.CustomerRepository;
import com.payment.entity.Bank;
import com.payment.entity.Currency;
import com.payment.entity.Customer;
import com.payment.entity.Message;
import com.payment.entity.TransferType;
import com.payment.service.BankService;
import com.payment.service.CurrencyService;
import com.payment.service.CustomerService;
import com.payment.service.MessageService;
import com.payment.service.TransferTypeService;

@RestController
@RequestMapping(value = "/dbsapi")
public class MainController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	BankService bankService;
	
	@Autowired
	CustomerService customerService;  //update
	
	@Autowired
	CurrencyService currencyService;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	TransferTypeService transferTypeService;
	
	@GetMapping(value = "/addbank")
	Bank addbankDetails() {
		Bank bank = new Bank();
		bank.setBic("BCEYINYMTYU");
		bank.setBankName("SBI");
		Bank result = bankService.addBankDetails(bank);
		
		Customer customer =new Customer();
		customer.setBank(bank);
		customer.setClearBalance(400000);
		customer.setCustomerAddress("Hyderabad,Telangana");
		customer.setCustomerCity("Hyderabad");
		customer.setCustomerId(87654321);
		customer.setCustomerName("Jack Sparrow");
		customer.setOverDraftStatus(true);
		Customer customerResult=customerService.addCustomerDetails(customer);
		
		Currency currency=new Currency();
		currency.setConversionRate(12);
		currency.setCurrencyCode("INR");
		currency.setCurrencyName("Indian rupee");
		Currency currencyResult=currencyService.addCurrency(currency);
		
		Message message=new Message();
		message.setInstruction("if");
		message.setMessageCode("QWE");
		Message messageResult=messageService.addMessageDetails(message);
		
		TransferType transferType=new TransferType();
		transferType.setTransferTypeCode("cus");
		transferType.setTransferTypeDescription("customer type");
		TransferType transferTypeResult=transferTypeService.addTransferTypeDetails(transferType);
		
		
		return result;
	}
	
	@GetMapping(value="/getCustomerName/{customerid}")
	Optional<Customer> getCustomerDetails(@PathVariable("customerid") long customerid) {
		
		
		return customerRepository.findById(customerid);
		
	}
	
	@GetMapping(value="/getBankDetails/{bic}")
	Optional<Bank> getBankDetailsById(@PathVariable("bic") String bic){
		
		return bankService.getBankDetailsById(bic);
		
	}
	
	@GetMapping(value="/getAllTransferTypes")
	List<TransferType> getAllTransferTypes(){
		return transferTypeService.getAllTransferTypes();
	}
	
	@GetMapping(value="/getMessageCodes")
	List<Message> getMessageCodes(){
		return messageService.getMessageCodes();
	}
	
	/*
	@GetMapping(value="/getAllCustomerDetails")
	List<Customer> getListOfCustomers(){
		
		
		
		return customerRepository.findAll();
		
	}*/
	
	
	
	
	
}