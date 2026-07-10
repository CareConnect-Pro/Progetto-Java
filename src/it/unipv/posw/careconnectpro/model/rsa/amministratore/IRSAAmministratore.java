package it.unipv.posw.careconnectpro.model.rsa.amministratore;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public interface IRSAAmministratore {
    
    boolean registraUtente(Persona p);
    boolean disattivaUtente(String cf);
    int creaCartellaClinica(CartellaClinica cc);   
    Dipendente getUtenteLoggato();
    
}