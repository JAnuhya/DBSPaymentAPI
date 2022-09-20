package com.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.entity.SanctionList;

public interface SanctionListRepository extends JpaRepository<SanctionList, String> {

}
