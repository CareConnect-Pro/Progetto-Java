package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class CartellaClinicaDAO implements ICartellaClinicaDAO {

	public CartellaClinicaDAO() {
		
	}
	
	@Override
	public boolean insertCartellaClinica (CartellaClinicaDB ccDb)	{
		String query =
                "INSERT INTO CARTELLA_CLINICA (ID_PAZIENTE, DATA_CREAZIONE) VALUES (?,?)";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, ccDb.getIdPaziente());
            ps.setDate(2, Date.valueOf(ccDb.getDataCreazione()));
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	
    @Override
    public boolean deleteCartellaClinicaByCf(String cf) {
        String query = "DELETE FROM CARTELLA_CLINICA WHERE ID_PAZIENTE = ?";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, cf);
            int deletedRows = ps.executeUpdate();
            return deletedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	
}
