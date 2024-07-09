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
	
	
	
}
