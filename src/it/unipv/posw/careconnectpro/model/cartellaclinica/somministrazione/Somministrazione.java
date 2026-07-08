package it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione;

import java.time.LocalDate;
import java.time.LocalTime;

public class Somministrazione {

    private int somministrazione;
    private int terapia;
    private String paziente;
    private String operatore;
    private LocalDate data;
    private LocalTime ora;
    private StatoSomministrazione stato; 
    private String note;

    public Somministrazione(int terapia, String paziente, String operatore, LocalDate data, 
                            LocalTime ora, StatoSomministrazione stato, String note) {
        this.terapia = terapia;
        this.paziente = paziente;
        this.operatore = operatore;
        this.data = data;
        this.ora = ora;
        this.stato = stato;
        this.note = note;
    }

    public int getSomministrazione() { return somministrazione; }
    public void setSomministrazione(int somministrazione) { this.somministrazione = somministrazione; }
    public int getTerapia() { return terapia; }
    public void setTerapia(int terapia) { this.terapia = terapia; }
    public String getPaziente() { return paziente; }
    public void setPaziente(String paziente) { this.paziente = paziente; }
    public String getOperatore() { return operatore; }
    public void setOperatore(String operatore) { this.operatore = operatore; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; } 
    public LocalTime getOra() { return ora; }
    public void setOra(LocalTime ora) { this.ora = ora; }
    public StatoSomministrazione getStato() { return stato; }
    public void setStato(StatoSomministrazione stato) { this.stato = stato; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}