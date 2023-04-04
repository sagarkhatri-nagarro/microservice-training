package com.nagarro.assignment.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Entity
@Table(name = "Users")
public class Customer {

	@Id
	@Column(name = "UserId")
	private String customerId;
	
	@Column(name = "Name", nullable = false)
	private String customerName;
	
	@Column(name = "Email")
	private String customerEmail;
	
	@Column(name = "Mobile_Number")
	private Long customerMobileNumber;

	public void setCustomerId(String randomUserUuid) {
		// TODO Auto-generated method stub
		customerId = randomUserUuid;
	}

	public Object getCustomerName() {
		// TODO Auto-generated method stub
		return customerName;
	}

	public Object getCustomerEmail() {
		// TODO Auto-generated method stub
		return customerEmail;
	}
	
}
