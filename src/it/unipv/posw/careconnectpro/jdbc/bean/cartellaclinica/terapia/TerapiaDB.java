package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia;

import java.time.LocalDate;

public class TerapiaDB {

	private int idTerapia;
	private int idCartellaClinica;
	private String idPaziente;
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
	
	public TerapiaDB() {
	}


	public TerapiaDB(int idCartellaClinica, String idPaziente, String idMedico, String tipoSomministrazione, String nomeFarmaco,
			String materiale, String dosaggio, int frequenzaGiornaliera, String stato, int durata, LocalDate dataInizio,
			LocalDate dataFine, String note) {
		super();
		this.idCartellaClinica = idCartellaClinica;
		this.idPaziente = idPaziente;
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
	public String getIdPaziente() {return idPaziente;}
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
	public int getIdTerapia() {return idTerapia;}
	
	public void setIdTerapia(int idTerapia) {this.idTerapia = idTerapia;}
	public void setIdCartellaClinica(int idCartellaClinica) {this.idCartellaClinica = idCartellaClinica;}
	public void setIdPaziente(String idPaziente) {this.idPaziente = idPaziente;}
	public void setIdMedico(String idMedico) {this.idMedico = idMedico;}
	public void setTipoSomministrazione(String tipoSomministrazione) {this.tipoSomministrazione = tipoSomministrazione;}
	public void setNomeFarmaco(String nomeFarmaco) {this.nomeFarmaco = nomeFarmaco;}
	public void setMateriale(String materiale) {this.materiale = materiale;}
	public void setDosaggio(String dosaggio) {this.dosaggio = dosaggio;}
	public void setFrequenzaGiornaliera(int frequenzaGiornaliera) {this.frequenzaGiornaliera = frequenzaGiornaliera;}
	public void setStato(String stato) {this.stato = stato;}
	public void setDurata(int durata) {this.durata = durata;}
	public void setDataInizio(LocalDate dataInizio) {this.dataInizio = dataInizio;}
	public void setDataFine(LocalDate dataFine) {this.dataFine = dataFine;}
	public void setNote(String note) {this.note = note;}
	
}