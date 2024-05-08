package com.amal.reservations.restcontrollers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.amal.reservation.entities.Reservation;
import com.amal.reservation.service.ReservationService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class ReservationRESTController {
	
	@Autowired
	ReservationService reservationService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Reservation> getAllReservations() {
	return reservationService.getAllReservations();
	}
	
	@GetMapping("/{id}")
	public Reservation getReservationById(@PathVariable("id") Long id) {
	return reservationService.getReservation(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Reservation createReservation(@RequestBody Reservation reservation) {
	return reservationService.saveReservation(reservation);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Reservation updateReservation(@RequestBody Reservation reservation) {
	return reservationService.updateReservation(reservation);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteReservation(@PathVariable("id") Long id)
	{
		reservationService.deleteReservationById(id);
	}
	@RequestMapping(value="/resty/{idTy}",method = RequestMethod.GET)
	public List<Reservation> getReservationsByTyId(@PathVariable("idTy") Long idTy) {
	return reservationService.findByTypeIdTy(idTy);
	}



}