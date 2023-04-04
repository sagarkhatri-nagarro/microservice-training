package com.nagarro.assignment.customer.controller;

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

import com.nagarro.assignment.customer.domain.Customer;
import com.nagarro.assignment.customer.response.ApiResponse;
import com.nagarro.assignment.customer.service.CustomerService;

/**
 * @author sagarkhatri
 *
 */
@RestController
@RequestMapping("/customer-api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Create
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer addCustomer = customerService.createCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(addCustomer);
	}

	// get all
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> allCustomers = customerService.getAllCustomers();
		return ResponseEntity.status(HttpStatus.OK).body(allCustomers);
	}

	// Get One User By Id
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getSingleCustomer(@PathVariable String customerId) {
		Customer singleCustomer = customerService.getSingleCustomer(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(singleCustomer);
	}

	// Delete User
	@DeleteMapping("/{customerId}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable String customerId) {
		this.customerService.deleteCustomer(customerId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Customer deletd successfully", true, HttpStatus.OK),
				HttpStatus.OK);
	}

	// Update User
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable String customerId) {
		Customer updateCustomer = customerService.updateCustomer(customer, customerId);
		return ResponseEntity.status(HttpStatus.OK).body(updateCustomer);
	}

}
