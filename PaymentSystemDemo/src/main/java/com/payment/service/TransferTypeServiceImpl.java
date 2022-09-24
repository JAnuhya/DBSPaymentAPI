package com.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dao.TransferTypeRepository;
import com.payment.entity.TransferType;

@Service
public class TransferTypeServiceImpl implements TransferTypeService{

	@Autowired
	TransferTypeRepository transferTypeRepository;
	
	@Override
	public TransferType addTransferTypeDetails(TransferType transferType) {
		// TODO Auto-generated method stub
		return transferTypeRepository.save(transferType);
	}

	@Override
	public List<TransferType> getAllTransferTypes() {
		// TODO Auto-generated method stub
		return transferTypeRepository.findAll();
	}

	@Override
	public void deleteTransferType(String transferTypeCode) {
		transferTypeRepository.deleteById(transferTypeCode);
		
	}

	@Override
	public TransferType updateTransferType(String transferTypeCode, TransferType transferType) {
		if(transferTypeRepository.findById(transferTypeCode).isPresent()) {
			return transferTypeRepository.save(transferType);
		}
		return null;
		
	}

	@Override
	public Optional<TransferType> getTransferTypeById(String transferCode) {
		// TODO Auto-generated method stub
		return transferTypeRepository.findById(transferCode);
	}

}
