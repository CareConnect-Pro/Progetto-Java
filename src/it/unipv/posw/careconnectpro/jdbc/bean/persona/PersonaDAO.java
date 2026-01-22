package it.unipv.posw.careconnectpro.jdbc.bean.persona;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;
import it.unipv.posw.careconnectpro.model.persona.Persona;

import java.sql.*;

public class PersonaDAO  implements IPersonaDAO {

    public PersonaDAO (){
    }

    @Override
    public boolean insertPersona(PersonaDB p) {
        String query =
                "INSERT INTO UTENTI " +
                        "(CODICE_FISCALE, NOME, COGNOME, DATA_DI_NASCITA, EMAIL, NUMERO_TELEFONICO, PASSWORD_UTENTE, " +
                        "RUOLO_UTENTE, DATA_INIZIO) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, p.getCodiceFiscale());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getCognome());
            ps.setDate  (4, Date.valueOf(p.getDataNascita()));
            ps.setString(5, p.getEmail());
            ps.setString(6, p.getNumeroTelefonico());
            ps.setString(7, p.getPassword());
            ps.setString(8, p.getRuolo());
            ps.setDate  (9, Date.valueOf(p.getDataInizio()));
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public PersonaDB selectPersonaByCf(String cf) {
        PersonaDB d = null;
        String query = "SELECT * FROM ccp.UTENTI WHERE CODICE_FISCALE = ?";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, cf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    d = new PersonaDB(
                            rs.getString("CODICE_FISCALE"),
                            rs.getString("NOME"),
                            rs.getString("COGNOME"),
                            rs.getDate("DATA_DI_NASCITA").toLocalDate(),
                            rs.getString("EMAIL"),
                            rs.getString("NUMERO_TELEFONICO"),
                            rs.getString("PASSWORD_UTENTE"),
                            rs.getString("RUOLO_UTENTE"),
                            rs.getDate("DATA_INIZIO").toLocalDate()
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return d;
    }

    @Override
    public boolean deletePersona(Persona p) {
        String query = "DELETE FROM UTENTI WHERE CODICE_FISCALE = ?";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, p.getCodiceFiscale());
            int deletedRows = ps.executeUpdate();
            return deletedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}












//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                if (p.getRuolo().equals(TipoUtente.PAZIENTE)) {
//                    int id = rs.getInt(1);
//                    String id_utente = "PAZ" + id;
//
//                    String query2 = "UPDATE DIPENDENTI SET ID_DIPENDENTE = ? WHERE ID = ?";
//                    PreparedStatement ps2 = conn.prepareStatement(query2);
//
//                    ps2.setString(1, id_utente);
//                    ps2.setInt(2, id);
//                    ps2.executeUpdate();
//
//                } else {
//
//                    int id = rs.getInt(1);
//                    String id_dipendente = "DIP" + id;
//
//                    String query3 = "UPDATE DIPENDENTI SET ID_DIPENDENTE = ? WHERE ID = ?";
//                    PreparedStatement ps3 = conn.prepareStatement(query3);
//
//                    ps3.setString(1, id_dipendente);
//                    ps3.setInt(2, id);
//                    ps3.executeUpdate();
//                }
//            }