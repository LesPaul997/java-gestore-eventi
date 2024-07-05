package org.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	private LocalTime time;
	private double price;
	
	public Concerto(String title, LocalDate date, int seats, LocalTime time, double price) {
		super(title, date, seats);
		this.time = time;
		this.price = price;
	}
	
	
	
}
