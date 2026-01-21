package it.unipv.posw.careconnectpro.jdbc.bean.persona;

import java.time.LocalDate;

public class PersonaDB {
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String email;
    private String numeroTelefonico;
    private String password;
    private String ruolo;
    private LocalDate dataInizio;

    public PersonaDB(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
                     String numeroTelefonico,  String password, String ruolo, LocalDate dataInizio) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
        this.password = password;
        this.ruolo = ruolo;
        this.dataInizio = dataInizio;
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

}
