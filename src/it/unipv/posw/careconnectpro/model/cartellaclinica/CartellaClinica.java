package it.unipv.posw.careconnectpro.model.cartellaclinica;

import java.time.LocalDate;
import it.unipv.posw.careconnectpro.model.persona.Persona;

public class CartellaClinica {
    
    private String idPaziente;
    private LocalDate dataCreazione;
    private Persona paziente;
//    private List<Monitoraggio> monitoraggi;
    private int idCartellaClinica;

    public CartellaClinica(Persona paziente) {
        this.paziente = paziente;
        this.idPaziente = paziente.getCodiceFiscale();
        this.dataCreazione = LocalDate.now();
//        this.monitoraggi = new ArrayList<>();
    }
    
//    public List<Monitoraggio> getMonitoraggi() {
//        return monitoraggi;
//    }
//    
//    public void setMonitoraggi(List<Monitoraggio> monitoraggi) {this.monitoraggi = monitoraggi;}
    
    public int getIdCartellaClinica() {return idCartellaClinica;}
    public void setIdCartellaClinica(int idCartellaClinica) { this.idCartellaClinica = idCartellaClinica;}
    public String getIdPaziente() {return idPaziente;}
	public void setIdPaziente(String idPaziente) {this.idPaziente = idPaziente;}
	public LocalDate getDataCreazione() {return dataCreazione;}
    public Persona getPaziente() {return paziente;}

}
