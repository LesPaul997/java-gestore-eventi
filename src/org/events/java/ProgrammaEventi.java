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
	
	
	
}
