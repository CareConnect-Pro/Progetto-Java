package it.unipv.posw.careconnectpro.model.persona.dipendente;

import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;

import java.time.LocalDate;

public abstract class Dipendente extends Persona{

    private static final int MAX_PASSWORD = 8;

	public Dipendente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
                      String cellulare, String password, TipoUtente tipoUtente, LocalDate dataAssunzione) {
		super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, password, tipoUtente, dataAssunzione);
        setPassword(password);
	}

    public void setPassword(String password) {
        if (password != null && password.length() > MAX_PASSWORD) {
            throw new IllegalArgumentException( "La password supera gli "+ MAX_PASSWORD +" caratteri massimi consentiti");
        }
    }
}

