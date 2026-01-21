package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class TerapiaDAO implements ITerapiaDAO {

	public TerapiaDAO() {
	}
	
	@Override
	public boolean insertTerapia (TerapiaDB tDb)	{
		String query =
                "INSERT INTO TERAPIE" + ""
                		+ "(ID_CARTELLA_CLINICA, ID_MEDICO, TIPO_SOMMINISTRAZIONE, NOME_FARMACO, MATERIALE_UTILIZZATO, DOSAGGIO, FREQUENZA_GIONALIERA, STATO, DURATA_GIORNI, DATA_INIZIO, DATA_FINE, NOTE)" 
                		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, tDb.getIdCartellaClinica());
            ps.setString(2, tDb.getIdMedico());
            ps.setString(3, tDb.getTipoSomministrazione());
            ps.setString(4, tDb.getNomeFarmaco());
            ps.setString(5, tDb.getMateriale());
            ps.setString(6, tDb.getDosaggio());
            ps.setInt(7, tDb.getFrequenzaGiornaliera());
            ps.setString(8, tDb.getStato());
            ps.setInt(9, tDb.getDurata());
            ps.setDate(10, Date.valueOf(tDb.getDataInizio()));
            ps.setDate(11, Date.valueOf(tDb.getDataFine()));
            ps.setString(12, tDb.getNote());

            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

}
