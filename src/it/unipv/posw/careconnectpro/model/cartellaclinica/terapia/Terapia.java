package it.unipv.posw.careconnectpro.model.cartellaclinica.terapia;

import java.time.LocalDate;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class Terapia {

	private CartellaClinica cartellaClinica;
	private Paziente paziente;
	private Dipendente medico;
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
	
	
	public Terapia(CartellaClinica cartellaClinica, Paziente paziente, Dipendente medico,
			TipoSomministrazione tipoSomministrazione, String nomeFarmaco, String materiale, String dosaggio,
			int frequenzaGiornaliera, StatoTerapia stato, int durata, LocalDate dataInizio, LocalDate dataFine,
			String note) {
		super();
		this.cartellaClinica = cartellaClinica;
		this.paziente = paziente;
		this.medico = medico;
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

	
	public CartellaClinica getCartellaClinica() {return cartellaClinica;}
	public void setIdCartellaClinica(CartellaClinica cartellaClinica) {this.cartellaClinica = cartellaClinica;}
	public Paziente getPaziente() {return paziente;}
	public void setPaziente(Paziente paziente) {this.paziente = paziente;}
	public Dipendente getMedico() {return medico;}
	public void setMedico(Dipendente medico) {this.medico = medico;}
	public TipoSomministrazione getTipoSomministrazione() {return tipoSomministrazione;}
	public void setTipoSomministrazione(TipoSomministrazione tipoSomministrazione) {this.tipoSomministrazione = tipoSomministrazione;}
	public String getNomeFarmaco() {return nomeFarmaco;}
	public void setNomeFarmaco(String nomeFarmaco) {this.nomeFarmaco = nomeFarmaco;}
	public String getMateriale() {return materiale;}
	public void setMateriale(String materiale) {this.materiale = materiale;}
	public String getDosaggio() {return dosaggio;}
	public void setDosaggio(String dosaggio) {this.dosaggio = dosaggio;}
	public int getFrequenzaGiornaliera() {return frequenzaGiornaliera;}
	public void setFrequenzaGiornaliera(int frequenzaGiornaliera) {this.frequenzaGiornaliera = frequenzaGiornaliera;}
	public StatoTerapia getStato() {return stato;}
	public void setStato(StatoTerapia stato) {this.stato = stato;}
	public int getDurata() {return durata;}
	public void setDurata(int durata) {this.durata = durata;}
	public LocalDate getDataInizio() {return dataInizio;}
	public void setDataInizio(LocalDate dataInizio) {this.dataInizio = dataInizio;}
	public LocalDate getDataFine() {return dataFine;}
	public void setDataFine(LocalDate dataFine) {this.dataFine = dataFine;}
	public String getNote() {return note;}
	public void setNote(String note) {this.note = note;}
	
}


