//package com.payment.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.payment.dao.CurrencyRepository;
//import com.payment.entity.Bank;
//import com.payment.entity.Currency;
//import com.payment.entity.Customer;
//import com.payment.entity.Message;
//import com.payment.entity.Transaction;
//import com.payment.entity.TransferType;
//import com.payment.service.BankService;
//import com.payment.service.CurrencyService;
//import com.payment.service.CustomerService;
//import com.payment.service.MessageService;
//import com.payment.service.TransactionService;
//import com.payment.service.TransferTypeService;
//
//@RestController
//@RequestMapping(value = "/dbsapi")
//public class MainController {
//	
//	@Autowired
//	CurrencyRepository currencyRepository;
//	
//	@Autowired
//	BankService bankService;
//	
//	@Autowired
//	CustomerService customerService;  //update
//	
//	@Autowired
//	CurrencyService currencyService;
//	
//	@Autowired
//	MessageService messageService;
//	
//	@Autowired
//	TransferTypeService transferTypeService;
//	
//	@Autowired
//	TransactionService transactionService;
//	
//	@PostMapping(value="/transaction")
//	Transaction addTransaction(@RequestBody Transaction transaction) {
//		return transactionService.saveTransaction(transaction);
//	}
//	
//	@GetMapping(value = "/addbank")
//	Bank addbankDetails() {
//		Bank bank = new Bank();
//		bank.setBic("ABCDEF");
//		bank.setBankName("SBI");
//		Bank result = bankService.addBankDetails(bank);
//		
//		Customer customer =new Customer();
//		customer.setBank(bank);
//		customer.setClearBalance(400000);
//		customer.setCustomerAddress("Hyderabad,Telangana");
//		customer.setCustomerCity("Hyderabad");
//		customer.setCustomerId(87654322);
//		customer.setCustomerName("Jack Sparrow");
//		customer.setOverDraftStatus(true);
//		Customer customerResult=customerService.addCustomerDetails(customer);
//		
//		Bank bank1 = new Bank();
//		bank1.setBic("ABCDFG");
//		bank1.setBankName("HDFC");
//		Bank result1 = bankService.addBankDetails(bank);
//		
//		Customer customer2 =new Customer();
//		customer2.setBank(bank);
//		customer2.setClearBalance(500000);
//		customer2.setCustomerAddress("Hyderabad,Telangana");
//		customer2.setCustomerCity("Hyderabad");
//		customer2.setCustomerId(8765876);
//		customer2.setCustomerName("Bill");
//		customer2.setOverDraftStatus(false);
//		Customer customerResult2=customerService.addCustomerDetails(customer);
//		/*
//		Currency currency=new Currency();
//		currency.setConversionRate(12);
//		currency.setCurrencyCode("INR");
//		currency.setCurrencyName("Indian rupee");
//		Currency currencyResult=currencyService.addCurrency(currency);
//		
//		Message message=new Message();
//		message.setInstruction("if");
//		message.setMessageCode("QWE");
//		Message messageResult=messageService.addMessageDetails(message);
//		
//		TransferType transferType=new TransferType();
//		transferType.setTransferTypeCode("cus");
//		transferType.setTransferTypeDescription("customer type");
//		TransferType transferTypeResult=transferTypeService.addTransferTypeDetails(transferType);
//		*/
//		
//		
//		return result1;
//	}
//	
//	@CrossOrigin("*")
//	@GetMapping(value="/customer/{customerid}")
//	Optional<Customer> getCustomerDetails(@PathVariable("customerid") long customerid) {
//		
//		
//		return customerService.getCustomerDetailsById(customerid);
//		
//	}
//	
//	@CrossOrigin("*")
//	@GetMapping(value="/bank/{bankId}")
//	Optional<Bank> getBankDetailsById(@PathVariable("bankId") String bic){
//		
//		return bankService.getBankDetailsById(bic);
//		
//	}
//	@CrossOrigin("*")
//	@GetMapping(value="/getAllTransferTypes")
//	List<TransferType> getAllTransferTypes(){
//		return transferTypeService.getAllTransferTypes();
//	}
//	
//	@GetMapping(value="/getMessageCodes")
//	List<Message> getMessageCodes(){
//		return messageService.getMessageCodes();
//	}
//	
//	@CrossOrigin(origins = "http://localhost:3000")
//	@GetMapping(value="/getAllCustomerDetails")
//	List<Customer> getListOfCustomers(){
//		
//		
//		
//		return customerService.getAllCustomerDetails();
//		
//	}
//	
//	
//	
//	@GetMapping(value="/getCurrencyDetails")
//	List<Currency> getCurrencyDetails(){
//		return currencyService.getAllCurrencyDetails();
//		
//	}
//	
//
//	@CrossOrigin(origins = "http://localhost:3000")
//	@DeleteMapping(value="/deleteCustomerById/{customerId}")
//	public void deleteCustomerDetails(@PathVariable("customerId") long customerId) {
//		customerService.deleteCustomer(customerId);
//	}
//	
//	@CrossOrigin("*")
//	@GetMapping(value="/getTransactionDetailById/{transactionId}")
//	Optional<Transaction> getTransactionDetailById(@PathVariable("transactionId")int transactionId){
//		return transactionService.getTransactionDetailById(transactionId);
//		
//	}
//
//	
//}


