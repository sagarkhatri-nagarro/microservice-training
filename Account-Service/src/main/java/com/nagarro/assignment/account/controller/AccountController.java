package com.nagarro.assignment.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment.account.domain.Account;
import com.nagarro.assignment.account.response.ApiResponse;
import com.nagarro.assignment.account.service.AccountService;

/**
 * @author sagarkhatri
 *
 */
@RestController
@RequestMapping("/account-api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	// post
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
	}

	// get all
	@GetMapping
	public ResponseEntity<List<Account>> getAllAccount() {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.getAllAccount());
	}

	// add money
	@PutMapping("/{accountNumber}/deposit")
	public ResponseEntity<Account> addMoneyToAccount(@RequestBody Account account, @PathVariable String accountNumber) {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.addMoneyToAccount(account, accountNumber));
	}

	// withdraw money
	@PutMapping("/{accountNumber}/withdraw")
	public ResponseEntity<Account> withdrawMoneyFromAccount(@RequestBody Account account,
			@PathVariable String accountNumber) {

		return ResponseEntity.status(HttpStatus.OK)
				.body(accountService.withdrawMoneyFromAccount(account, accountNumber));
	}

	// delete
	@DeleteMapping("/{accountNumber}")
	public ResponseEntity<ApiResponse> deleteAccount(@PathVariable String accountNumber) {
		this.accountService.deleteAccount(accountNumber);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Account deletd successfully", true, HttpStatus.OK),
				HttpStatus.OK);

	}

	// get by customer id
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Account> getByCustomerId(@PathVariable String customerId) {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccountByCustomerId(customerId));
	}

	
	
	// delete
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<ApiResponse> deleteAccountByCustomerId(@PathVariable String customerId) {
		this.accountService.deleteAccountByCustomerId(customerId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Account deletd successfully", true, HttpStatus.OK),
				HttpStatus.OK);

	}
	 

	// Get single account
	/*
	 * @GetMapping("/{accountNumber}") public ResponseEntity<Account>
	 * getSingleAccount(@PathVariable String accountNumber) { Account singleAccount
	 * = accountService.getSingleAccount(accountNumber); return
	 * ResponseEntity.status(HttpStatus.OK).body(singleAccount); }
	 */
}
