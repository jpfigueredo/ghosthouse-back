package com.infnet.ghproperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GhPropertyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GhPropertyApplication.class, args);
	}

}
