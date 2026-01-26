package it.unipv.posw.careconnectpro.model.persona;

import java.time.LocalDate;

public class Paziente extends Persona {

    public Paziente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
<<<<<<< HEAD
                    String cellulare, LocalDate dataInizio) {
=======
                    String cellulare,String password, LocalDate dataInizio) {
>>>>>>> branch 'master' of https://github.com/CareConnect-Pro/Progetto-Java.git
        super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, null, TipoUtente.PAZIENTE, dataInizio);
    }

}