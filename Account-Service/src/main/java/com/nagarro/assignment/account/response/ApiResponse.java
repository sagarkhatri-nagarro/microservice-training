package com.nagarro.assignment.account.response;

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
	
	private String message;
	private boolean success;
	private HttpStatus httpStatus;
	public ApiResponse(String param_message,boolean param_success, HttpStatus param_http) {
		this.message = param_message;
		this.success = param_success;
		this.httpStatus = param_http;
	}
	
}
