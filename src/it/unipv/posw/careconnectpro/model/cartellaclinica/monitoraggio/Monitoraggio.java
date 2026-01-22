package it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio;

import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Infermiere;

import java.time.LocalDate;

public class Monitoraggio {

    private String note;
    private String idMonitoraggio , idCartellaClinica;
    private String cfPaziente, idInfermiere;
    private final LocalDate dataRegistrazione;
    private ParametroVitale parametroVitale;
    private Alert alert;
    private Paziente paziente;
    private Dipendente dipendente;

    public  Monitoraggio( String idMonitoraggio, String idCartellaClinica, Paziente paziente , Dipendente infermiere,
                         ParametroVitale parametroVitale, Alert alert, String note) {

        this.idMonitoraggio = idMonitoraggio;
        this.idCartellaClinica = idCartellaClinica;
        this.cfPaziente = paziente.getCodiceFiscale();
        this.idInfermiere = infermiere.getCodiceFiscale();
        this.parametroVitale = parametroVitale;
        dataRegistrazione = LocalDate.now();
        this.alert = alert;
        this.note = note;
        
    }

    
    //Getter and Setter
    public ParametroVitale getParametroVitale() { return parametroVitale; }
    public void setParametroVitale(ParametroVitale parametroVitale) { this.parametroVitale = parametroVitale; }
    public String getCfPaziente() { return cfPaziente; }
    public void setCfPaziente(String cfPaziente) { this.cfPaziente = cfPaziente; }
    public String getIdInfermiere() {return idInfermiere;}
    public LocalDate getDataRegistrazione() { return dataRegistrazione; }
    public String getIdMonitoraggio() { return idMonitoraggio; }
    public Alert getAlert() { return alert; }
    public void setAlert(Alert alert) { this.alert = alert; }
    public Paziente getPaziente() { return paziente; }
    public void setPaziente(Paziente paziente) { this.paziente = paziente; }
    public Dipendente getDipendente() { return dipendente; }
    public void setDipendente(Infermiere dipendente) { this.dipendente = dipendente; }
    public void setNote(String note) { this.note = note; }
    public String getNote() { return note; }
	public String getIdCartellaClinica() { return idCartellaClinica; }
	public void setIdCartellaClinica(String idCartellaClinica) { this.idCartellaClinica = idCartellaClinica; }
	public void setIdMonitoraggio(String idMonitoraggio) { this.idMonitoraggio = idMonitoraggio; }
	public void setIdInfermiere(String idInfermiere) { this.idInfermiere = idInfermiere; }
	public void setDipendente(Dipendente dipendente) { this.dipendente = dipendente; }
    

}
