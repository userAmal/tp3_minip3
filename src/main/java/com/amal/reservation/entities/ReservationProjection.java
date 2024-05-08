package com.amal.reservation.entities;
import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomCli", types = { Reservation.class })

public interface ReservationProjection {

	public String getNomClient();
}
