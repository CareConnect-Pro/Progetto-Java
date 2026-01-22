package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.visita.Visita;
import it.unipv.posw.careconnectpro.model.persona.Persona;

public interface IRSA {

	boolean registraUtente(Persona p);
	boolean rimuoviUtente(Persona p);
	int creaCartellaClinica(CartellaClinica cc);
	boolean rimuoviCartellaClinica(String cf);
	boolean creaVisita(Visita v);
	
	

}