package com.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String>{

}
