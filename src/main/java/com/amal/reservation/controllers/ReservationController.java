package com.amal.reservation.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amal.reservation.entities.Reservation;
import com.amal.reservation.entities.Type;
import com.amal.reservation.service.ReservationService;

import jakarta.validation.Valid;
@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	 @RequestMapping("/listeReservations")
	public String listeReservations(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page, @RequestParam (name="size", defaultValue = "4") int size)
	{
		 {
			 Page<Reservation> res = reservationService.getAllReservationsParPage(page, size);
			 modelMap.addAttribute("reservations", res);
			 modelMap.addAttribute("pages", new int[res.getTotalPages()]);
			 modelMap.addAttribute("currentPage", page);
			 modelMap.addAttribute("size", size);
			 return "listeReservations.html";
			 }
	}
	 @RequestMapping("/showCreate")
	 public String showCreate(ModelMap modelMap)
	 {
	 List<Type> tys = reservationService.getAllTypes();
	 modelMap.addAttribute("reservation", new Reservation());
	 modelMap.addAttribute("mode", "new");
	 modelMap.addAttribute("types", tys);
	 return "formReservation";
	 }
	 @RequestMapping("/modifierReservation")
	 public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	 {
		 Reservation r= reservationService.getReservation(id);
	 List<Type> tys = reservationService.getAllTypes();
	 modelMap.addAttribute("reservation", r);
	 modelMap.addAttribute("mode", "edit");
	 modelMap.addAttribute("types", tys);
	 return "formReservation";
	 }
	 @RequestMapping("/saveReservation")
	 public String saveReservation(@Valid Reservation reservation, BindingResult bindingResult,
	 @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size",defaultValue = "2") int size)
	 {
	 int currentPage;
	 boolean isNew = false;
	 if (bindingResult.hasErrors()) return "formReservation"; 
	 if (reservation.getIdReservation()==null) //ajout
	 isNew=true;
	 reservationService.saveReservation(reservation);
	 if (isNew) //ajout
	 {
	 Page<Reservation> res = reservationService.getAllReservationsParPage(page, size);
	 currentPage = res.getTotalPages()-1;
	 }
	 else //modif
	 currentPage=page;
	 return ("redirect:/ListeReservations?page="+currentPage+"&size="+size);
	 }
	@RequestMapping("/supprimerReservation")
	public String supprimerReservation(@RequestParam("id") Long id,
	 ModelMap modelMap,
	 @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{ 
	reservationService.deleteReservationById(id);
	Page<Reservation> res = reservationService.getAllReservationsParPage(page, size);
			modelMap.addAttribute("reservations", res);
			modelMap.addAttribute("pages", new int[res.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeReservations";

	}
	 

	@RequestMapping("/updateReservation")
	public String updateReservation(@ModelAttribute("reservation") Reservation reservation, @RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateReservation= dateformat.parse(String.valueOf(date));
	 reservation.setDateReservation(dateReservation);
	 
	 reservationService.updateReservation(reservation);
	 List<Reservation> res = reservationService.getAllReservations();
	 modelMap.addAttribute("Reservations", res);
	return "listeReservations";
	}
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}


}
