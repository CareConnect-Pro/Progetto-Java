package it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio;

import java.time.LocalDate;

import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class Monitoraggio {

//    private String cfPaziente;
//    private String idDipendente;
    private String note;
    private final String idMonitoraggio;
    private final LocalDate dataRegistrazione;
    private ParametroVitale parametroVitale;
    private Alert alert;
    private Paziente paziente;
    private Dipendente dipendente;

    public  Monitoraggio(String idMonitoraggio, Paziente paziente , Dipendente dipendente, ParametroVitale parametroVitale,
                         Alert alert, String note) {

        this.idMonitoraggio = idMonitoraggio;
        this.paziente = paziente;
        this.dipendente = dipendente;
        this.parametroVitale = parametroVitale;
        dataRegistrazione = LocalDate.now();
        this.alert = alert;
        this.note = note;

    }

    //Getter and Setter
    public ParametroVitale getParametroVitale() {
        return parametroVitale;
    }
    public void setParametroVitale(ParametroVitale parametroVitale) {
        this.parametroVitale = parametroVitale;
    }
//    public String getCfPaziente() {
//        return cfPaziente;
//    }
//    public void setCfPaziente(String cfPaziente) {
//        this.cfPaziente = cfPaziente;
//    }
//    public String getIdDipendente() {
//        return idDipendente;
//    }
//    public void setIdDipendente(String idDipendente) {
//        this.idDipendente = idDipendente;
//    }
    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }
    public String getIdMonitoraggio() {
        return idMonitoraggio;
    }
    public Alert getAlert() {
        return alert;
    }
    public void setAlert(Alert alert) {
        this.alert = alert;
    }
    public Paziente getPaziente() {
        return paziente;
    }
    public void setPaziente(Paziente paziente) {
        this.paziente = paziente;
    }
    public Dipendente getDipendente() {
        return dipendente;
    }
    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }

}