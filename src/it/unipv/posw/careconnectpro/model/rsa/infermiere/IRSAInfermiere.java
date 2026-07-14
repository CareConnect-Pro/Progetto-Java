package it.unipv.posw.careconnectpro.model.rsa.infermiere;

import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia.TerapiaDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione; // IMPORT AGGIUNTO
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public interface IRSAInfermiere {
    
    int creaMonitoraggio(Monitoraggio m); 
    List<Paziente> cercaPazienti();
    Dipendente cercaDipendenteByCf(String cf);
    Paziente cercaPazienteByCf(String cf);
    CartellaClinica cercaCartellaClinicaByCf(String cf);
    Dipendente getUtenteLoggato();
    List<Somministrazione> getSomministrazioni();
    boolean confermaSomministrazione(Somministrazione s); 
    List<TerapiaDB> getTerapieAttiveOggi();
}