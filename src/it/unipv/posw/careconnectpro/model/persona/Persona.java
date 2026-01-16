package it.unipv.posw.careconnectpro.model.persona;

import java.time.LocalDate;

public abstract class Persona {

	private String codiceFiscale;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String email;
	private String cellulare;
	
	public Persona(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
			String cellulare) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.cellulare = cellulare;
	}

	public String getCodiceFiscale() { return codiceFiscale; }
	public void setCodiceFiscale(String codiceFiscale) { this.codiceFiscale = codiceFiscale; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getCognome() { return cognome; }
	public void setCognome(String cognome) { this.cognome = cognome; }

	public LocalDate getDataNascita() { return dataNascita; }
	public void setDataNascita(LocalDate dataNascita) { this.dataNascita = dataNascita; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getCellulare() { return cellulare; }
	public void setCellulare(String cellulare) { this.cellulare = cellulare; }
		
}
