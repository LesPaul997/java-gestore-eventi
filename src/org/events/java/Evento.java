package org.events.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String title;
	private LocalDate date;
	private int seats;
	private int bookedSeats;
	
	//Costruttori
	public Evento(String title, LocalDate date, int seats) {
		this.title = title;
		this.date = date;
		
		//Controlla se la data dell'evento è passata e avvisiamo l'utente
		if (LocalDate.now().isAfter(this.date)) 
			System.out.printf("\nL'evento è già stato svolto", this);
		
		//Verificare che il numero di posti sia positivo
		if (seats <= 0) {
			System.out.printf("\nL'evento '%s' non ha posti disponibili", this);
			this.seats = 0;
		} else this.seats = seats;
		this.bookedSeats = 0;
		
	}
	
	//Getter e Setter per la variabile di istanza TITLE
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	//Getter e Setter per la variabile di istanza LOCALDATE
	public LocalDate getDate() {
		return this.date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	//Getter per la variabile di istanza SEATS
	public int getSeats() {
		return this.seats;
	}
	
	//Getter per la variabile di istanza BOOKEDSEATS
	public int getBookedSeats() {
		return this.bookedSeats;
	}
	
	
}
