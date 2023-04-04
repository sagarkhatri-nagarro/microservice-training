package com.nagarro.assignment.account.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sagarkhatri
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("Account")
public class Account {
	
	@Id
	private String accountNumber;
	private String customerId;
	private String accountHolderName;
	private BigDecimal amount;
	

	@Transient
	private Customer customer;


	public void setAccountNumber(String generateAccountNumber) {
		// TODO Auto-generated method stub
		
	}


	public String getAccountHolderName() {
		// TODO Auto-generated method stub
		return accountHolderName;
	}


	public BigDecimal getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}


	public void setAmount(BigDecimal add) {
		// TODO Auto-generated method stub
		this.amount = add;
	}


	public String getCustomerId() {
		// TODO Auto-generated method stub
		return customerId;
	}


	public void setCustomer(Customer customer2) {
		// TODO Auto-generated method stub
		this.customer = customer2;
	}
}
