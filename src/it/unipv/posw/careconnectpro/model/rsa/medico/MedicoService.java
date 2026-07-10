package it.unipv.posw.careconnectpro.model.rsa.medico;

import java.util.List;
import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.*;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.*;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.alert.Alert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;

public class MedicoService implements IRSAMedico {
    
    private FacadeSingletonDB facadeDB = FacadeSingletonDB.getIstanza();

    @Override
    public int creaTerapia(Terapia t) {
    	 CartellaClinica cc = facadeDB.findCartellaClinicaByCf(t.getPaziente().getCodiceFiscale());
         if (cc == null) throw new RuntimeException("Cartella clinica non trovata per " + t.getPaziente().getCodiceFiscale());
         t.setCartellaClinica(cc);

         Paziente p = facadeDB.findPazienteByCf(cc.getIdPaziente());
         if (p == null) throw new RuntimeException("Paziente non trovato: " + cc.getIdPaziente());
         t.setPaziente(p);
        return facadeDB.insertTerapia(t);
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
    public Monitoraggio cercaMonitoraggioById(int id) {
        return facadeDB.selectMonitoraggioById(id);
    }

    @Override
    public Dipendente cercaDipendenteByCf(String cf) {
        return facadeDB.findDipendenteAttivoByCf(cf);
    }

    @Override
    public Paziente cercaPazienteByCf(String cf) {
        return facadeDB.findPazienteByCf(cf);
    }

    @Override
    public CartellaClinica cercaCartellaClinicaByCf(String cf) {
        return facadeDB.findCartellaClinicaByCf(cf);
    }

    @Override
    public Dipendente getUtenteLoggato() {
        return GestoreSessione.getIstanza().getUtenteLoggato();
    }

    @Override
    public List<Somministrazione> getSomministrazioniNonSomministrate() {
        return facadeDB.selectSomministrazioniNonSomministrate();
    }

    @Override
    public boolean confermaSomministrazione(Somministrazione s) {
        Dipendente loggato = GestoreSessione.getIstanza().getUtenteLoggato();
        
        if (loggato != null) {
            s.setOperatore(loggato.getCodiceFiscale()); 
        }
        return facadeDB.updateSomministrazione(s);
    }
    
    
}