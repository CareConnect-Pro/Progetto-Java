package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class MonitoraggioDAO implements IMonitoraggioDAO {

	public MonitoraggioDAO() {
	}
	
	@Override
	public boolean insertMonitoraggio (MonitoraggioDB mDb)	{
		String query =
                "INSERT INTO MONITORAGGI" + ""
                		+ "(ID_CARTELLA_CLINICA, ID_INFERMIERE, TIPO_PARAMETRO, VALORE, DATA_MONITORAGGIO, ALERT, NOTE)" 
                		+ "VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, mDb.getIdCartellaClinica());
            ps.setString(2, mDb.getIdInferimere());
            ps.setString(3, mDb.getTipoParametro());
            ps.setString(4, mDb.getValore());
            ps.setDate(5, Date.valueOf(mDb.getDataMonitoraggio()));
            ps.setString(6, mDb.getAlert());
            ps.setString(7, mDb.getNote());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}


}
