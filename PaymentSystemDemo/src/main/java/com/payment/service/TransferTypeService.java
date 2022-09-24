package com.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.payment.entity.TransferType;

@Service
public interface TransferTypeService {

	
	public TransferType addTransferTypeDetails(TransferType transferType);
	public List<TransferType> getAllTransferTypes();
	public void deleteTransferType(String transferTypeCode);
	public TransferType updateTransferType(String transferTypeCode,TransferType transferType);
	public Optional<TransferType> getTransferTypeById(String transferCode);
	
	
	
}
