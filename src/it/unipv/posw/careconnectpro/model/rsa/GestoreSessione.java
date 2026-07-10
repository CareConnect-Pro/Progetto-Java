package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class GestoreSessione {
    
    private static GestoreSessione istanza;
    private Dipendente utenteLoggato = null;

    private GestoreSessione() {}

    public static synchronized GestoreSessione getIstanza() {
        if (istanza == null) {
            istanza = new GestoreSessione();
        }
        return istanza;
    }

    public Dipendente getUtenteLoggato() { 
        return utenteLoggato; 
    }
    
    public void setUtenteLoggato(Dipendente utenteLoggato) { 
        this.utenteLoggato = utenteLoggato; 
    }
}