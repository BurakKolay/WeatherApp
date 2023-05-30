package com.burakkolay.userservice;

import com.burakkolay.commonpackage.utils.constants.Paths;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {Paths.ConfigurationBasePackage, Paths.User.ServiceBasePackage})
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
