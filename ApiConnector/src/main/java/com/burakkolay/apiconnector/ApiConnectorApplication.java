package com.burakkolay.apiconnector;

import com.burakkolay.commonpackage.utils.constants.Paths;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {Paths.ConfigurationBasePackage, Paths.Weather.ServiceBasePackage})
@EnableFeignClients
public class ApiConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiConnectorApplication.class, args);
	}
}
