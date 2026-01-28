package it.unipv.posw.careconnectpro.model.rsa;

import java.util.List;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public interface IRSA {

	boolean registraUtente(Persona p);
	boolean rimuoviUtente(String cf);
	int creaCartellaClinica(CartellaClinica cc);
	boolean rimuoviCartellaClinica(String cf);
	int creaTerapia(Terapia t);
	int creaMonitoraggio(Monitoraggio m);
	List<Monitoraggio> getMonitoraggiConAlertAttivo();
	boolean risolviAlertMonitoraggio(Monitoraggio m);
    Monitoraggio cercaMonitoraggioById(int id);
    Persona getUtenteLoggato();
    Dipendente cercaDipendenteByCf(String cf);
    Paziente cercaPazienteByCf(String cf);
    CartellaClinica cercaCartellaClinicaByCf(String cf);
	
}


