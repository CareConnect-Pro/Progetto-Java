package it.unipv.posw.careconnectpro.model.rsa;

import java.util.List;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.persona.Persona;

public interface IRSA {

	boolean registraUtente(Persona p);
	boolean rimuoviUtente(Persona p);
	int creaCartellaClinica(CartellaClinica cc);
	int creaTerapia(Terapia t);
	int creaMonitoraggio(Monitoraggio m);
	List<Monitoraggio> getMonitoraggiConAlertAttivo();
	boolean risolviAlertMonitoraggio(Monitoraggio m);
	
}

