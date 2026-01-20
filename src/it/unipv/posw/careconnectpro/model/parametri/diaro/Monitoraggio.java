package it.unipv.posw.careconnectpro.model.parametri.diaro;

import it.unipv.posw.careconnectpro.model.parametri.ParametroVitale;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

import java.time.LocalDate;

public class Monitoraggio {

    private  Paziente paziente;
    private  String note;
    private  String idMonitoraggio;
    private final LocalDate dataRegistrazione;
    private ParametroVitale parametroVitale;
    private Dipendente dipendente;
    private static final int LUNGHEZZA = 8;
    // CREARE VARIABILE ALERT CON Sì O NO


    public  Monitoraggio(String idMonitoraggio, Paziente paziente, Dipendente dipendente, ParametroVitale parametroVitale,
                         String note) {

        this.idMonitoraggio = idMonitoraggio;
        this.paziente = paziente;
        this.dipendente = dipendente;
        this.parametroVitale = parametroVitale;
        dataRegistrazione = LocalDate.now();
        this.note = note;

    }

    //Getter and Setter
    public ParametroVitale getParametroVitale() {
        return parametroVitale;
    }
    public String getStringParametroVitale() {
        return parametroVitale.toString();
    }
    public void setParametroVitale(ParametroVitale parametroVitale) {
        this.parametroVitale = parametroVitale;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    public String getIdMonitoraggio() {
        return idMonitoraggio;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }
    public Paziente getPaziente() {
        return paziente;
    }

}
