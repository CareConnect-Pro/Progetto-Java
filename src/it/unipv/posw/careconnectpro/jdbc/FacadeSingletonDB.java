package it.unipv.posw.careconnectpro.jdbc;

import it.unipv.posw.careconnectpro.jdbc.bean.dipendente.DipendenteDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.dipendente.DipendenteDB;
import it.unipv.posw.careconnectpro.jdbc.bean.dipendente.IDipendenteDAO;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.FactoryDipendente;

public class FacadeSingletonDB {

	private static FacadeSingletonDB istanzaDB;

	private IDipendenteDAO dipendenteDAO;
	

    private FacadeSingletonDB() {
        dipendenteDAO = new DipendenteDAO();
    }
    

    public static FacadeSingletonDB getIstanzaFacade() {
		if(istanzaDB == null) {
			istanzaDB = new FacadeSingletonDB();
		}
		return istanzaDB;
	}
    
    
    public IDipendenteDAO getDipendenteDAO() {
		return dipendenteDAO;
	}


	public void setDipendenteDAO(IDipendenteDAO dipendenteDAO) {
		this.dipendenteDAO = dipendenteDAO;
	}


	public Dipendente findDipendenteByCf(String cf) {
        DipendenteDB db = dipendenteDAO.selectDipendenteByCf(cf);
        if (db == null) return null;
        Dipendente dipendente = FactoryDipendente.getDipendente(
                db.getRuolo(),                
                db.getCodiceFiscale(),
                db.getNome(),
                db.getCognome(),
                db.getDataNascita(),
                db.getEmail(),
                db.getNumeroTelefonico(),
                db.getIdDipendente(),
                db.getPassword(),
                db.getDataInizio()
        );
        return dipendente;
    }

	
    public boolean insertDipendente(Dipendente d) {
        DipendenteDB db = new DipendenteDB(
                d.getCodiceFiscale(),
                d.getNome(),
                d.getCognome(),
                d.getDataNascita(),
                d.getEmail(),
                d.getCellulare(),
                d.getIdDipendente(),
                d.getPassword(),
                d.getTipoDipendente().name(),
                d.getDataAssunzione());
        return dipendenteDAO.insertDipendente(db);
    }
    
    public boolean deleteDipendente(String idDipendente) {
        return dipendenteDAO.deleteDipendenteById(idDipendente);
    }

}
