package it.unipv.posw.careconnectpro.jdbc;

import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.CartellaClinicaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.CartellaClinicaDB;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.ICartellaClinicaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.IPersonaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.FactoryDipendente;

public class FacadeSingletonDB {

    private static FacadeSingletonDB istanza;
    private IPersonaDAO personaDAO;
    private ICartellaClinicaDAO cartellaClinicaDAO;

    public FacadeSingletonDB() {
        personaDAO = new PersonaDAO();
        cartellaClinicaDAO = new CartellaClinicaDAO();
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
    
    public boolean insertCartellaClinica(CartellaClinica cc) {
        CartellaClinicaDB cartellaClinicaDB;
        cartellaClinicaDB = new CartellaClinicaDB(
                cc.getIdPaziente(),
                cc.getDataCreazione()
        );              
        return cartellaClinicaDAO.insertCartellaClinica(cartellaClinicaDB);
    }
    
    public boolean deleteCartellaClinica(String cf)	{
    		return cartellaClinicaDAO.deleteCartellaClinicaByCf(cf);
    }


    //Getter and Setter
    public IPersonaDAO getPersonaDAO() {
        return personaDAO;
    }
    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

}
