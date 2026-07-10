package it.unipv.posw.careconnectpro.model.rsa.amministratore;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;


public class ProxyAmministratore implements IRSAAmministratore {
    
	private IRSAAmministratore rsa;
    private static ProxyAmministratore proxy;

    private ProxyAmministratore() { 
    	 this.rsa = new AmministratoreService();
    }

    public static ProxyAmministratore getProxy() {
        if (proxy == null) {
            proxy = new ProxyAmministratore();
        }
        return proxy;
    }

    private boolean isAmministratore() {
        Dipendente utenteLoggato = GestoreSessione.getIstanza().getUtenteLoggato();
        return utenteLoggato != null && utenteLoggato.getTipoUtente() == TipoUtente.AMMINISTRATORE;
    }


    
    @Override
    public boolean registraUtente(Persona p) {
        if (isAmministratore()) {
            return rsa.registraUtente(p);
        }
        throw new RuntimeException("Solo gli amministratori possono registrare utenti.");
    }

    @Override
    public boolean disattivaUtente(String cf) {
        if (isAmministratore()) {
            return rsa.disattivaUtente(cf);
        }
        throw new RuntimeException("Solo gli amministratori possono disattivare utenti.");
    }

    @Override
    public int creaCartellaClinica(CartellaClinica cc) {
        if (isAmministratore()) {
            return rsa.creaCartellaClinica(cc);
        }
        throw new RuntimeException("Solo gli amministratori possono creare cartelle cliniche.");
    }

    @Override
    public Dipendente getUtenteLoggato() {
        return rsa.getUtenteLoggato();
    }
}
