package it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

import java.time.LocalDate;

public class Monitoraggio {

	private CartellaClinica cartellaClinica;
	private Paziente paziente;
	private Dipendente infermiere;
	private TipiParametroVitale tipiParametroVitale;
	private String valore;
	private LocalDate dataMonitoraggio;
	private Alert alert;
	private String note;

    public  Monitoraggio(CartellaClinica cartellaClinica, Paziente paziente , Dipendente infermiere,
                         TipiParametroVitale tipiParametroVitale, String valore, LocalDate dataMonitoraggio, 
                         Alert alert, String note) {

        this.cartellaClinica = cartellaClinica;
        this.paziente = paziente;
        this.infermiere = infermiere;
        this.tipiParametroVitale = tipiParametroVitale;
        this.valore = valore;
        this.dataMonitoraggio = LocalDate.now();
        this.alert = alert;
        this.note = note;      
    }

	public CartellaClinica getCartellaClinica() {return cartellaClinica;}
	public void setCartellaClinica(CartellaClinica cartellaClinica) {this.cartellaClinica = cartellaClinica;}
	public Paziente getPaziente() {return paziente;}
	public void setPaziente(Paziente paziente) {this.paziente = paziente;}
	public Dipendente getInfermiere() {return infermiere;}
	public void setInfermiere(Dipendente infermiere) {this.infermiere = infermiere;}
	public TipiParametroVitale getTipiParametroVitale() {return tipiParametroVitale;}
	public void setTipiParametroVitale(TipiParametroVitale tipiParametroVitale) {this.tipiParametroVitale = tipiParametroVitale;}
	public String getValore() {return valore;}
	public void setValore(String valore) {this.valore = valore;}
	public LocalDate getDataMonitoraggio() {return dataMonitoraggio;}
	public void setDataMonitoraggio(LocalDate dataMonitoraggio) {this.dataMonitoraggio = dataMonitoraggio;}
	public Alert getAlert() {return alert;}
	public void setAlert(Alert alert) {this.alert = alert;}
	public String getNote() {return note;}
	public void setNote(String note) {this.note = note;}

}
