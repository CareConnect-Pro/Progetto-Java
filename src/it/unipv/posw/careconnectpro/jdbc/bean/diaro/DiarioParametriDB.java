package it.unipv.posw.careconnectpro.jdbc.bean.diaro;

public class DiarioParametriDB {
	
	private String idDiarioParametri;
	private String idPaziente;
	
	public DiarioParametriDB(String idDiarioParametri, String idPaziente) {
		super();
		this.idDiarioParametri = idDiarioParametri;
		this.idPaziente = idPaziente;
	}

	public String getIdDiarioParametri() {return idDiarioParametri;}
	public void setIdDiarioParametri(String idDiarioParametri) {this.idDiarioParametri = idDiarioParametri;}

	public String getIdPaziente() {return idPaziente;}
	public void setIdPaziente(String idPaziente) {this.idPaziente = idPaziente;}
	
}
