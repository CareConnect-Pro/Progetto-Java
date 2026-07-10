package it.unipv.posw.careconnectpro.model.rsa.medico;

import java.util.List;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;

public class ProxyMedico implements IRSAMedico {
    
    private IRSAMedico rsa;
    private static ProxyMedico proxy;

    private ProxyMedico() { 
        this.rsa = new MedicoService();
    }

    public static ProxyMedico getProxy() {
        if (proxy == null) proxy = new ProxyMedico();
        return proxy;
    }

    private boolean isMedico() {
        Dipendente u = GestoreSessione.getIstanza().getUtenteLoggato();
        return u != null && u.getTipoUtente() == TipoUtente.MEDICO;
    }

  
    
    @Override
    public Dipendente cercaDipendenteByCf(String cf) {
        if (isMedico()) return rsa.cercaDipendenteByCf(cf);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public Paziente cercaPazienteByCf(String cf) {
        if (isMedico()) return rsa.cercaPazienteByCf(cf);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public CartellaClinica cercaCartellaClinicaByCf(String cf) {
        if (isMedico()) return rsa.cercaCartellaClinicaByCf(cf);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

   
    
    
    @Override
    public int creaTerapia(Terapia t) {
        if (isMedico()) return rsa.creaTerapia(t);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public List<Monitoraggio> getMonitoraggiConAlertAttivo() {
        if (isMedico()) return rsa.getMonitoraggiConAlertAttivo();
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public boolean risolviAlertMonitoraggio(Monitoraggio m) {
        if (isMedico()) return rsa.risolviAlertMonitoraggio(m);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public Monitoraggio cercaMonitoraggioById(int id) {
        if (isMedico()) return rsa.cercaMonitoraggioById(id);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public List<Somministrazione> getSomministrazioniNonSomministrate() {
        if (isMedico()) return rsa.getSomministrazioniNonSomministrate();
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public boolean confermaSomministrazione(Somministrazione s) {
        if (isMedico()) return rsa.confermaSomministrazione(s);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public Dipendente getUtenteLoggato() {
        return rsa.getUtenteLoggato();
    }
}