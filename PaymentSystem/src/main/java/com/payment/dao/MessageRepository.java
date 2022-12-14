package com.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, String>{

}
