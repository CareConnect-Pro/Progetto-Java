package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public interface IResidenzaSanitariaAssistenziale {

	boolean registrazioneDipendente(Dipendente d);
	boolean rimuoviDipendente(String idDipendente);

}
