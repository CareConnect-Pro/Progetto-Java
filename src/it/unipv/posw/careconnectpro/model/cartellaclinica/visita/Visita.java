package it.unipv.posw.careconnectpro.model.cartellaclinica.visita;

import java.time.LocalDate;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Persona;

public class Visita {
	
	private int idCartellaClinica;
    private String idMedico;
    private LocalDate dataVisita;
    private String note;
    private EsitoVisita esito;

    public Visita(CartellaClinica cartellaClinica, Persona medico, LocalDate dataVisita, String note, EsitoVisita esito) {
        this.idCartellaClinica = cartellaClinica.getIdCartellaClinica();
        this.idMedico = medico.getCodiceFiscale();
        this.dataVisita = dataVisita;
        this.note = note;
        this.esito = esito;
    }

	public int getIdCartellaClinica() {return idCartellaClinica;}
	public String getIdMedico() {return idMedico;}
	public LocalDate getDataVisita() {return dataVisita;}
	public void setDataVisita(LocalDate dataVisita) {this.dataVisita = dataVisita;}
	public String getNote() {return note;}
	public void setNote(String note) {this.note = note;}
	public EsitoVisita getEsito() {return esito;}
	public void setEsito(EsitoVisita esito) {this.esito = esito;}

}
