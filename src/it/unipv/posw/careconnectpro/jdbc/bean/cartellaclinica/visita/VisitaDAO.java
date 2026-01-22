package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.visita;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class VisitaDAO implements IVisitaDAO {

	public VisitaDAO() {
	}
	
	@Override
	public boolean insertVisita (VisitaDB vDb)	{
		String query =
                "INSERT INTO VISITE" + ""
                	+ "(ID_CARTELLA_CLINICA, ID_MEDICO, DATA_VISITA, NOTE, ESITO)" + ""
                			+ "VALUES (?,?,?,?,?)";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, vDb.getIdCartellaClinica());
            ps.setString(2, vDb.getIdMedico());
            ps.setDate(3, Date.valueOf(vDb.getDataVisita()));
            ps.setString(4, vDb.getNote());
            ps.setString(5, vDb.getEsito());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
