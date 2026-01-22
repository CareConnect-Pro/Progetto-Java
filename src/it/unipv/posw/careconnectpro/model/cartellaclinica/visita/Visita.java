package it.unipv.posw.careconnectpro.model.cartellaclinica.visita;

import java.time.LocalDate;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class Visita {
	
	private CartellaClinica cartellaClinica;
	private Paziente paziente;
    private Dipendente medico;
    private LocalDate dataVisita;
    private String note;
    private EsitoVisita esito;

    public Visita(CartellaClinica cartellaClinica, Paziente paziente, Dipendente medico, LocalDate dataVisita, String note, EsitoVisita esito) {
        this.cartellaClinica = cartellaClinica;
        this.paziente = paziente;
        this.medico = medico;
        this.dataVisita = dataVisita;
        this.note = note;
        this.esito = esito;
    }

	public CartellaClinica getCartellaClinica() {return cartellaClinica;}
	public void setCartellaClinica(CartellaClinica cartellaClinica) {this.cartellaClinica = cartellaClinica;}
	public Paziente getPaziente() {return paziente;}
	public void setPaziente(Paziente paziente) {this.paziente = paziente;}
	public Dipendente getMedico() {return medico;}
	public void setMedico(Dipendente medico) {this.medico = medico;}
	public LocalDate getDataVisita() {return dataVisita;}
	public void setDataVisita(LocalDate dataVisita) {this.dataVisita = dataVisita;}
	public String getNote() {return note;}
	public void setNote(String note) {this.note = note;}
	public EsitoVisita getEsito() {return esito;}
	public void setEsito(EsitoVisita esito) {this.esito = esito;}

}
