package com.nagarro.assignment.customer.service;

import java.util.List;

import com.nagarro.assignment.customer.domain.Customer;

/**
 * @author sagarkhatri
 *
 */
public interface CustomerService {
	
	// create Customer
	Customer createCustomer(Customer customer);

	// get all Customer
	List<Customer> getAllCustomers();

	// get single Customer

	Customer getSingleCustomer(String customerId);

	// delete Customer
	void deleteCustomer(String customerId);

	// update Customer
	Customer updateCustomer(Customer customer, String customerId);
}
