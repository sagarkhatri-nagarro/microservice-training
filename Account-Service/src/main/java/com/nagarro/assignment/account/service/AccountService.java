package com.nagarro.assignment.account.service;

import java.util.List;

import com.nagarro.assignment.account.domain.Account;

/**
 * @author sagarkhatri
 *
 */
public interface AccountService {

	//create Account
	Account createAccount(Account account);
	
	//get all
	List<Account> getAllAccount();
	
	//add Money
	Account addMoneyToAccount(Account account, String accountNumber);
	
	//withdraw Money
	Account withdrawMoneyFromAccount(Account account, String accountNumber);
	
	//get single Account
	//Account getSingleAccount(String accountNumber);
	
	//delete Account
	void deleteAccount(String accountNumber);
	
	
	// delete by customer id
	void deleteAccountByCustomerId(String customerId);

	// get by customer id
	Account getAccountByCustomerId(String customerId);
}
