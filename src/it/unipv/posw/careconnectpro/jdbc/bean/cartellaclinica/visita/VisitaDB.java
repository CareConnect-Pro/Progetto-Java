package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.visita;

import java.time.LocalDate;

public class VisitaDB {
	
	private int idVisita;
	private int idCartellaClinica;
	private String idPaziente;
	private String idMedico;
	private LocalDate dataVisita;
	private String note;
	private String esito;
	
	public VisitaDB(int idCartellaClinica, String idPaziente, String idMedico, LocalDate dataVisita, String note, String esito) {
		super();
		this.idCartellaClinica = idCartellaClinica;
		this.idPaziente = idPaziente;
		this.idMedico = idMedico;
		this.dataVisita = dataVisita;
		this.note = note;
		this.esito = esito;
	}

	public int getIdCartellaClinica() {return idCartellaClinica;}
	public String getIdMedico() {return idMedico;}
	public LocalDate getDataVisita() {return dataVisita;}
	public String getNote() {return note;}
	public String getEsito() {return esito;}
	public String getIdPaziente() {return idPaziente;}
	public int getIdVisita() {return idVisita;}
	public void setIdVisita(int idVisita) {this.idVisita = idVisita;}
	
}
