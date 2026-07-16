package it.unipv.posw.careconnectpro.model.rsa.login;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;

public class LoginService implements IRSALogin {

    private FacadeSingletonDB facadeDB = FacadeSingletonDB.getIstanza();

    @Override
    public Dipendente login(String cf, String password) {
        Dipendente d = facadeDB.findDipendenteAttivoByCf(cf);
        
        if (d == null) {
            System.out.println("Utente non trovato");
            return null;
        }
        
        if (d.getPassword().equals(password)) {
            GestoreSessione.getIstanza().setUtenteLoggato(d);
            System.out.println("Login Dipendente avvenuto con successo: " + d.getCodiceFiscale());
            return d;
        }
        
        System.out.println("Password errata");
        return null;
    }

    @Override
    public Dipendente getUtenteLoggato() {
        return GestoreSessione.getIstanza().getUtenteLoggato();
    }
}

