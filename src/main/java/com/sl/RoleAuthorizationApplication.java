package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.sl")
@SpringBootApplication
public class RoleAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleAuthorizationApplication.class, args);
	}

}
