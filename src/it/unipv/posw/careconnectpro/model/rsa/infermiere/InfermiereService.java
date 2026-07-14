package it.unipv.posw.careconnectpro.model.rsa.infermiere;

import java.time.LocalDateTime;
import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.somministrazione.ISomministrazioneDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.somministrazione.SomministrazioneDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.somministrazione.SomministrazioneDB;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia.TerapiaDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;

public class InfermiereService implements IRSAInfermiere {
    
    private FacadeSingletonDB facadeDB = FacadeSingletonDB.getIstanza();

    @Override
    public int creaMonitoraggio(Monitoraggio m) {
        CartellaClinica cc = facadeDB.findCartellaClinicaByCf(m.getPaziente().getCodiceFiscale());
        if (cc == null) throw new RuntimeException("Cartella clinica non trovata per " + m.getPaziente().getCodiceFiscale());
        m.setCartellaClinica(cc);

        Paziente p = facadeDB.findPazienteByCf(cc.getIdPaziente());
        if (p == null) throw new RuntimeException("Paziente non trovato: " + cc.getIdPaziente());
        m.setPaziente(p);

        return facadeDB.insertMonitoraggio(m);
    }
    
    @Override
    public List<TerapiaDB> getTerapieAttiveOggi() {
        return facadeDB.getTerapieAttiveOggi();
    }
    
    @Override
    public List<Paziente> cercaPazienti() {
        return facadeDB.selectPazienti();
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
    public List<Somministrazione> getSomministrazioni() {
        return facadeDB.selectAllSomministrazioni();
    }

    @Override
    public boolean confermaSomministrazione(Somministrazione s) {
        Dipendente loggato = GestoreSessione.getIstanza().getUtenteLoggato();
        if (loggato != null) s.setOperatore(loggato.getCodiceFiscale());

        // ID è 0 --> riga virtuale appena confermata
        if (s.getSomministrazione() == 0) {
            SomministrazioneDB sDb = new SomministrazioneDB(
                    s.getTerapia(), 
                    s.getPaziente(), 
                    s.getOperatore(),
                    LocalDateTime.of(s.getData(), s.getOra()), 
                    s.getStato().name(), 
                    s.getNote()
            );
            
            ISomministrazioneDAO dao = new SomministrazioneDAO();
            
            return dao.insertSomministrazione(sDb) > 0;
        } else {
            return facadeDB.updateSomministrazione(s);
        }
    }
}