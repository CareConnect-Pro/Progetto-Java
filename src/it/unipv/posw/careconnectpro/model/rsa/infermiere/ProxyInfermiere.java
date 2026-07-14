package it.unipv.posw.careconnectpro.model.rsa.infermiere;

import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia.TerapiaDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;


public class ProxyInfermiere implements IRSAInfermiere {
    
    private IRSAInfermiere rsa;
    private static ProxyInfermiere proxy;

    private ProxyInfermiere() { 
    	this.rsa = new InfermiereService();
    }

    public static ProxyInfermiere getProxy() {
        if (proxy == null) proxy = new ProxyInfermiere();
        return proxy;
    }

    private boolean isInfermiere() {
        Dipendente u = GestoreSessione.getIstanza().getUtenteLoggato();
        return u != null && u.getTipoUtente() == TipoUtente.INFERMIERE;
    }

   

    @Override
    public List<Paziente> cercaPazienti() {
        if (isInfermiere()) return rsa.cercaPazienti();
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public Dipendente cercaDipendenteByCf(String cf) {
        if (isInfermiere()) return rsa.cercaDipendenteByCf(cf);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public Paziente cercaPazienteByCf(String cf) {
        if (isInfermiere()) return rsa.cercaPazienteByCf(cf);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public CartellaClinica cercaCartellaClinicaByCf(String cf) {
        if (isInfermiere()) return rsa.cercaCartellaClinicaByCf(cf);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }
    
    
    
    @Override
    public int creaMonitoraggio(Monitoraggio m) {
        if (isInfermiere()) return rsa.creaMonitoraggio(m);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    
    
    @Override
    public List<TerapiaDB> getTerapieAttiveOggi() {
        if (isInfermiere()) {
            return rsa.getTerapieAttiveOggi();
        }
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }
    
    
    
    
    @Override
    public List<Somministrazione> getSomministrazioni() {
        if (isInfermiere()) return rsa.getSomministrazioni();
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public boolean confermaSomministrazione(Somministrazione s) {
        if (isInfermiere()) return rsa.confermaSomministrazione(s);
        throw new RuntimeException("Operazione non autorizzata: permessi insufficienti.");
    }

    @Override
    public Dipendente getUtenteLoggato() {
        return rsa.getUtenteLoggato();
    }
}