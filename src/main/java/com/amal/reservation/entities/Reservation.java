package com.amal.reservation.entities;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservation;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomClient;
	@Min(value = 10)
	 @Max(value = 10000)

	private Double prixSejour;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateReservation;
	
	@ManyToOne
	private Type type;

	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Reservation(String nomClient, Double prixSejour, Date dateReservation) {
		super();
		this.nomClient = nomClient;
		this.prixSejour = prixSejour;
		this.dateReservation = dateReservation;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Double getPrixSejour() {
		return prixSejour;
	}
	public void setPrixSejour(Double prixSejour) {
		this.prixSejour = prixSejour;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", nomClient=" + nomClient + ", prixSejour=" + prixSejour
				+ ", dateReservation=" + dateReservation + "]";
	}
	




}
