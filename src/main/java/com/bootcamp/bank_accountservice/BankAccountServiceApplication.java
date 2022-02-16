package com.bootcamp.bank_accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

}
