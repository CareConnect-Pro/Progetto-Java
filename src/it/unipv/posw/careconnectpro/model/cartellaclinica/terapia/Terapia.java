package it.unipv.posw.careconnectpro.model.cartellaclinica.terapia;

import java.time.LocalDate;

public class Terapia {

	private int idCartellaClinica;
	private String idMedico;
	private TipoSomministrazione tipoSomministrazione;
	private String nomeFarmaco;
	private String materiale;
	private String dosaggio;
	private int frequenzaGiornaliera;
	private StatoTerapia stato;
	private int durata;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private String note;
	
	
}


