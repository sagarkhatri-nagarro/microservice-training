package com.nagarro.assignment.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.assignment.customer.domain.Customer;

/**
 * @author sagarkhatri
 *
 */
public interface CustomerDao extends JpaRepository<Customer, String>{

}
