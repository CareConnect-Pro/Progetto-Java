package it.unipv.posw.careconnectpro.jdbc.bean.diaro;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;


import java.sql.*;


public class DiarioParametriDAO {
	
    public DiarioParametriDAO() {
	}

	public boolean insertDiarioParametri (DiarioParametriDB dpDB) {

        String sql =    "INSERT INTO DIARIO_PARAMETRI (ID_PAZIENTE) " +
                        "VALUES (?)";
        try(Connection conn = ConnessioneDB.startConnection("ccp");
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); )
        {
            ps.setString(1, dpDB.getIdPaziente());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                String id_dp = "DP" + id;

                String nQuery = "UPDATE DIARO_PARAMETRI SET ID_DP = ? WHERE ID = ?";
                PreparedStatement ps2 = conn.prepareStatement(nQuery);

                ps2.setString(1, id_dp);
                ps2.setInt(2, id);
                ps2.executeUpdate();
                return true;
           }	 	else		{
        	   			System.out.println("ID Diario Parametri non generato correttamente");
            		}           
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    //Aggiungere una select per i monitoraggi effettuati a un solo paziente
}
