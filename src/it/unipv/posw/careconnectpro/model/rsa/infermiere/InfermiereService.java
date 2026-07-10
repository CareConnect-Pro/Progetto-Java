package it.unipv.posw.careconnectpro.model.rsa.infermiere;

import java.util.List;
import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
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
        return facadeDB.updateSomministrazione(s);
    }
}