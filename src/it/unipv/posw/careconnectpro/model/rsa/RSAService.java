package it.unipv.posw.careconnectpro.model.rsa;

import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.visita.Visita;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class RSAService implements IRSA {
	
    private final FacadeSingletonDB facadeDB;

    
    public RSAService() {
        facadeDB = FacadeSingletonDB.getIstanza();
    }
    public RSAService(FacadeSingletonDB facadeDB) {
        this.facadeDB = facadeDB;
    }


    public FacadeSingletonDB getFacadeDB() {
        return facadeDB;
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
    public boolean rimuoviUtente(Persona p) {
	    	if (p == null) {
	    		System.out.println("Errore nella rimozione dell'utente");
	    		return false;
	    	}
	    	if (p.getTipoUtente() == TipoUtente.PAZIENTE) {
	    		boolean ccRimosso = facadeDB.deleteCartellaClinica(p.getCodiceFiscale());
	    		if (!ccRimosso) {
	    			System.out.println("Errore nella rimozione della cartella clinica per il paziente " + p.getCodiceFiscale());
	    			return false;
	    		}
	    	}
	    	boolean utenteRimosso = facadeDB.deletePersona(p);
	    	if (!utenteRimosso) {
	    		System.out.println("Errore nella rimozione dell'utente " + p.getCodiceFiscale());
	    		return false;
	    	}
	    	System.out.println("Rimozione utente avvenuta con successo: " + p.getCodiceFiscale());
	    	return true;
    }
    

    public Dipendente login (String cf, String password) {
        Dipendente d = facadeDB.findDipendenteByCf(cf);
        if (d == null) return null;
        if (d.getPassword().equals(password)){
            System.out.println("Login Dipendente avvenuta con successo " + password);

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
    public boolean rimuoviCartellaClinica(String cf)	{
    		return facadeDB.deleteCartellaClinica(cf);
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
	public int creaVisita (Visita v)	{
        CartellaClinica cc = facadeDB.findCartellaClinicaByCf(v.getPaziente().getCodiceFiscale());
        if (cc == null) throw new RuntimeException("Cartella clinica non trovata per " + v.getPaziente().getCodiceFiscale());
        v.setCartellaClinica(cc);

        Paziente p = facadeDB.findPazienteByCf(cc.getIdPaziente());
        if (p == null) throw new RuntimeException("Paziente non trovato: " + cc.getIdPaziente());
        v.setPaziente(p);
        
		return facadeDB.insertVisita(v);
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
	public List<Monitoraggio> getMonitoraggiConAlertAttivo() {
	    return facadeDB.selectMonitoraggioByAlertAttivo();
	}
	
}

