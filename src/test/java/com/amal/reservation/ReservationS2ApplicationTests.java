package com.amal.reservation;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.amal.reservation.entities.Reservation;
import com.amal.reservation.entities.Type;
import com.amal.reservation.repos.ReservationRepository;
import com.amal.reservation.service.ReservationService;

@SpringBootTest
class ReservationS2ApplicationTests {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ReservationService reservationService;

	@Test
	public void testCreateReservation() {
		Reservation res = new Reservation("amal bouaouina", 2200.500, new Date());
		reservationRepository.save(res);
	}

	@Test
	public void testFindReservation() {
		Reservation r = reservationRepository.findById(1L).get();
		System.out.println(r);
	}

	@Test
	public void testUpdateReservation() {
		Reservation r = reservationRepository.findById(1L).get();
		r.setPrixSejour(1000.0);
		reservationRepository.save(r);
	}

	@Test
	public void testDeleteReservation() {
		reservationRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousReservations() {
		List<Reservation> res = reservationRepository.findAll();
		for (Reservation r : res) {
			System.out.println(r);
		}
	}

	@Test
	public void testFindByNomClient() {
		List<Reservation> res = reservationRepository.findByNomClient("syrine");
		for (Reservation r : res) {
			System.out.println(r);
		}
	}

	@Test
	public void testFindByNomReservationContains() {
		List<Reservation> res = reservationRepository.findByNomClientContains("boussetta");
		for (Reservation r : res) {
			System.out.println(r);
		}

	}

	@Test
	public void testfindByNomPrix() {
		List<Reservation> res = reservationRepository.findByNomPrix("ranim jrad", 1000.0);
		for (Reservation r : res) {
			System.out.println(r);
		}
	}

	@Test
	public void testfindByType() {
		Type ty = new Type();
		ty.setIdTy(1L);
		List<Reservation> res = reservationRepository.findByType(ty);
		for (Reservation r : res) {
			System.out.println(r);
		}
	}

	@Test
	public void findByTypeIdTy() {
		List<Reservation> res = reservationRepository.findByTypeIdTy(1L);
		for (Reservation r : res) {
			System.out.println(r);
		}
	}

	@Test
	public void testfindByOrderByNomClientAsc() {
		List<Reservation> res = reservationRepository.findByOrderByNomClientAsc();
		for (Reservation r : res) {
			System.out.println(r);
		}
	}

	@Test
	public void testTrierReservationsNomsPrix() {
		List<Reservation> res = reservationRepository.trierReservationsNomsPrix();
		for (Reservation r : res) {
			System.out.println(r);
		}
	}



}
