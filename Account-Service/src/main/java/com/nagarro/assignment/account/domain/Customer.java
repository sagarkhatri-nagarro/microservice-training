package com.nagarro.assignment.account.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sagarkhatri
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private String customerId;

	private String customerName;

	private String customerEmail;

	private Long customerMobileNumber;
}
