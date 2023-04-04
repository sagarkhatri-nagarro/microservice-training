package com.nagarro.assignment.customer.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author sagarkhatri
 *
 */
@Service
@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountService {

	@DeleteMapping("/account-api/accounts/customers/{customerId}")
	void deleteAccountByCustomerId(@PathVariable String customerId);
}
