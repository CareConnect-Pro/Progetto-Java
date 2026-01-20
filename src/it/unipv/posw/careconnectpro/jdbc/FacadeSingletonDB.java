package it.unipv.posw.careconnectpro.jdbc;

import it.unipv.posw.careconnectpro.jdbc.bean.diaro.DiarioParametriDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.diaro.DiarioParametriDB;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.IPersonaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDB;
import it.unipv.posw.careconnectpro.model.parametri.diaro.DiarioParametri;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.FactoryDipendente;

public class FacadeSingletonDB {

    private static FacadeSingletonDB istanza;
    private IPersonaDAO personaDAO;
    private DiarioParametriDAO diarioParametriDAO;

    public FacadeSingletonDB() {
        personaDAO = new PersonaDAO();
        diarioParametriDAO = new DiarioParametriDAO();
    }

    public static FacadeSingletonDB getIstanza() {
        if (istanza == null) {
            istanza = new FacadeSingletonDB();
        }
        return istanza;
    }

    public boolean insertPersona(Persona p) {
        PersonaDB personaDB;
        personaDB = new PersonaDB(
                p.getCodiceFiscale(),
                p.getNome(),
                p.getCognome(),
                p.getDataNascita(),
                p.getEmail(),
                p.getCellulare(),
                p.getPassword(),
                p.getTipoUtente().name(),
                p.getDataInizio());

        return personaDAO.insertPersona(personaDB);
    }

    public Dipendente findDipendenteByCf(String cf) {
        PersonaDB db = personaDAO.selectPersonaByCf(cf);
        if (db == null) return null;
        Dipendente dipendente = FactoryDipendente.getDipendente(
                db.getRuolo(),
                db.getCodiceFiscale(),
                db.getNome(),
                db.getCognome(),
                db.getDataNascita(),
                db.getEmail(),
                db.getNumeroTelefonico(),
                db.getPassword(),
                db.getDataInizio()
        );
        return dipendente;
    }

    public boolean deletePersona(String cf) {
        return personaDAO.deletePersonaByCf(cf);
    }

    public boolean insertDiarioParametri(DiarioParametri dp) {
        DiarioParametriDB dpDB;
        dpDB = new DiarioParametriDB(
        			dp.getIdDiarioParametri(),
        			dp.getIdPaziente()
        	);
        return diarioParametriDAO.insertDiarioParametri(dpDB);
    }
    
    //Getter and Setter
    public IPersonaDAO getPersonaDAO() {
        return personaDAO;
    }
    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }
    
    

}
