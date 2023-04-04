package com.nagarro.assignment.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class AccountServiceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceManagementApplication.class, args);
	}

}