package com.payment.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dao.CustomerRepository;
import com.payment.entity.Bank;
import com.payment.entity.Customer;
import com.payment.entity.Message;
import com.payment.entity.Transaction;
import com.payment.entity.TransactionObject;
import com.payment.entity.TransferType;
import com.payment.exception.ExceptionHandle;
import com.payment.service.BankService;
import com.payment.service.CurrencyService;
import com.payment.service.CustomerService;
import com.payment.service.MessageService;
import com.payment.service.TransactionService;
import com.payment.service.TransferTypeService;
@CrossOrigin("*")
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
    
    @Autowired
    TransactionService transactionService;
    
    @GetMapping(value = "/addbank")
    Customer addbankDetails() {
//        Bank bank = new Bank();
//        bank.setBic("BCEYINYMTYU");
//        bank.setBankName("SBI");
//        Bank result = bankService.addBankDetails(bank);
        
        Customer customer =new Customer();
        customer.setClearBalance(1000000);
        customer.setCustomerAddress("Mumbai,Maharastra");
        customer.setCustomerCity("Munbai");
        customer.setCustomerId(87654322);
        customer.setCustomerName("Doraemon");
        customer.setOverDraftStatus(true);
        Customer customerResult=customerService.addCustomerDetails(customer);
        
//        Currency currency=new Currency();
//        currency.setConversionRate(12);
//        currency.setCurrencyCode("INR");
//        currency.setCurrencyName("Indian rupee");
//        Currency currencyResult=currencyService.addCurrency(currency);
//        
//        Message message=new Message();
//        message.setInstruction("if");
//        message.setMessageCode("QWE");
//        Message messageResult=messageService.addMessageDetails(message);
//        
//        TransferType transferType=new TransferType();
//        transferType.setTransferTypeCode("cus");
//        transferType.setTransferTypeDescription("customer type");
//        TransferType transferTypeResult=transferTypeService.addTransferTypeDetails(transferType);
        
        
        return customerResult;
    }
    
    @CrossOrigin("*")
    @GetMapping(value="/getCustomer/{customerid}")
    Optional<Customer> getCustomerDetails(@PathVariable("customerid") long customerid) {
        
        
        return customerRepository.findById(customerid);
        
    }
    
    @CrossOrigin("*")
    @GetMapping(value="/getBankDetails/{bic}")
    Optional<Bank> getBankDetailsById(@PathVariable("bic") String bic){
        
        return bankService.getBankDetailsById(bic);
        
    }
    
    @CrossOrigin("*")
    @GetMapping(value="/getAllTransferTypes")
    List<TransferType> getAllTransferTypes(){
        return transferTypeService.getAllTransferTypes();
    }
    
    @CrossOrigin("*")
    @GetMapping(value="/getMessageCodes")
    List<Message> getMessageCodes(){
        return messageService.getMessageCodes();
    }
    
    @GetMapping(value="/addTransferType")
    TransferType addTransferType() {
        TransferType tt=new TransferType("Customer","This is Customer Type");
        return transferTypeService.addTransferTypeDetails(tt);
    }
    
    /*
    @GetMapping(value="/getAllCustomerDetails")
    List<Customer> getListOfCustomers(){
        
        
        
        return customerRepository.findAll();
        
    }*/
    //@CrossOrigin("*")
    //@PostMapping(value="/transaction")
//    Transaction addTranscation(@RequestBody Transaction transaction)throws ExceptionHandle {
//        System.out.println("fwdhs");
//        
//        return transactionService.saveTransaction(transaction);//new ResponseEntity(transactionService, HttpStatus.OK);
//    }
    @GetMapping(value="/getAmount")
    double getAmount() {
        return customerRepository.getClearBalanceById(87654321);
        
    }
    @CrossOrigin("*")
    @GetMapping(value="/customer/{customerId}")
    Customer getCustomer(@PathVariable("customerId")long cus) {
        return customerService.getCustomer(cus);
    }
    @CrossOrigin("*")
    @GetMapping(value="/bank/{bankId}")
    Optional<Bank> getBank(@PathVariable("bankId")String bankId) {
        return bankService.getBankDetailsById(bankId);
    }
    
    @CrossOrigin("*")
    @PostMapping(value="/transaction")
    Transaction transcation(@RequestBody TransactionObject transactionObject)throws ExceptionHandle {
        System.out.println("fwdhs");
        
        return transactionService.saveTransaction(transactionObject);//new ResponseEntity(transactionService, HttpStatus.OK);
    }
    
    @CrossOrigin("*")
    @GetMapping(value="/transaction/{id}")
    Optional<Transaction> getTransactionById(@PathVariable("id") int id){
    	return transactionService.getTransactionDetailById(id);
    }
    
    
}