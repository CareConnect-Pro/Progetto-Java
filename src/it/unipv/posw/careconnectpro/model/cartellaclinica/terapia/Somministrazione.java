package it.unipv.posw.careconnectpro.model.cartellaclinica.terapia;

import java.time.LocalDate;
import java.time.LocalTime;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class Somministrazione {

    private int idSomministrazione;
    private Terapia terapia;
    private Dipendente esecutore;
    private LocalDate data;
    private LocalTime ora;
    private StatoSomministrazione stato;
    private String note;

    public Somministrazione(Terapia terapia, Dipendente esecutore, LocalDate data, 
                            LocalTime ora, StatoSomministrazione stato, String note) {
        this.terapia = terapia;
        this.esecutore = esecutore;
        this.data = data;
        this.ora = ora;
        this.stato = stato;
        this.note = note;
    }

    public int getIdSomministrazione() { return idSomministrazione; }
    public void setIdSomministrazione(int idSomministrazione) { this.idSomministrazione = idSomministrazione; }
    public Terapia getTerapia() { return terapia; }
    public void setTerapia(Terapia terapia) { this.terapia = terapia; }
    public Dipendente getEsecutore() { return esecutore; }
    public void setEsecutore(Dipendente esecutore) { this.esecutore = esecutore; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public LocalTime getOra() { return ora; }
    public void setOra(LocalTime ora) { this.ora = ora; }
    public StatoSomministrazione getStato() { return stato; }
    public void setStato(StatoSomministrazione stato) { this.stato = stato; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}