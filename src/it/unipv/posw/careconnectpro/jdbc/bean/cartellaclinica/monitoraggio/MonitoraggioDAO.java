package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	
	public List<MonitoraggioDB> selectMonitoraggioByAlertAttivo()	{
		String query = "SELECT * FROM MONITORAGGI WHERE ALERT = 'ATTIVO'";
		
		List<MonitoraggioDB> monitoraggi = new ArrayList<>();

	    try (Connection conn = ConnessioneDB.startConnection("ccp");
	         PreparedStatement ps = conn.prepareStatement(query);
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            MonitoraggioDB mDb = new MonitoraggioDB(
	                rs.getInt("ID_CARTELLA_CLINICA"),
	                rs.getString("ID_PAZIENTE"),
	                rs.getString("ID_INFERMIERE"),
	                rs.getString("TIPO_PARAMETRO"),
	                rs.getString("VALORE"),
	                rs.getDate("DATA_MONITORAGGIO").toLocalDate(),
	                rs.getString("ALERT"),
	                rs.getString("NOTE")
	            );
	            mDb.setIdMonitoraggio(rs.getInt("ID_MONITORAGGIO"));
	            monitoraggi.add(mDb);
	        }
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	    return monitoraggi;				
	}
	
	@Override
	public boolean updateAlertMonitoraggio(MonitoraggioDB mDb) {
	    String query = "UPDATE MONITORAGGI SET ALERT = 'RISOLTO', NOTE = ? WHERE ID_MONITORAGGIO = ?";
	    
	    try (Connection conn = ConnessioneDB.startConnection("ccp");
		     PreparedStatement ps = conn.prepareStatement(query);) {

	        ps.setString(1, mDb.getNote());  
	        ps.setInt(2, mDb.getIdMonitoraggio());

	        int rowsUpdated = ps.executeUpdate();
	        return rowsUpdated > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
