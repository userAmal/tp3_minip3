package com.amal.reservation.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.amal.reservation.entities.Reservation;
import com.amal.reservation.entities.Type;

public interface ReservationService {
	Reservation saveReservation(Reservation p);
	Reservation updateReservation(Reservation p);
	void deleteReservation(Reservation p);
	 void deleteReservationById(Long id);
	 Reservation getReservation(Long id);
	List<Reservation> getAllReservations();
	Page<Reservation> getAllReservationsParPage(int page, int size);
	List<Reservation> findByNomClient(String nom);
	List<Reservation> findByNomClientContains(String nom);
	List<Reservation> findByNomPrix (String nom, Double prix);
	List<Reservation> findByType (Type type);
	List<Reservation> findByTypeIdTy(Long id);
	List<Reservation> findByOrderByNomTypeAsc();
	List<Reservation> trierReservationsNomsPrix();
	List<Type> getAllTypes();

}
