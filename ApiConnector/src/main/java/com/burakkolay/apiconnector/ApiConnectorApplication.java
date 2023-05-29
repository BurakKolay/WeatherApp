package com.burakkolay.apiconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiConnectorApplication.class, args);
	}
}
