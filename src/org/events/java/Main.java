package org.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		String title;
		LocalDate date = null;
		LocalTime time = null;
        double price = 0.0;
		int seats = 0;
		
		//Ciclo Do-While per l'inserimento del titolo
		do {
			System.out.print("Inserisci il titolo dell'evento: ");
			title = scanner.nextLine();
				if (title.isEmpty()) {
					System.out.println("Errore: il titolo non può essere vuoto.");
				}
		} while (title.isEmpty());
		
		//Ciclo Do-while per l'inserimento della data
		boolean valideDate = false;
		do {
            System.out.print("Inserisci la data dell'evento (dd/MM/yyyy): ");
            String dataString = scanner.nextLine();
            try {
                date = LocalDate.parse(dataString, formatter);
                if (date.isBefore(LocalDate.now())) {
                    System.out.println("Errore: La data dell'evento non può essere nel passato.");
                } else {
                    valideDate = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido.");
            }
        } while (!valideDate);
		
		// Ciclo Do-while per l'inserimento dell'orario
        boolean validTime = false;
        do {
            System.out.print("Inserisci l'orario dell'evento (HH:mm): ");
            String timeString = scanner.nextLine();
            try {
                time = LocalTime.parse(timeString, timeFormatter);
                validTime = true;
            	} catch (DateTimeParseException e) {
            		System.out.println("Formato orario non valido.");
            	}
            
        	} while (!validTime);
        
        
     // Ciclo Do-while per l'inserimento del prezzo
        boolean validPrice = false;
        do {
            System.out.print("Inserisci il prezzo del biglietto: ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price <= 0) {
                    	System.out.println("Errore: Il prezzo deve essere positivo.");
                	} else {
                		validPrice = true;
                	}
            	} else {
	                System.out.println("Errore: Inserisci un prezzo valido.");
	                scanner.next(); 
            	}
            
        	} while (!validPrice);
        
				
		//Ciclo Do-while per l'inserimento del numero totale di posti
		boolean seatValidation = false;
		do {
			System.out.print("Inserisci il numero totale di posti: ");
				if (scanner.hasNextInt()) {
					seats = scanner.nextInt();
					if (seats <= 0) {
						System.out.println("Errore: Il numero di posti totali deve essere positivo.");
					} else {
						seatValidation = true;
					}
				} else {
					System.out.println("Errore: Inserisci un numero di posti valido.");
					scanner.next();
				}
		} while (!seatValidation);
				
		 // Creazione dell'evento come Concerto
        Concerto concerto = new Concerto(title, date, time, price, seats);
        System.out.println("Concerto creato: " + concerto);
		
				
		//Prenotazioni
		System.out.print("Quante prenotazioni vuoi effettuare?");
		int reservations = scanner.nextInt();
		for (int i = 0; i < reservations; i++) {
			System.out.println(concerto.book());
		}
		
		System.out.println("Posti prenotati: " + concerto.getBookedSeats());
        System.out.println("Posti disponibili: " + (concerto.getSeats() - concerto.getBookedSeats()));
		
		//Disdette
        System.out.print("Quante disdette vuoi fare?");
        int cancelReservations = scanner.nextInt();
        for (int i = 0; i< cancelReservations; i++) {
        	System.out.println(concerto.cancelReservations());
        }
        	
        System.out.println("Posti prenotati: " + concerto.getBookedSeats());
        System.out.println("Posti disponibili: " + (concerto.getSeats() - concerto.getBookedSeats()));
        	
        scanner.close();
		}
		
}


