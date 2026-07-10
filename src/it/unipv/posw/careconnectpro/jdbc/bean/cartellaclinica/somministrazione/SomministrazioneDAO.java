package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.somministrazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class SomministrazioneDAO implements ISomministrazioneDAO {

	public SomministrazioneDAO() {
		
	}

	@Override
	public int insertSomministrazione(SomministrazioneDB sDb) {
		String query = 
				"INSERT INTO SOMMINISTRAZIONI" + " "
				+ "(ID_TERAPIA, ID_PAZIENTE, ID_OPERATORE, DATA_ORA, STATO, NOTE)" + " "
				+ "VALUES (?,?,?,?,?,?)";
		
		try (Connection conn = ConnessioneDB.startConnection("ccp");
			 PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			ps.setInt(1, sDb.getTerapia());
			ps.setString(2, sDb.getPaziente());
			ps.setString(3, sDb.getOperatore());
			ps.setTimestamp(4, Timestamp.valueOf(sDb.getDataOra()));
			ps.setString(5, sDb.getStato());
			ps.setString(6, sDb.getNote());
			
			ps.executeUpdate();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					int generatedId = rs.getInt(1);
					sDb.setSomministrazione(generatedId);
					return generatedId;
				}
			}
			
			throw new SQLException("Errore: ID_SOMMINISTRAZIONE non generato");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public List<SomministrazioneDB> selectSomministrazioniByPaziente(String cfPaziente) {
		String query = "SELECT * FROM SOMMINISTRAZIONI WHERE ID_PAZIENTE = ?";
		List<SomministrazioneDB> somministrazioni = new ArrayList<>();

		try (Connection conn = ConnessioneDB.startConnection("ccp");
			 PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, cfPaziente);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					SomministrazioneDB sDb = new SomministrazioneDB(
							rs.getInt("ID_TERAPIA"),
							rs.getString("ID_PAZIENTE"),
							rs.getString("ID_OPERATORE"),
							rs.getTimestamp("DATA_ORA").toLocalDateTime(),
							rs.getString("STATO"),
							rs.getString("NOTE")
					);
					
					sDb.setSomministrazione(rs.getInt("ID_SOMMINISTRAZIONE"));
					somministrazioni.add(sDb);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return somministrazioni;
	}

	
	@Override
	public List<SomministrazioneDB> selectSomministrazioniByStato(String stato) {
		String query = "SELECT * FROM SOMMINISTRAZIONI WHERE STATO = ?";
		List<SomministrazioneDB> somministrazioni = new ArrayList<>();

		try (Connection conn = ConnessioneDB.startConnection("ccp");
			 PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, stato);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					SomministrazioneDB sDb = new SomministrazioneDB(
							rs.getInt("ID_TERAPIA"),
							rs.getString("ID_PAZIENTE"),
							rs.getString("ID_OPERATORE"),
							rs.getTimestamp("DATA_ORA").toLocalDateTime(),
							rs.getString("STATO"),
							rs.getString("NOTE")
					);
					sDb.setSomministrazione(rs.getInt("ID_SOMMINISTRAZIONE"));
					somministrazioni.add(sDb);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return somministrazioni;
	}

	
	@Override
	public List<SomministrazioneDB> selectAllSomministrazioni() {
		String query = "SELECT * FROM SOMMINISTRAZIONI";
		List<SomministrazioneDB> somministrazioni = new ArrayList<>();

		try (Connection conn = ConnessioneDB.startConnection("ccp");
			 PreparedStatement ps = conn.prepareStatement(query);
			 ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				SomministrazioneDB sDb = new SomministrazioneDB(
						rs.getInt("ID_TERAPIA"),
						rs.getString("ID_PAZIENTE"),
						rs.getString("ID_OPERATORE"),
						rs.getTimestamp("DATA_ORA").toLocalDateTime(),
						rs.getString("STATO"),
						rs.getString("NOTE")
				);
				sDb.setSomministrazione(rs.getInt("ID_SOMMINISTRAZIONE"));
				somministrazioni.add(sDb);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return somministrazioni;
	}

	
	@Override
	public boolean updateSomministrazione(SomministrazioneDB sDb) {
		String query = "UPDATE SOMMINISTRAZIONI SET ID_OPERATORE = ?, STATO = ?, NOTE = ? WHERE ID_SOMMINISTRAZIONE = ?";
		
		try (Connection conn = ConnessioneDB.startConnection("ccp");
			 PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, sDb.getOperatore());
			ps.setString(2, sDb.getStato());
			ps.setString(3, sDb.getNote());
			ps.setInt(4, sDb.getSomministrazione());
			
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}