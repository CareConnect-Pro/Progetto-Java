package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia;

import java.time.LocalDate;

public class TerapiaDB {

	private int idCartellaClinica;
	private String idMedico;
	private String tipoSomministrazione;
	private String nomeFarmaco;
	private String materiale;
	private String dosaggio;
	private int frequenzaGiornaliera;
	private String stato;
	private int durata;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private String note;
	
	public TerapiaDB(int idCartellaClinica, String idMedico, String tipoSomministrazione, String nomeFarmaco,
			String materiale, String dosaggio, int frequenzaGiornaliera, String stato, int durata, LocalDate dataInizio,
			LocalDate dataFine, String note) {
		super();
		this.idCartellaClinica = idCartellaClinica;
		this.idMedico = idMedico;
		this.tipoSomministrazione = tipoSomministrazione;
		this.nomeFarmaco = nomeFarmaco;
		this.materiale = materiale;
		this.dosaggio = dosaggio;
		this.frequenzaGiornaliera = frequenzaGiornaliera;
		this.stato = stato;
		this.durata = durata;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.note = note;
	}

	public int getIdCartellaClinica() {return idCartellaClinica;}
	public String getIdMedico() {return idMedico;}
	public String getTipoSomministrazione() {return tipoSomministrazione;}
	public String getNomeFarmaco() {return nomeFarmaco;}
	public String getMateriale() {return materiale;}
	public String getDosaggio() {return dosaggio;}
	public int getFrequenzaGiornaliera() {return frequenzaGiornaliera;}
	public String getStato() {return stato;}
	public int getDurata() {return durata;}
	public LocalDate getDataInizio() {return dataInizio;}
	public LocalDate getDataFine() {return dataFine;}
	public String getNote() {return note;}
	
}
