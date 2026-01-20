package it.unipv.posw.careconnectpro.jdbc.bean.diaro;

import java.time.LocalDate;

public class MonitoraggioDB {
    private String cfPaziente, note, idMonitoraggio, idDiario, paramentroVitale, idDipendente, stato, valore;
    private LocalDate dataRegistrazione;

    public MonitoraggioDB(String idMonitoraggio, String idDiario, String idDipendente, String cfPaziente,
                           String paramentroVitale, LocalDate dataRegistrazione, String stato, String valore, String note ) {
        this.idMonitoraggio = idMonitoraggio;
        this.idDiario = idDiario;
        this.idDipendente = idDipendente;
        this.cfPaziente = cfPaziente;
        this.paramentroVitale = paramentroVitale;
        this.dataRegistrazione = dataRegistrazione;
        this.stato = stato;
        this.valore = valore;
        this.note = note;
    }

    public String getCfPaziente() {
        return cfPaziente;
    }
    public void setCfPaziente(String cfPaziente) {
        this.cfPaziente = cfPaziente;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getIdMonitoraggio() {
        return idMonitoraggio;
    }
    public void setIdMonitoraggio(String idMonitoraggio) {
        this.idMonitoraggio = idMonitoraggio;
    }
    public String getParamentroVitale() {
        return paramentroVitale;
    }
    public void setParamentroVitale(String paramentroVitale) {
        this.paramentroVitale = paramentroVitale;
    }
    public String getIdDipendente() {
        return idDipendente;
    }
    public void setIdDipendente(String idDipendente) {
        this.idDipendente = idDipendente;
    }
    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }
    public void setDataRegistrazione(LocalDate dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public String getIdDiario() {
        return idDiario;
    }

    public void setIdDiario(String idDiario) {
        this.idDiario = idDiario;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }
}
