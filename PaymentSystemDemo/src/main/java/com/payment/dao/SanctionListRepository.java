package com.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.payment.entity.SanctionList;

public interface SanctionListRepository extends JpaRepository<SanctionList, String> {

	
	@Query(value="select * from sanction_list where name =:n",nativeQuery = true)
    public SanctionList getSactionList(@Param("n") String n);
}
