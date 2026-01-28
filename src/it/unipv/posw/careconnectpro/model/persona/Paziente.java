package it.unipv.posw.careconnectpro.model.persona;

import java.time.LocalDate;

public class Paziente extends Persona {
	
	private int idPaziente;

    public Paziente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
                    String cellulare, LocalDate dataInizio) {
        super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, null, TipoUtente.PAZIENTE, dataInizio);
        this.setIdPaziente(idPaziente);
    }

	public int getIdPaziente() {return idPaziente;}
	public void setIdPaziente(int idPaziente) {this.idPaziente = idPaziente;}

}