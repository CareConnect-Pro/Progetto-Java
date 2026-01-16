package it.unipv.posw.careconnectpro.jdbc.bean.paziente;

import java.time.LocalDate;

public class PazienteDB {

		private String codiceFiscale;
		private String nome;
		private String cognome;
		private LocalDate dataNascita;
		private String email;
		private String numTelefonoParente;
		private int pianoDegenza;
		
		public PazienteDB(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
				String numTelefonoParente, int pianoDegenza) {
			super();
			this.codiceFiscale = codiceFiscale;
			this.nome = nome;
			this.cognome = cognome;
			this.dataNascita = dataNascita;
			this.email = email;
			this.numTelefonoParente = numTelefonoParente;
			this.pianoDegenza = pianoDegenza;
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

		public String getNumTelefonoParente() { return numTelefonoParente; }
		public void setNumTelefonoParente(String numTelefonoParente) { this.numTelefonoParente = numTelefonoParente; }

		public int getPianoDegenza() { return pianoDegenza; }
		public void setPianoDegenza(int pianoDegenza) { this.pianoDegenza = pianoDegenza; }
		
}
