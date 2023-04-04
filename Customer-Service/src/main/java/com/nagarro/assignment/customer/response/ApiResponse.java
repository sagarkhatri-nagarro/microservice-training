package com.nagarro.assignment.customer.response;

import org.springframework.http.HttpStatus;

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
public class ApiResponse {
	public ApiResponse(String string, boolean b, HttpStatus ok) {
		// TODO Auto-generated constructor stub
		message = string;
		success = b;
		httpStatus = ok;
	}
	private String message;
	private boolean success;
	private HttpStatus httpStatus;
}
