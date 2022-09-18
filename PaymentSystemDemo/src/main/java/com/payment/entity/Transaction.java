package com.payment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Entity
public class Transaction {
	
	@Id
	private int transactionId;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "currencycode")
	private Currency currency;
	
	@ManyToOne
	@JoinColumn(name = "senderBic")
	private Bank senderBank;
	
	@ManyToOne
	@JoinColumn(name = "receiverBic")
	private Bank receiverBank;
	
	private String reciverAccountHolderNumber;
	private String receiverAccountHolderName;
	
	@ManyToOne
	@JoinColumn(name = "transferTyperCode")
	private TransferType transferType;
	
	@ManyToOne
	@JoinColumn(name = "messageCode")
	private Message message;
	
	private double amount;
	private double transferFees;
	private double totalAmount;
	private String transferDate;
}
