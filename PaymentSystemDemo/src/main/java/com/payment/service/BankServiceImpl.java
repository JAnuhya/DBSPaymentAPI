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
	BankRepository bankRepository;

	@Override
	public Bank addBankDetails(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public Bank updateBankDetails(String bic,Bank bank) {
		
		if(bankRepository.findById(bic).isPresent()) {
			return bankRepository.save(bank);
		}
		return null;
	}

	@Override
	public void deleteBank(String bic) {
		bankRepository.deleteById(bic);
	}

	@Override
	public List<Bank> getAllBankDetails() {
		return bankRepository.findAll();
	}

	@Override
	public Optional<Bank> getBankDetailsById(String bic) {
		return bankRepository.findById(bic);
	}

}