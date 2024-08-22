package org.events.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
	private String title;
	private List<Evento> eventi;
	
	//Costruttore che inizializza il titolo e la lista degli eventi
	public ProgrammaEventi(String title) {
		this.title = title;
		this.eventi = new ArrayList<>();
	}
	
	//Metodo che aggiunge un evento alla lista
	public void addEvento(Evento evento) {
		this.eventi.add(evento);
	}
	
	//Metodo che restituisce una lista con tutti gli eventi presenti in una certa data
	public List<Evento> getEventiByDate(LocalDate date) {
		List<Evento> eventiByDate = new ArrayList<>();
			for (Evento evento : this.eventi) {
				if (evento.getDate().equals(date)) {
					eventiByDate.add(evento);
				}
			}
			return eventiByDate;
	}
	
	//Metodo che restituisce quanti eventi sono presenti nel programma
	public int getNumberOfEvents() {
		return this.eventi.size();
	}
	
	//Metodo che svuota la lista di eventi
	public void clearEvents() {
		this.eventi.clear();
	}
	
	//Metodo che restituisce una stringa che mostra il titolo del programma e tutti gli eventi ordinati per data
	public String getOrderedProgram() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.title).append("\n");
		
		List<Evento>  orderedEvents = new ArrayList<>(this.eventi);
		Collections.sort(orderedEvents, Comparator.comparing(Evento::getDate));
			for (Evento evento : orderedEvents) {
				sb.append(evento.toString()).append("\n");
			}
			return sb.toString();
	}
}
