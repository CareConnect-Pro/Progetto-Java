package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.somministrazione;

import java.time.LocalDateTime;

public class SomministrazioneDB {
	
    private int somministrazione;
    private int terapia;
    private String paziente;
    private String operatore;
    private LocalDateTime dataOra;
    private String stato;
    private String note;
	
    public SomministrazioneDB(int terapia, String paziente, String operatore, 
                              LocalDateTime dataOra, String stato, String note) {
        this.terapia = terapia;
        this.paziente = paziente;
        this.operatore = operatore;
        this.dataOra = dataOra;
        this.stato = stato;
        this.note = note;
    }

    public int getTerapia() { return terapia; }
    public void setTerapia(int terapia) { this.terapia = terapia; }
    public String getPaziente() { return paziente; }
    public void setPaziente(String paziente) { this.paziente = paziente; }
    public String getOperatore() { return operatore; }
    public void setOperatore(String operatore) { this.operatore = operatore; }  
    public LocalDateTime getDataOra() { return dataOra; }
    public void setDataOra(LocalDateTime dataOra) { this.dataOra = dataOra; }
    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    public int getSomministrazione() { return somministrazione; }
    public void setSomministrazione(int somministrazione) { this.somministrazione = somministrazione; }
}