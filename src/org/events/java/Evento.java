package org.events.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String title;
	private LocalDate date;
	private int seats;
	private int bookedSeats;
	
	//Costruttori con eccezione
	public Evento(String title, LocalDate date, int seats) {
		
		//Controlla se la data dell'evento è passata e avvisiamo l'utente
		if (date.isBefore(LocalDate.now())) { 
			System.out.println("La data dell'evento non può essere nel passato");
			return;
		}
		//Verificare che il numero di posti sia positivo
		if (seats <= 0) {
			System.out.println("Il numero di posti totali deve essere positivo.");
			return;
		}
		
		this.title = title;
		this.date = date;
		this.seats = seats;
		this.bookedSeats = 0;
		
	}
	
	//Getter e Setter per la variabile di istanza TITLE
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	//Getter e Setter per la variabile di istanza LOCALDATE
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		if (date.isBefore(LocalDate.now())) {
			System.out.println("La data dell'evento non può essere nel passato");
			return;
		}
		this.date = date;
	}
	
	//Getter per la variabile di istanza SEATS
	public int getSeats() {
		return seats;
	}
	
	//Getter per la variabile di istanza BOOKEDSEATS
	public int getBookedSeats() {
		return bookedSeats;
	}
	
	//Metodo che restituisce la data formattata
	
	//Metodi pubblici per le prenotazioni e le disdette
	public String book() {
		if (LocalDate.now().isAfter(this.date)) {
			return "L'evento è già passato!";
		} else if (this.bookedSeats == this.seats) {
			return ("Non ci sono posti disponibili per effettuare la prenotazione");
		} else {
			this.bookedSeats++;
			return "Prenotazione effettuata con successo.";
		}
	}
	
	public String cancelReservation() {
		if (LocalDate.now().isAfter(this.date)) {
			return "L'evento è già passato!";
		} else if (this.bookedSeats == 0) {
			return "Non sono presenti posti prenotati da disdire";
		} else {
			this.bookedSeats--;
			return "Prenotazione cancellata con successo";
		}
	}
	
	//Override del metodo toString
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formatter) + " - " + title;
	}
}
