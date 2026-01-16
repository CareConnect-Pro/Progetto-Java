package it.unipv.posw.careconnectpro.model.persona.dipendente;

import java.time.LocalDate;

public class Amministratore extends Dipendente {

	public Amministratore(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
			String cellulare, String idDipendente, String password, LocalDate dataAssunzione) {
		super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, idDipendente, password, TipoDipendente.AMMINISTRATORE, dataAssunzione);
	}

}
