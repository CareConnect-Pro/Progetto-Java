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
import it.unipv.posw.careconnectpro.jdbc.bean.persona.IPersonaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Alert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.TipiParametroVitale;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.FactoryDipendente;

public class FacadeSingletonDB {

    private static FacadeSingletonDB istanza;
    private IPersonaDAO personaDAO;
    private ICartellaClinicaDAO cartellaClinicaDAO;
    private ITerapiaDAO terapiaDAO;
    private IMonitoraggioDAO monitoraggioDAO;

    public FacadeSingletonDB() {
        personaDAO = new PersonaDAO();
        cartellaClinicaDAO = new CartellaClinicaDAO();
        terapiaDAO = new TerapiaDAO();
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
    
    public Dipendente findDipendenteAttivoByCf(String cf) {
        PersonaDB pDb = personaDAO.selectPersonaAttivaByCf(cf);
        if (pDb == null) return null;
        Dipendente dipendente = FactoryDipendente.getDipendente(
                pDb.getRuolo(),
                pDb.getCodiceFiscale(),
                pDb.getNome(),
                pDb.getCognome(),
                pDb.getDataNascita(),
                pDb.getEmail(),
                pDb.getNumeroTelefonico(),
                pDb.getPassword(),
                pDb.getDataInizio()
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
                db.getDataInizio()
        );
        return paziente;
    }

    private Paziente convertToPaziente (PersonaDB pDb)	{
	    	Paziente paziente = new Paziente(
		            pDb.getCodiceFiscale(),
		            pDb.getNome(),
		            pDb.getCognome(),
		            pDb.getDataNascita(),
		            pDb.getEmail(),
		            pDb.getNumeroTelefonico(),
		            pDb.getDataInizio()		           
		        );
		paziente.setIdPaziente(pDb.getIdPersona());
		return paziente;  
    }
    
    public List<Paziente> selectPazienti ()  {
    		List<PersonaDB> pazientiDB = personaDAO.selectPazienti();
		List<Paziente> pazienti = new ArrayList<>();
		
		for (PersonaDB pDb : pazientiDB)	{
			Paziente p = convertToPaziente(pDb);
			pazienti.add(p);
		}	
		return pazienti;
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
    
    
    private Monitoraggio convertToMonitoraggio(MonitoraggioDB mDb)	{
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
        monitoraggio.setIdMonitoraggio(mDb.getIdMonitoraggio());
        return monitoraggio;      
    }

    public Monitoraggio selectMonitoraggioById(int id)  {
        MonitoraggioDB db = monitoraggioDAO.selectMonitoraggioById(id);
        return  convertToMonitoraggio(db);

    }
    
    
    public List<Monitoraggio> selectMonitoraggioByAlertAttivo ()	{
    		List<MonitoraggioDB> monitoraggiDB = monitoraggioDAO.selectMonitoraggioByAlertAttivo();
        List<Monitoraggio> monitoraggi = new ArrayList<>();

        for (MonitoraggioDB mDb : monitoraggiDB) {
            Monitoraggio monitoraggio = convertToMonitoraggio(mDb);
            monitoraggio.setIdMonitoraggio(mDb.getIdMonitoraggio());
            monitoraggi.add(monitoraggio);
        }

        return monitoraggi;
    }
    
    public boolean updateAlertMonitoraggio(Monitoraggio m)	{
    	    MonitoraggioDB mDb = new MonitoraggioDB(
    	            m.getCartellaClinica().getIdCartellaClinica(),
    	            m.getPaziente().getCodiceFiscale(),
    	            m.getInfermiere().getCodiceFiscale(),
    	            m.getTipiParametroVitale().name(),
    	            m.getValore(),
    	            m.getDataMonitoraggio(),
    	            m.getAlert().name(),
    	            m.getNote()
    	    );
    	    mDb.setIdMonitoraggio(m.getIdMonitoraggio());
    	    return monitoraggioDAO.updateAlertMonitoraggio(mDb);
    	}
	  

    //Getter and Setter
    public IPersonaDAO getPersonaDAO() {
        return personaDAO;
    }
    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }


}

