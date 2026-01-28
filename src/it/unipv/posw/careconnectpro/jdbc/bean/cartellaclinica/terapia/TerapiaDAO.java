package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class TerapiaDAO implements ITerapiaDAO {

	public TerapiaDAO() {
	}
	
	@Override
	public int insertTerapia (TerapiaDB tDb)	{
		String query =
                "INSERT INTO TERAPIE" + ""
                		+ "(ID_CARTELLA_CLINICA, ID_PAZIENTE, ID_MEDICO, TIPO_SOMMINISTRAZIONE, NOME_FARMACO, MATERIALE_UTILIZZATO, DOSAGGIO, FREQUENZA_GIORNALIERA, STATO, DURATA_GIORNI, DATA_INIZIO, DATA_FINE, NOTE)" 
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
	
	@Override
    public boolean deleteTerapiaById(int id) {
        String query = "DELETE FROM TERAPIE WHERE ID_TERAPIA = ?";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            int deletedRows = ps.executeUpdate();
            return deletedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
