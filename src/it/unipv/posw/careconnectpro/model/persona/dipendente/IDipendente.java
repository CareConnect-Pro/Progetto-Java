package it.unipv.posw.careconnectpro.model.persona.dipendente;

import java.time.LocalDate;

public interface IDipendente {
	String getIdDipendente();
    String getPassword();
    TipoDipendente getTipoDipendente();
    LocalDate getDataAssunzione();
}
