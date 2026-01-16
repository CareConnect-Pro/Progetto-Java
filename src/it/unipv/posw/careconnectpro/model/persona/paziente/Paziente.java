package it.unipv.posw.careconnectpro.model.persona.paziente;

import java.time.LocalDate;

import it.unipv.posw.careconnectpro.model.persona.Persona;

public class Paziente extends Persona {

//	private PianoTerapeutico pianoPersonale;
	
	public Paziente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
			String cellulare) {
		super(codiceFiscale, nome, cognome, dataNascita, email, cellulare);
	}

}
