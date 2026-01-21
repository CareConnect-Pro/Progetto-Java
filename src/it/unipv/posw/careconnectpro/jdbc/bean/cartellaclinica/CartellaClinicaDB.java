package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica;

import java.time.LocalDate;

public class CartellaClinicaDB {
	
	private String idPaziente;
	private LocalDate dataCreazione;
	
	public CartellaClinicaDB(String idPaziente, LocalDate dataCreazione) {
		super();
		this.idPaziente = idPaziente;
		this.dataCreazione = dataCreazione;
	}

	public String getIdPaziente() {return idPaziente;}
	public LocalDate getDataCreazione() {return dataCreazione;}

}
