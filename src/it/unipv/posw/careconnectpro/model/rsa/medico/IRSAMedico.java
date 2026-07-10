package it.unipv.posw.careconnectpro.model.rsa.medico;

import java.util.List;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public interface IRSAMedico {
    
    int creaTerapia(Terapia t);
    List<Monitoraggio> getMonitoraggiConAlertAttivo();  
    boolean risolviAlertMonitoraggio(Monitoraggio m);  
    Monitoraggio cercaMonitoraggioById(int id);  
    Dipendente cercaDipendenteByCf(String cf); 
    Paziente cercaPazienteByCf(String cf);
    CartellaClinica cercaCartellaClinicaByCf(String cf);
    Dipendente getUtenteLoggato();
    List<Somministrazione> getSomministrazioniNonSomministrate();
    boolean confermaSomministrazione(Somministrazione s);

}