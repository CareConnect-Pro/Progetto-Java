package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio;

import java.time.LocalDate;

public class MonitoraggioDB {
	
	private int idMonitoraggio;
	private int idCartellaClinica;
	private String idPaziente;
	private String idInferimere;
	private String tipoParametro;
	private String valore;
	private LocalDate dataMonitoraggio;
	private String alert;
	private String note;
	
	public MonitoraggioDB(int idCartellaClinica, String idPaziente, String idInferimere, String tipoParametro, String valore,
			LocalDate dataMonitoraggio, String alert, String note) {
		super();
		this.idCartellaClinica = idCartellaClinica;
		this.idPaziente = idPaziente;
		this.idInferimere = idInferimere;
		this.tipoParametro = tipoParametro;
		this.valore = valore;
		this.dataMonitoraggio = dataMonitoraggio;
		this.alert = alert;
		this.note = note;
	}

	public int getIdCartellaClinica() {return idCartellaClinica;}
	public String getIdInferimere() {return idInferimere;}
	public String getTipoParametro() {return tipoParametro;}
	public String getValore() {return valore;}
	public LocalDate getDataMonitoraggio() {return dataMonitoraggio;}
	public String getAlert() {return alert;}
	public String getNote() {return note;}
	public String getIdPaziente() {return idPaziente;}
	public int getIdMonitoraggio() {return idMonitoraggio;}
	public void setIdMonitoraggio(int idMonitoraggio) {this.idMonitoraggio = idMonitoraggio;}
	
}
