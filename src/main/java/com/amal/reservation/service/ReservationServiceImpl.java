package com.amal.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.amal.reservation.entities.Reservation;
import com.amal.reservation.entities.Type;
import com.amal.reservation.repos.ReservationRepository;
import com.amal.reservation.repos.TypeRepository;
@Service

public class ReservationServiceImpl  implements ReservationService{
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	TypeRepository typeRepository;
	@Override
	public List<Type> getAllTypes() {
	return typeRepository.findAll();
	}
	@Override
	public Reservation saveReservation(Reservation p) {
		return reservationRepository.save(p);		
	}

	@Override
	public Reservation updateReservation(Reservation p) {
		return reservationRepository.save(p);
	}

	@Override
	public void deleteReservation(Reservation p) {
		reservationRepository.delete(p);
		
	}

	@Override
	public void deleteReservationById(Long id) {
		reservationRepository.deleteById(id);
		
	}

	@Override
	public Reservation getReservation(Long id) {
		return reservationRepository.findById(id).get();

	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();

	}
	@Override
	public Page<Reservation> getAllReservationsParPage(int page, int size) {
	return reservationRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Reservation> findByNomClient(String nom) {
		// TODO Auto-generated method stub
		return reservationRepository.findByNomClient(nom);
	}

	@Override
	public List<Reservation> findByNomClientContains(String nom) {
		// TODO Auto-generated method stub
		return  reservationRepository.findByNomClientContains(nom);
	}

	@Override
	public List<Reservation> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return reservationRepository.findByNomPrix(nom, prix);

	}

	@Override
	public List<Reservation> findByType(Type type) {
		// TODO Auto-generated method stub
		return  reservationRepository.findByType(type);

	}

	@Override
	public List<Reservation> findByTypeIdTy(Long id) {
		// TODO Auto-generated method stub
		return  reservationRepository.findByTypeIdTy(id);

	}

	@Override
	public List<Reservation> findByOrderByNomTypeAsc() {
		// TODO Auto-generated method stub
		return reservationRepository.findByOrderByNomClientAsc();

	}

	@Override
	public List<Reservation> trierReservationsNomsPrix() {
		// TODO Auto-generated method stub
		return  reservationRepository.trierReservationsNomsPrix();
	}

}
