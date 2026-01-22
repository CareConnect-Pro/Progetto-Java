package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class MonitoraggioDAO implements IMonitoraggioDAO {

	public MonitoraggioDAO() {
	}
	
	@Override
	public int insertMonitoraggio (MonitoraggioDB mDb)	{
		String query =
                "INSERT INTO MONITORAGGI" + ""
                		+ "(ID_CARTELLA_CLINICA, ID_PAZIENTE, ID_INFERMIERE, TIPO_PARAMETRO, VALORE, DATA_MONITORAGGIO, ALERT, NOTE)" 
                		+ "VALUES (?,?,?,?,?,?,?,?)";
		try (Connection conn = ConnessioneDB.startConnection("ccp");
	    		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, mDb.getIdCartellaClinica());
            ps.setString(2, mDb.getIdPaziente());
            ps.setString(3, mDb.getIdInferimere());
            ps.setString(4, mDb.getTipoParametro());
            ps.setString(5, mDb.getValore());
            ps.setDate(6, Date.valueOf(mDb.getDataMonitoraggio()));
            ps.setString(7, mDb.getAlert());
            ps.setString(8, mDb.getNote());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
	            if (rs.next()) {
	                int generatedId = rs.getInt(1);
	                mDb.setIdMonitoraggio(generatedId); 
	                return generatedId;
	            }
	        } 
	        
	        throw new SQLException("Errore: ID_CARTELLA_CLINICA non generato");
        } catch (Exception e) {
        		throw new RuntimeException(e);
        }
	}

}
