package it.unipv.posw.careconnectpro.jdbc.bean.dipendente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class DipendenteDAO implements IDipendenteDAO {
	
	public DipendenteDAO	()	{
	}
	
	
	@Override
    public boolean insertDipendente(DipendenteDB d) {
        String query =
            "INSERT INTO DIPENDENTI " +
            "(CODICE_FISCALE, NOME, COGNOME, DATA_DI_NASCITA, EMAIL, NUMERO_TELEFONICO, ID_DIPENDENTE, DIPENDENTE_PASSWORD, RUOLO, DATA_INIZIO) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, d.getCodiceFiscale());
            ps.setString(2, d.getNome());
            ps.setString(3, d.getCognome());
            ps.setDate(4, Date.valueOf(d.getDataNascita()));
            ps.setString(5, d.getEmail());
            ps.setString(6, d.getNumeroTelefonico());
            ps.setString(7, d.getIdDipendente());
            ps.setString(8, d.getPassword());
            ps.setString(9, d.getRuolo());
            ps.setDate(10, Date.valueOf(d.getDataInizio()));
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	
	@Override
	public DipendenteDB selectDipendenteByCf (String cf) {
		DipendenteDB d = null;
		String query = "SELECT * FROM ccp.DIPENDENTI WHERE CODICE_FISCALE = ?";        
		try (Connection conn = ConnessioneDB.startConnection("ccp");
				PreparedStatement ps = conn.prepareStatement(query)
				){
			ps.setString(1, cf);
			try(ResultSet rs = ps.executeQuery())	{
				if (rs.next()) {
					d = new DipendenteDB(
							rs.getString("CODICE_FISCALE"),
							rs.getString("NOME"),
							rs.getString("COGNOME"),
							rs.getDate("DATA_DI_NASCITA").toLocalDate(),
							rs.getString("EMAIL"),
							rs.getString("NUMERO_TELEFONICO"),
							rs.getString("ID_DIPENDENTE"),
							rs.getString("DIPENDENTE_PASSWORD"),
							rs.getString("RUOLO"),
							rs.getDate("DATA_INIZIO").toLocalDate()
							);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}       
		return d;
	}

	
	@Override
	public boolean deleteDipendenteById(String idDipendente) {
	    String query = "DELETE FROM DIPENDENTI WHERE ID_DIPENDENTE = ?";
	    try (Connection conn = ConnessioneDB.startConnection("ccp");
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setString(1, idDipendente);
	        int deletedRows = ps.executeUpdate();
	        return deletedRows > 0; // true se almeno una riga eliminata
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
//	public List<DipendenteDB> selectAllDipendenti() {
//	List<DipendenteDB> lista = new ArrayList<>();
//	String query = "SELECT * FROM ccp.DIPENDENTI";
//	try (Connection conn = ConnessioneDB.startConnection("ccp");
//             PreparedStatement ps = conn.prepareStatement(query);
//             ResultSet rs = ps.executeQuery()) {
//        while(rs.next()) {
//        	DipendenteDB d = new DipendenteDB(
//        			rs.getString("CODICE_FISCALE"),
//        			rs.getString("NOME"),
//        			rs.getString("COGNOME"),
//        			rs.getDate("DATA_DI_NASCITA").toLocalDate(),
//        			rs.getString("EMAIL"),
//        			rs.getString("NUMERO_TELEFONICO"),
//        			rs.getString("ID_DIPENDENTE"),
//        			rs.getString("DIPENDENTE_PASSWORD"),
//        			rs.getString("RUOLO"),
//        			rs.getDate("DATA_INIZIO").toLocalDate()
//        			);
//        	lista.add(d);
//        }
//	} catch(Exception e) {
//		e.printStackTrace();
//	}
//	return lista;
//}
}

