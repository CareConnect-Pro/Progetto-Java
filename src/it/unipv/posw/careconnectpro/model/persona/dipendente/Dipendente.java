package it.unipv.posw.careconnectpro.model.persona.dipendente;

import java.time.LocalDate;

import it.unipv.posw.careconnectpro.model.persona.Persona;

public class Dipendente extends Persona implements IDipendente {

    private static final int MAX_PASSWORD = 8;
    private static final int MIN_PASSWORD = 6;
    
	private String idDipendente;
	private String password;
	private TipoDipendente tipoDipendente;
	private LocalDate dataAssunzione;
	
	public Dipendente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
			String cellulare, String idDipendente, String password, TipoDipendente tipoDipendente, LocalDate dataAssunzione) {
		super(codiceFiscale, nome, cognome, dataNascita, email, cellulare);
		this.idDipendente = idDipendente;
		validaPassword(password);
		this.password = password;
		this.tipoDipendente = tipoDipendente;
		this.dataAssunzione = dataAssunzione;
	}

	@Override
	public String getIdDipendente() { return idDipendente; }
	public void setIdDipendente(String idDipendente) { this.idDipendente = idDipendente; }

	@Override
	public String getPassword() { return password; }
	public void setPassword(String password) {this.password = password;}

	@Override
	public TipoDipendente getTipoDipendente() { return tipoDipendente; }
	public void setTipoDipendente(TipoDipendente tipoDipendente) { this.tipoDipendente = tipoDipendente; }

	@Override
	public LocalDate getDataAssunzione() { return dataAssunzione; }
	public void setDataAssunzione(LocalDate dataAssunzione) { this.dataAssunzione = dataAssunzione; }
	
	
	private void validaPassword(String password) {
	    if (password == null)
	        throw new IllegalArgumentException("Password nulla");
	    if (password.length() < MIN_PASSWORD || password.length() > MAX_PASSWORD)
	        throw new IllegalArgumentException("Password non valida");
	}
}
