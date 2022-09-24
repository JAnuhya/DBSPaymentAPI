package com.payment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemporaryBank {
	
	private long senderId;
	private String senderBankId;
	private long receiverId;
	private String receiverBankId;
	private String currencyCode;
	private double amount;
	private String transferTypeCode;
	private String messageCode;
	

}
