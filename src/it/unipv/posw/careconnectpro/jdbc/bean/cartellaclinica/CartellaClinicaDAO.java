package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class CartellaClinicaDAO implements ICartellaClinicaDAO {

	public CartellaClinicaDAO() {
		
	}
	
	@Override
	public int insertCartellaClinica(CartellaClinicaDB ccDb) {

	    String query =
	        "INSERT INTO CARTELLA_CLINICA (ID_PAZIENTE, DATA_CREAZIONE) VALUES (?, ?)";

	    try (Connection conn = ConnessioneDB.startConnection("ccp");
	         PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	             
	        ps.setString(1, ccDb.getIdPaziente());
	        ps.setDate(2, Date.valueOf(ccDb.getDataCreazione()));
	        ps.executeUpdate();

	        try (ResultSet rs = ps.getGeneratedKeys()) {
	            if (rs.next()) {
	                int generatedId = rs.getInt(1);
	                ccDb.setIdCartellaClinica(generatedId); 
	                return generatedId;
	            }
	        } 
	        
	        throw new SQLException("Errore: ID_CARTELLA_CLINICA non generato");

	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
    
    @Override
    public CartellaClinicaDB selectCartellaClinicaByCf(String cf)	{
        CartellaClinicaDB ccDb = null;
        String query = "SELECT * FROM ccp.CARTELLA_CLINICA WHERE ID_PAZIENTE = ?";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, cf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ccDb = new CartellaClinicaDB(
                            rs.getString("ID_PAZIENTE"),
                            rs.getDate("DATA_CREAZIONE").toLocalDate()
                    );
                    ccDb.setIdCartellaClinica(rs.getInt("ID_CARTELLA_CLINICA"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ccDb;
    }

	
}
