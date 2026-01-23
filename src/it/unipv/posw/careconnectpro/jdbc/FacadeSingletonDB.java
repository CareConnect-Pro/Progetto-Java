package it.unipv.posw.careconnectpro.jdbc;

import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.CartellaClinicaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.CartellaClinicaDB;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.ICartellaClinicaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio.IMonitoraggioDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio.MonitoraggioDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio.MonitoraggioDB;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia.ITerapiaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia.TerapiaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia.TerapiaDB;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.visita.IVisitaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.visita.VisitaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.visita.VisitaDB;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.IPersonaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Alert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.TipiParametroVitale;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.visita.Visita;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.FactoryDipendente;

public class FacadeSingletonDB {

    private static FacadeSingletonDB istanza;
    private IPersonaDAO personaDAO;
    private ICartellaClinicaDAO cartellaClinicaDAO;
    private ITerapiaDAO terapiaDAO;
    private IVisitaDAO visitaDAO;
    private IMonitoraggioDAO monitoraggioDAO;

    public FacadeSingletonDB() {
        personaDAO = new PersonaDAO();
        cartellaClinicaDAO = new CartellaClinicaDAO();
        terapiaDAO = new TerapiaDAO();
        visitaDAO = new VisitaDAO();
        monitoraggioDAO = new MonitoraggioDAO();
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
    
    
    public Paziente findPazienteByCf(String cf) {
        PersonaDB db = personaDAO.selectPersonaByCf(cf);
        if (db == null) return null;
        Paziente paziente = new Paziente(
                db.getCodiceFiscale(),
                db.getNome(),
                db.getCognome(),
                db.getDataNascita(),
                db.getEmail(),
                db.getNumeroTelefonico(),
                db.getPassword(),
                TipoUtente.PAZIENTE,
                db.getDataInizio()
        );
        return paziente;
    }

    
    public boolean deletePersona(Persona p) {
        return personaDAO.deletePersona(p);
    }
    
    
    public int insertCartellaClinica(CartellaClinica cc) {
        CartellaClinicaDB cartellaClinicaDB;
        cartellaClinicaDB = new CartellaClinicaDB(
                cc.getIdPaziente(),
                cc.getDataCreazione()
        );              
        return cartellaClinicaDAO.insertCartellaClinica(cartellaClinicaDB);
    }
    
    
    public CartellaClinica findCartellaClinicaByCf (String cf)	{
	    	CartellaClinicaDB db = cartellaClinicaDAO.selectCartellaClinicaByCf(cf);
	    	if (db == null) return null;
	    Paziente paziente = findPazienteByCf(db.getIdPaziente());
	    	if (paziente == null) return null;
	        CartellaClinica cartellaClinica = new CartellaClinica(paziente);
	        cartellaClinica.setIdCartellaClinica(db.getIdCartellaClinica());
	        
	        return cartellaClinica;
    }
    
    
    public boolean deleteCartellaClinica(String cf)	{
    		return cartellaClinicaDAO.deleteCartellaClinicaByCf(cf);
    }
    
    
    public int insertTerapia(Terapia t) {	
	    	TerapiaDB db = new TerapiaDB(
	    			t.getCartellaClinica().getIdCartellaClinica(),
	    			t.getPaziente().getCodiceFiscale(),
	    			t.getMedico().getCodiceFiscale(),
	    			t.getTipoSomministrazione().name(),
	    			t.getNomeFarmaco(),
	    			t.getMateriale(),
	    			t.getDosaggio(),
	    			t.getFrequenzaGiornaliera(),
	    			t.getStato().name(),
	    			t.getDurata(),
	    			t.getDataInizio(),
	    			t.getDataFine(),
	    			t.getNote()
	    			);
	    	return terapiaDAO.insertTerapia(db);
    }

    
    public int insertVisita(Visita v) {
    	VisitaDB db = new VisitaDB(
                v.getCartellaClinica().getIdCartellaClinica(),
                v.getPaziente().getCodiceFiscale(),
                v.getMedico().getCodiceFiscale(),
                v.getDataVisita(),
                v.getNote(),
                v.getEsito().name()
            );
            return visitaDAO.insertVisita(db);
    }
    
    
    public int insertMonitoraggio(Monitoraggio m)	{
	    	MonitoraggioDB db = new MonitoraggioDB(
	    			m.getCartellaClinica().getIdCartellaClinica(),
	    			m.getPaziente().getCodiceFiscale(),
	    			m.getInfermiere().getCodiceFiscale(),
	    			m.getTipiParametroVitale().name(),
	    			m.getValore(),
	    			m.getDataMonitoraggio(),
	    			m.getAlert().name(),
	    			m.getNote()
	    			);
	    	return monitoraggioDAO.insertMonitoraggio(db);
    }
    
    
    public Monitoraggio convertToMonitoraggio(MonitoraggioDB mDb)	{
        Paziente paziente = findPazienteByCf(mDb.getIdPaziente());
        CartellaClinica cc = findCartellaClinicaByCf(paziente.getCodiceFiscale());
        Dipendente infermiere = findDipendenteByCf(mDb.getIdInferimere());

        Monitoraggio monitoraggio = new Monitoraggio(
			            cc,
			            paziente,
			            infermiere,
			            TipiParametroVitale.valueOf(mDb.getTipoParametro()),
			            mDb.getValore(),
			            mDb.getDataMonitoraggio(),
			            Alert.valueOf(mDb.getAlert()),
			            mDb.getNote()
			        );

        return monitoraggio;      
    }
    
    
    public List<Monitoraggio> selectMonitoraggioByAlertAttivo ()	{
    		List<MonitoraggioDB> monitoraggiDB = monitoraggioDAO.selectMonitoraggioByAlertAttivo();
        List<Monitoraggio> monitoraggi = new ArrayList<>();

        for (MonitoraggioDB mDb : monitoraggiDB) {
            Monitoraggio monitoraggio = convertToMonitoraggio(mDb);
            monitoraggi.add(monitoraggio);
        }

        return monitoraggi;
    }
	  

    //Getter and Setter
    public IPersonaDAO getPersonaDAO() {
        return personaDAO;
    }
    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }


}

