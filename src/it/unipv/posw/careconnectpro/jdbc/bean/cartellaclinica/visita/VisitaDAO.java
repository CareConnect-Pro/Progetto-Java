package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.visita;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class VisitaDAO implements IVisitaDAO {

	public VisitaDAO() {
	}
	
	@Override
	public int insertVisita (VisitaDB vDb)	{
		String query =
                "INSERT INTO VISITE" + ""
                	+ "(ID_CARTELLA_CLINICA, ID_PAZIENTE, ID_MEDICO, DATA_VISITA, NOTE, ESITO)" + ""
                			+ "VALUES (?,?,?,?,?,?)";
		try (Connection conn = ConnessioneDB.startConnection("ccp");
	    		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, vDb.getIdCartellaClinica());
            ps.setString(2, vDb.getIdPaziente());
            ps.setString(3, vDb.getIdMedico());
            ps.setDate(4, Date.valueOf(vDb.getDataVisita()));
            ps.setString(5, vDb.getNote());
            ps.setString(6, vDb.getEsito());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
	            if (rs.next()) {
	                int generatedId = rs.getInt(1);
	                vDb.setIdVisita(generatedId); 
	                return generatedId;
	            }
	        } 
	        
	        throw new SQLException("Errore: ID_CARTELLA_CLINICA non generato");
        } catch (Exception e) {
        		throw new RuntimeException(e);
        }
	}

}
