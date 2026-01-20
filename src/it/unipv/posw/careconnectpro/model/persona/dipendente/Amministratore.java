package it.unipv.posw.careconnectpro.model.persona.dipendente;

import it.unipv.posw.careconnectpro.model.persona.TipoUtente;

import java.time.LocalDate;

public class Amministratore extends Dipendente {

	public Amministratore(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
			String cellulare, String password, LocalDate dataAssunzione) {
		super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, password,
                TipoUtente.AMMINISTRATORE, dataAssunzione);
	}

}
