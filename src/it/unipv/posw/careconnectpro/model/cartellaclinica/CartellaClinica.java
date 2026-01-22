package it.unipv.posw.careconnectpro.model.cartellaclinica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.persona.Persona;

public class CartellaClinica {
    
    private String idPaziente;
    private LocalDate dataCreazione;
    private Persona paziente;
    private List<Monitoraggio> monitoraggi;
    private int idCartellaClinica;

    public CartellaClinica(Persona paziente) {
        this.paziente = paziente;
        this.idPaziente = paziente.getCodiceFiscale();
        this.dataCreazione = LocalDate.now();
        this.monitoraggi = new ArrayList<>();
    }

    public void addMonitoraggi(Monitoraggio m){
    		this.monitoraggi.add(m);
    }
    
    public List<Monitoraggio> getMonitoraggi() {
        return monitoraggi;
    }
    
    public void setMonitoraggi(List<Monitoraggio> monitoraggi) {this.monitoraggi = monitoraggi;}
	
    public void addMonitoraggio(Monitoraggio monitoraggio) {
        this.monitoraggi.add(monitoraggio);
    }
    
    public int getIdCartellaClinica() {return idCartellaClinica;}
    public void setIdCartellaClinica(int idCartellaClinica) { this.idCartellaClinica = idCartellaClinica;}
    public String getIdPaziente() {return idPaziente;}
	public void setIdPaziente(String idPaziente) {this.idPaziente = idPaziente;}
	public LocalDate getDataCreazione() {return dataCreazione;}
    public Persona getPaziente() {return paziente;}

}
