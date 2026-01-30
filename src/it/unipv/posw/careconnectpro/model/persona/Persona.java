package it.unipv.posw.careconnectpro.model.persona;

import java.time.LocalDate;

public abstract class Persona {

    private TipoUtente tipoUtente;
    private String codiceFiscale;
	private String nome;
	private String cognome;
	private LocalDate dataNascita, dataInizio;
	private String email;
	private String cellulare;
    private String password;
    private int stato;

	
	public Persona(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
			String cellulare, String password, TipoUtente tipoUtente, LocalDate dataInizio) {
		this.codiceFiscale = codiceFiscale;
        this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.cellulare = cellulare;
        this.password = password;
        this.tipoUtente = tipoUtente;
        this.dataInizio = dataInizio;
        this.setStato(stato);
	}

	public String getCodiceFiscale() { return codiceFiscale; }
	public String getNome() { return nome; }
	public String getCognome() { return cognome; }
	public LocalDate getDataNascita() { return dataNascita; }
	public String getEmail() { return email; }
	public String getCellulare() { return cellulare; }
    public String getPassword() {return password;}
    public TipoUtente getTipoUtente() {return tipoUtente;}
    public LocalDate getDataInizio() {return dataInizio; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public void setEmail(String email) { this.email = email; }
    public void setCellulare(String cellulare) { this.cellulare = cellulare; }
    public void setPassword(String password) { this.password = password; }
    public int getStato() {
        return stato;
    }
    public void setStato(int stato) {
        this.stato = stato;
    }
        
}