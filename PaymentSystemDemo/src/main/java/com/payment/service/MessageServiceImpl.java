package com.payment.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dao.MessageRepository;
import com.payment.entity.Message;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageRepository messageRepository;
	
	@Override
	public Message addMessageDetails(Message message) {
		// TODO Auto-generated method stub
		return messageRepository.save(message);
	}

	@Override
	public List<Message> getMessageCodes() {
		// TODO Auto-generated method stub
		return messageRepository.findAll();
	}

	@Override
	public void deleteMessageDetails(String messageCode) {
		messageRepository.deleteById(messageCode);
		
	}

	@Override
	public Message updateMessageDetails(String messageCode, Message message) {
		if(messageRepository.findById(messageCode).isPresent()) {
			return messageRepository.save(message);
		}
		return null;
	}

}
