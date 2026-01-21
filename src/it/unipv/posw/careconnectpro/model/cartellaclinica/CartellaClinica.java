package it.unipv.posw.careconnectpro.model.cartellaclinica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.persona.Persona;

public class CartellaClinica {
    private String idCartellaClinica;
    private String idPaziente;
    private LocalDate dataCreazione;
    private Persona p;
    private List<Monitoraggio> monitoraggi;
    

    public CartellaClinica() {
        this.idCartellaClinica = idCartellaClinica;
        this.idPaziente = idPaziente;
        setDataCreazione(dataCreazione);
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
    
    public String getIdCartellaClinica() {return idCartellaClinica;}
    public void setIdCartellaClinica(String idCartellaClinica) { this.idCartellaClinica = idCartellaClinica;}
    public String getIdPaziente() {return idPaziente;}
	public void setIdPaziente(String idPaziente) {this.idPaziente = idPaziente;}
	public LocalDate getDataCreazione() {return dataCreazione;}
	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = p.getDataInizio();}
	
}
