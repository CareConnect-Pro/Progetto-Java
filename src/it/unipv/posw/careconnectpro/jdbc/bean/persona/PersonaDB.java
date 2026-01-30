package it.unipv.posw.careconnectpro.jdbc.bean.persona;

import java.time.LocalDate;

public class PersonaDB {
	
	private int idPersona;
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String email;
    private String numeroTelefonico;
    private String password;
    private String ruolo;
    private LocalDate dataInizio;
    private int stato;
    

    public PersonaDB(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
                     String numeroTelefonico,  String password, String ruolo, LocalDate dataInizio) {
        this.setIdPersona(idPersona);
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
        this.password = password;
        this.ruolo = ruolo;
        this.dataInizio = dataInizio;
        this.setStato(stato);
    }

    public String getCodiceFiscale() {return codiceFiscale;}
    public String getNome() {return nome;}
    public String getCognome() {return cognome;}
    public LocalDate getDataNascita() {return dataNascita;}
    public String getEmail() {return email;}
    public String getNumeroTelefonico() {return numeroTelefonico;}
    public String getPassword() {return password;}
    public String getRuolo() {return ruolo;}
    public LocalDate getDataInizio() {return dataInizio;}

	public int getIdPersona() {return idPersona;}
	public void setIdPersona(int idPersona) {this.idPersona = idPersona;}
    public int getStato() {
        return stato;
    }
    public void setStato(int stato) {
        this.stato = stato;
    }
}
