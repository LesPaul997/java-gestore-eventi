package org.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	private LocalTime time;
	private double price;
	
	//Costruttore
	public Concerto(String title, LocalDate date, int seats, LocalTime time, double price) {
		super(title, date, seats);
		this.time = time;
		this.price = price;
	}
	
	//Getter e Setter per la variabile TIME
	public LocalTime getTime() {
		return time;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	//Getter e Setter per la variabile PRICE
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	//Formattazione DATA e ORA
	public String getFormattedDateAndTime() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return getDate().format(dateFormatter) + " " + time.format(timeFormatter);
	}
	
	//Formattazione PRICE
	public String getFormattedPrice() {
		return String.format("%.2f€", price);
	}
	
	@Override
	public String toString() {
		return getFormattedDateAndTime() + " - " + getTitle() + " - " + getFormattedPrice();
	}
	
}
