package com.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dao.BankRepository;
import com.payment.entity.Bank;

@Service
public class BankServiceImpl implements BankService{
	
	@Autowired
	BankRepository bankrepository;

	@Override
	public Bank addBankDetails(Bank bank) {
		return bankrepository.save(bank);
	}

	@Override
	public Bank updateBankDetails(Bank bank) {
		return null;
	}

	@Override
	public void deleteBank(String bic) {
		bankrepository.deleteById(bic);
	}

	@Override
	public List<Bank> getAllBankDetails() {
		return bankrepository.findAll();
	}

	@Override
	public Optional<Bank> getBankDetailsById(String bic) {
		return bankrepository.findById(bic);
	}

}
