package com.amal.reservation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.amal.reservation.service.ReservationService;
import com.amal.reservation.entities.Reservation;

@SpringBootApplication
public class ReservationS2Application implements CommandLineRunner {
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	
	public static void main(String[] args) {
		SpringApplication.run(ReservationS2Application.class, args);
	}
	
 @Override
	public void run(String... args) throws Exception {
	 repositoryRestConfiguration.exposeIdsFor(Reservation.class);

	} 





}
