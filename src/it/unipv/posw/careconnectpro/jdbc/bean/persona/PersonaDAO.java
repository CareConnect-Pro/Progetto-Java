package it.unipv.posw.careconnectpro.jdbc.bean.persona;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;
import it.unipv.posw.careconnectpro.model.persona.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO  implements IPersonaDAO {

    public PersonaDAO (){
    }

    @Override
    public boolean insertPersona(PersonaDB p) {
        String query =
                "INSERT INTO UTENTI " +
                        "(CODICE_FISCALE, NOME, COGNOME, DATA_DI_NASCITA, EMAIL, NUMERO_TELEFONICO, PASSWORD_UTENTE, " +
                        "RUOLO_UTENTE, DATA_INIZIO) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, p.getCodiceFiscale());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getCognome());
            ps.setDate  (4, Date.valueOf(p.getDataNascita()));
            ps.setString(5, p.getEmail());
            ps.setString(6, p.getNumeroTelefonico());
            ps.setString(7, p.getPassword());
            ps.setString(8, p.getRuolo());
            ps.setDate  (9, Date.valueOf(p.getDataInizio()));
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public PersonaDB selectPersonaByCf(String cf) {
        PersonaDB p = null;
        String query = "SELECT * FROM ccp.UTENTI WHERE CODICE_FISCALE = ?";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, cf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new PersonaDB(
                            rs.getString("CODICE_FISCALE"),
                            rs.getString("NOME"),
                            rs.getString("COGNOME"),
                            rs.getDate("DATA_DI_NASCITA").toLocalDate(),
                            rs.getString("EMAIL"),
                            rs.getString("NUMERO_TELEFONICO"),
                            rs.getString("PASSWORD_UTENTE"),
                            rs.getString("RUOLO_UTENTE"),
                            rs.getDate("DATA_INIZIO").toLocalDate()
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }
    
    @Override
    public PersonaDB selectPersonaAttivaByCf(String cf) {
	    	PersonaDB pDb = null; 
	    	String query = "SELECT * FROM UTENTI WHERE CODICE_FISCALE = ? AND STATO = TRUE";
	    	try (Connection conn = ConnessioneDB.startConnection("ccp");
	    			PreparedStatement ps = conn.prepareStatement(query)
	    			) {
	    		ps.setString(1, cf);
	    		try (ResultSet rs = ps.executeQuery()) {
	    			if (rs.next()) {
	    				pDb = new PersonaDB(
	    						rs.getString("CODICE_FISCALE"),
	    						rs.getString("NOME"),
	    						rs.getString("COGNOME"),
	    						rs.getDate("DATA_DI_NASCITA").toLocalDate(),
	    						rs.getString("EMAIL"),
	    						rs.getString("NUMERO_TELEFONICO"),
	    						rs.getString("PASSWORD_UTENTE"),
	    						rs.getString("RUOLO_UTENTE"),
	    						rs.getDate("DATA_INIZIO").toLocalDate()
	    						);
	    			}
	    		}
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		return null;
	    	}
	    	return pDb;
    }

    
    @Override
    public List<PersonaDB> selectPazienti()	{
    		String query = "SELECT * FROM UTENTI WHERE RUOLO_UTENTE = 'PAZIENTE' ";
    		
    		List<PersonaDB> pazienti = new ArrayList<>();
    		
    		try (Connection conn = ConnessioneDB.startConnection("ccp");
    		         PreparedStatement ps = conn.prepareStatement(query);
    		         ResultSet rs = ps.executeQuery()) {
    		        while (rs.next()) {
    		            PersonaDB pDb = new PersonaDB(
    		                rs.getString("CODICE_FISCALE"),
    		                rs.getString("NOME"),
    		                rs.getString("COGNOME"),
    		                rs.getDate("DATA_DI_NASCITA").toLocalDate(),
    		                rs.getString("EMAIL"),
    		                rs.getString("NUMERO_TELEFONICO"),
    		                rs.getString("PASSWORD_UTENTE"),
    		                rs.getString("RUOLO_UTENTE"),
    		                rs.getDate("DATA_INIZIO").toLocalDate()
    		            );
    		            pDb.setIdPersona(rs.getInt("ID"));
    		            pazienti.add(pDb);
    		        }
    		    } catch (Exception e) {
    		        throw new RuntimeException(e);
    		    }
    		
    		return pazienti;
    		
    }

    @Override
    public boolean deletePersona(Persona p) {
        String query = "UPDATE UTENTI SET STATO = FALSE WHERE CODICE_FISCALE = ?";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, p.getCodiceFiscale());
            int deletedRows = ps.executeUpdate();
            return deletedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

