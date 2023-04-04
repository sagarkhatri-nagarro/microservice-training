package com.nagarro.assignment.account.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.assignment.account.dao.AccountDao;
import com.nagarro.assignment.account.domain.Account;
import com.nagarro.assignment.account.domain.Customer;
import com.nagarro.assignment.account.exception.InsufficientBalanceException;
import com.nagarro.assignment.account.exception.InvalidAccountException;
import com.nagarro.assignment.account.exception.ResourceNotFoundException;
import com.nagarro.assignment.account.service.AccountService;

/**
 * @author sagarkhatri
 *
 */
@Service
public class AccountServiceImplementation implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Account createAccount(Account account) {
		String generateAccountNumber = UUID.randomUUID().toString();
		account.setAccountNumber(generateAccountNumber);
		return accountDao.save(account);
	}

	public List<Account> getAllAccount() {
		return accountDao.findAll();

	}

	@Override
	public Account addMoneyToAccount(Account requestAmount, String accountNumber) {

		Account getCustomerAccount = accountDao.findByAccountNumberAndAccountHolderName(accountNumber,
				requestAmount.getAccountHolderName());

		if (null != getCustomerAccount) {
			getCustomerAccount.setAmount(getCustomerAccount.getAmount().add(requestAmount.getAmount()));
		} else {
			throw new InvalidAccountException(
					"No Account found with given account number. Please, enter valid account number.");
		}
		return accountDao.save(getCustomerAccount);
	}

	@Override
	public Account withdrawMoneyFromAccount(Account requestAmount, String accountNumber) {
		Account getCustomerAccount = accountDao.findById(accountNumber).orElseThrow(
				() -> new ResourceNotFoundException("Account not found with given account number!" + accountNumber));

		if (null != getCustomerAccount) {
			if (getCustomerAccount.getAmount().compareTo(requestAmount.getAmount()) < 0) {
				throw new InsufficientBalanceException("Insufficient Balance to proceed.");
			}
			getCustomerAccount.setAmount(getCustomerAccount.getAmount().subtract(requestAmount.getAmount()));
		}

		return accountDao.save(getCustomerAccount);
	}

	@Override
	public void deleteAccount(String accountNumber) {
		accountDao.deleteById(accountNumber);
	}

	@Override
	public Account getAccountByCustomerId(String customerId) {

		Account account = accountDao.findByCustomerId(customerId);

		Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/customer-api/customers/" + account.getCustomerId(),
				Customer.class);
		account.setCustomer(customer);

		return account;
	}

	@Override
	public void deleteAccountByCustomerId(String customerId) {
		accountDao.deleteByCustomerId(customerId);

	}

}
