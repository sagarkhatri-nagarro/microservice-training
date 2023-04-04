package com.nagarro.assignment.customer.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignment.customer.dao.CustomerDao;
import com.nagarro.assignment.customer.domain.Account;
import com.nagarro.assignment.customer.domain.Customer;
import com.nagarro.assignment.customer.exception.ResourceNotFoundException;
import com.nagarro.assignment.customer.externalService.AccountService;
import com.nagarro.assignment.customer.service.CustomerService;

/**
 * @author sagarkhatri
 *
 */
@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private AccountService accountService;

	@Override
	public Customer createCustomer(Customer customer) {
		String randomUserUuid = UUID.randomUUID().toString();
		customer.setCustomerId(randomUserUuid);
		return customerDao.save(customer);
	}

	
	@Override
	public List<Customer> getAllCustomers() {

		return customerDao.findAll();
	}

	@Override
	public Customer getSingleCustomer(String customerId) {
		Customer customer = customerDao.findById(customerId).orElseThrow(
				() -> new ResourceNotFoundException("Customer with given id not found on server!" + customerId));
		return customer;
	}

	@Override
	public void deleteCustomer(String customerId) {
		customerDao.deleteById(customerId);
		accountService.deleteAccountByCustomerId(customerId);
	}

	// update
	@Override
	public Customer updateCustomer(Customer customer, String customerId) {
		Customer getCustomerIdToUpdateCustomer = customerDao.findById(customerId).orElseThrow(
				() -> new ResourceNotFoundException("Customer with given id not found on server!" + customerId));

		getCustomerIdToUpdateCustomer.setCustomerName(customer.getCustomerName());
		getCustomerIdToUpdateCustomer.setCustomerEmail(customer.getCustomerEmail());
		getCustomerIdToUpdateCustomer.setCustomerMobileNumber(customer.getCustomerMobileNumber());

		return customerDao.save(getCustomerIdToUpdateCustomer);
	}

}
