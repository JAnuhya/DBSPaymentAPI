package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.Bank;
import com.payment.service.BankService;

@RestController
@RequestMapping(value = "/maincontroller")
public class MainController {
	
	@Autowired
	BankService bankservice;
	
	@GetMapping(value = "/addbank")
	Bank addbankDetails() {
		Bank bank = new Bank();
		bank.setBic("BCEYINYMXX");
		bank.setBankName("HDFC");
		Bank result = bankservice.addBankDetails(bank);
		return result;
	}
}
