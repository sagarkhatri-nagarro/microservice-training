package com.nagarro.assignment.customer.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sagarkhatri
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private String accountNumber;
	private String customerId;
	private String accountHolderName;
	private BigDecimal amount;

}
