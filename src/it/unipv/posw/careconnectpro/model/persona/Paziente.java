package it.unipv.posw.careconnectpro.model.persona;

import java.time.LocalDate;

public class Paziente extends Persona {

    public Paziente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
                    String cellulare, LocalDate dataInizio) {
        super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, null, TipoUtente.PAZIENTE, dataInizio);
    }

}