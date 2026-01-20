package it.unipv.posw.careconnectpro.jdbc.bean.diaro;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;
import it.unipv.posw.careconnectpro.model.parametri.diaro.Monitoraggio;
import it.unipv.posw.careconnectpro.model.persona.Paziente;

import java.sql.*;


public class DiarioParametriDAO {

    public boolean insert(Paziente paziente, Monitoraggio monitoraggio) throws SQLException {



        String sql =    "INSERT INTO DIARIO_PARAMETRI (ID_PAZIANTE) " +
                        "VALUES (?)";
        try(Connection conn = ConnessioneDB.startConnection("cpp");
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); )
        {
            ps.setString(1, paziente.getCodiceFiscale());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                String id_diario= "DP" + id;

                String nQuery = "UPDATE DIARO_PARAMETRI SET ID_DIARIO_PARAMETRI = ? WHERE ID = ?";
                PreparedStatement ps2 = conn.prepareStatement(nQuery);

                ps2.setString(1, id_diario);
                ps2.setInt(2, id);
                ps2.executeUpdate();
                return true;
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
