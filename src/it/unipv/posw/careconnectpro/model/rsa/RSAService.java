package it.unipv.posw.careconnectpro.model.rsa;

import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.alert.Alert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class RSAService implements IRSA {
	
    private final FacadeSingletonDB facadeDB;
    private Dipendente utenteLoggato= null;
    
    public RSAService() {
        facadeDB = FacadeSingletonDB.getIstanza();
    }

    
    @Override
    public boolean registraUtente(Persona p) {
        boolean nuovoUtente = facadeDB.insertPersona(p);
        if (!nuovoUtente) {
            System.out.println("Errore nell'inserimento dell'utente " + p.getCodiceFiscale());
            return false;
        }

        if (p.getTipoUtente() == TipoUtente.PAZIENTE) {
            CartellaClinica cc = new CartellaClinica(p);
            int idCC = facadeDB.insertCartellaClinica(cc);
            if (idCC <= 0) {
                throw new RuntimeException("Creazione cartella clinica fallita per il paziente " + p.getCodiceFiscale());
            }
            cc.setIdCartellaClinica(idCC);
        }
        System.out.println("Registrazione utente avvenuta con successo: " + p.getCodiceFiscale());
        return true;
    }
    
    @Override
    public List<Paziente> cercaPazienti()	{
    		return facadeDB.selectPazienti();
    }

    
	@Override
    public boolean disattivaUtente(String cf) {

        if (cf == null) {
            System.out.println("Nessun codice fiscale inserito");
            return false;
        }

        Persona p = facadeDB.findPazienteByCf(cf);
        if (p == null) {
            p = facadeDB.findDipendenteByCf(cf);
        }

        if (p == null) {
            System.out.println("Utente non presente nel DB");
            return false;
        }

        boolean utenteDisattivato = facadeDB.deletePersona(p);
	    	if (!utenteDisattivato) {
	    		System.out.println("Errore nella rimozione dell'utente " + p.getCodiceFiscale());
	    		return false;
	    	}
	    	System.out.println("Rimozione utente avvenuta con successo: " + p.getCodiceFiscale());
	    	return true;
    }
    
	@Override
    public Dipendente login (String cf, String password) {
        Dipendente d = facadeDB.findDipendenteAttivoByCf(cf);
        if (d == null) {
            System.out.println("Utente non trovato");
            return null;
        }
        if (d.getPassword().equals(password)){
            System.out.println("Login Dipendente avvenuto con successo ");
            return d;
        }

        System.out.println("Password errata");
        return null;
    }
    
    @Override
    public int creaCartellaClinica(CartellaClinica cc)	{
    		return facadeDB.insertCartellaClinica(cc);
    }
	 
    
    @Override
	public int creaTerapia(Terapia t)	{
        CartellaClinica cc = facadeDB.findCartellaClinicaByCf(t.getPaziente().getCodiceFiscale());
        if (cc == null) throw new RuntimeException("Cartella clinica non trovata per " + t.getPaziente().getCodiceFiscale());
        t.setCartellaClinica(cc);

        Paziente p = facadeDB.findPazienteByCf(cc.getIdPaziente());
        if (p == null) throw new RuntimeException("Paziente non trovato: " + cc.getIdPaziente());
        t.setPaziente(p);
        
    		return facadeDB.insertTerapia(t);
    }
	
	
	@Override
	public int creaMonitoraggio(Monitoraggio m)	{
        CartellaClinica cc = facadeDB.findCartellaClinicaByCf(m.getPaziente().getCodiceFiscale());
        if (cc == null) throw new RuntimeException("Cartella clinica non trovata per " + m.getPaziente().getCodiceFiscale());
        m.setCartellaClinica(cc);

        Paziente p = facadeDB.findPazienteByCf(cc.getIdPaziente());
        if (p == null) throw new RuntimeException("Paziente non trovato: " + cc.getIdPaziente());
        m.setPaziente(p);

		return facadeDB.insertMonitoraggio(m);
	}

    @Override
    public Monitoraggio cercaMonitoraggioById(int id)	{
        return facadeDB.selectMonitoraggioById(id);
    }

	@Override
	public List<Monitoraggio> getMonitoraggiConAlertAttivo() {
	    return facadeDB.selectMonitoraggioByAlertAttivo();
	}
	
	@Override
	public boolean risolviAlertMonitoraggio(Monitoraggio m) {
        if(m.getAlert() == Alert.RISOLTO) {
            System.out.println("Alert già risolto");
            return true;
        }
	    m.setAlert(Alert.RISOLTO);
	    return facadeDB.updateAlertMonitoraggio(m);
	}

    @Override
    public Dipendente cercaDipendenteByCf(String cf) {
        return facadeDB.findDipendenteAttivoByCf(cf);
    }
    
    @Override
    public Dipendente getUtenteLoggato() {
        return utenteLoggato;
    }

    @Override
    public Paziente cercaPazienteByCf(String cf) {
        return facadeDB.findPazienteByCf(cf);
    }

    @Override
    public CartellaClinica cercaCartellaClinicaByCf(String cf){
        return facadeDB.findCartellaClinicaByCf(cf);
    }

    @Override
    public void setUtenteLoggato(Dipendente utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
    }

    public FacadeSingletonDB getFacadeDB() {
        return facadeDB;
    }

}

