package org.events.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String title;
		LocalDate date = null;
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
					scanner.next(); //Scartiamo l'input non valido
				}
		} while (!seatValidation);
				
		Evento evento = new Evento(title, date, seats);
		System.out.println("Evento creato: " + evento);
				
		//Prenotazioni
		System.out.print("Quante prenotazioni vuoi effettuare?");
		int reservations = scanner.nextInt();
		for (int i = 0; i < reservations; i++) {
			System.out.println(evento.book());
		}
		
		System.out.println("Posti prenotati: " + evento.getBookedSeats());
        System.out.println("Posti disponibili: " + (evento.getSeats() - evento.getBookedSeats()));
		
		//Disdette
        System.out.print("Quante disdette vuoi fare?");
        int cancelReservations = scanner.nextInt();
        	for (int i = 0; i< cancelReservations; i++) {
        		System.out.println(evento.cancelReservations());
        	}
        	
        System.out.println("Posti prenotati: " + evento.getBookedSeats());
        System.out.println("Posti disponibili: " + (evento.getSeats() - evento.getBookedSeats()));
        	
        scanner.close();
		}
		
}


