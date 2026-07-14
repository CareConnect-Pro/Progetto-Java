package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class TerapiaDAO implements ITerapiaDAO {

	public TerapiaDAO() {
	}
	
	@Override
	public int insertTerapia(TerapiaDB tDb) {
		String query =
                "INSERT INTO TERAPIE"
                		+ "(ID_CARTELLA_CLINICA, ID_PAZIENTE, ID_MEDICO, TIPO_SOMMINISTRAZIONE, NOME_FARMACO, MATERIALE_UTILIZZATO, DOSAGGIO, FREQUENZA_GIORNALIERA, STATO, DURATA_GIORNI, DATA_INIZIO, DATA_FINE, NOTE) " 
                		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    try (Connection conn = ConnessioneDB.startConnection("ccp");
	    		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, tDb.getIdCartellaClinica());
            ps.setString(2, tDb.getIdPaziente());
            ps.setString(3, tDb.getIdMedico());
            ps.setString(4, tDb.getTipoSomministrazione());
            ps.setString(5, tDb.getNomeFarmaco());
            ps.setString(6, tDb.getMateriale());
            ps.setString(7, tDb.getDosaggio());
            ps.setInt(8, tDb.getFrequenzaGiornaliera());
            ps.setString(9, tDb.getStato());
            ps.setInt(10, tDb.getDurata());
            ps.setDate(11, Date.valueOf(tDb.getDataInizio()));
            ps.setDate(12, Date.valueOf(tDb.getDataFine()));
            ps.setString(13, tDb.getNote());

            ps.executeUpdate();

	        try (ResultSet rs = ps.getGeneratedKeys()) {
	            if (rs.next()) {
	                int generatedId = rs.getInt(1);
	                tDb.setIdTerapia(generatedId); 
	                return generatedId;
	            }
	        } 
	        
	        throw new SQLException("Errore: ID_CARTELLA_CLINICA non generato");
        } catch (Exception e) {
        		throw new RuntimeException(e);
        }
	}
	
	public List<TerapiaDB> getTerapieAttiveOggi() {
		List<TerapiaDB> terapieDiOggi = new ArrayList<>();
		String query = "SELECT * FROM TERAPIE WHERE STATO = 'PREVISTA' AND ? BETWEEN DATA_INIZIO AND DATA_FINE";
		
		try (Connection conn = ConnessioneDB.startConnection("ccp");
			 PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setDate(1, Date.valueOf(LocalDate.now()));
			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					TerapiaDB tDb = new TerapiaDB();
					
					tDb.setIdTerapia(rs.getInt("ID_TERAPIA")); 
					tDb.setIdCartellaClinica(rs.getInt("ID_CARTELLA_CLINICA"));
					tDb.setIdPaziente(rs.getString("ID_PAZIENTE"));
					tDb.setIdMedico(rs.getString("ID_MEDICO"));
					tDb.setTipoSomministrazione(rs.getString("TIPO_SOMMINISTRAZIONE"));
					tDb.setNomeFarmaco(rs.getString("NOME_FARMACO"));
					tDb.setMateriale(rs.getString("MATERIALE_UTILIZZATO"));
					tDb.setDosaggio(rs.getString("DOSAGGIO"));
					tDb.setFrequenzaGiornaliera(rs.getInt("FREQUENZA_GIORNALIERA"));
					tDb.setStato(rs.getString("STATO"));
					tDb.setDurata(rs.getInt("DURATA_GIORNI"));
					tDb.setDataInizio(rs.getDate("DATA_INIZIO").toLocalDate());
					tDb.setDataFine(rs.getDate("DATA_FINE").toLocalDate());
					tDb.setNote(rs.getString("NOTE"));
					
					terapieDiOggi.add(tDb);
				}
			}
		} catch (SQLException e) {
			System.err.println("Errore nel recupero delle terapie odierne.");
			e.printStackTrace();
		}
		
		return terapieDiOggi;
	}

}