package com.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.entity.TransferType;

@Repository
public interface TransferTypeRepository extends JpaRepository<TransferType, String>{

}
