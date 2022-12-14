package com.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payment.entity.Message;

@Service
public interface MessageService {

	public Message addMessageDetails(Message message);
	public List<Message> getMessageCodes();
	public void deleteMessageDetails(String messageCode);
	public Message updateMessageDetails(String messageCode,Message message);
	
}
