package it.unipv.posw.careconnectpro.model.rsa.login;

import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public interface IRSALogin {

	Dipendente login(String cf, String pw);
	Dipendente getUtenteLoggato(); 
	
}
