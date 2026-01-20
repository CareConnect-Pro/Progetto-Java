package it.unipv.posw.careconnectpro.model.persona.dipendente;

import it.unipv.posw.careconnectpro.model.persona.TipoUtente;

import java.time.LocalDate;

public class Infermiere extends Dipendente {

	public Infermiere(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
			String cellulare, String password, LocalDate dataAssunzione) {
		super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, password, TipoUtente.INFERMIERE, dataAssunzione);
	}

}
