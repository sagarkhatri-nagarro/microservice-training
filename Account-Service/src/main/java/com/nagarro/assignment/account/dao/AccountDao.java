package com.nagarro.assignment.account.dao;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nagarro.assignment.account.domain.Account;

/**
 * @author sagarkhatri
 *
 */
public interface AccountDao extends MongoRepository<Account, String>{
	
	Account findByAccountNumberAndAccountHolderName(String accountNumber, String accountHolderName);
	
	Account findByCustomerId(String customerId);
	
	@DeleteQuery
	void deleteByCustomerId(String customerId);

}
