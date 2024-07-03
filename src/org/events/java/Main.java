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
				
				
				
				
				
		}
		
}


