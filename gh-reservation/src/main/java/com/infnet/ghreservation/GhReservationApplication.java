package com.infnet.ghreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GhReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GhReservationApplication.class, args);
	}

}
