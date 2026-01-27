package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

import java.util.List;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;

public class ProxyRSA implements IRSA {

    private final RSAService rsa;
    private final Persona utenteLoggato;

    public ProxyRSA(Dipendente utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
        this.rsa = new RSAService();
    }

    @Override
    public boolean registraUtente(Persona persona) {
        if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.AMMINISTRATORE) {
            return rsa.registraUtente(persona);
        }
        System.out.println("Solo gli amministratori possono registrare nuovi utenti");
        return false;
    }

    @Override
    public boolean rimuoviUtente(String cf)	{
        if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.AMMINISTRATORE) {
            return rsa.rimuoviUtente(cf);
        }
        throw new RuntimeException("Solo gli amministratori possono rimuovere le persone");
    }
    
    @Override
    public int creaCartellaClinica(CartellaClinica cc) {
        if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.AMMINISTRATORE) {
            return rsa.creaCartellaClinica(cc);
        }
        System.out.println("Solo gli amministratori possono creare la cartella clinica per un paziente");
        return -1;
    }

    @Override
    public boolean rimuoviCartellaClinica(String cf)	{
        if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.AMMINISTRATORE) {
            return rsa.rimuoviCartellaClinica(cf);
        }
        throw new RuntimeException("Solo gli amministratori possono rimuovere la cartella clinica per un paziente");
    }
	
    @Override
    public int creaTerapia(Terapia t)	{
    	if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.MEDICO) {
            return rsa.creaTerapia(t);
        }
        throw new RuntimeException("Solo i medici possono creare una terapia per un paziente");	
    }
    
    @Override
	public int creaMonitoraggio(Monitoraggio m)	{
    	if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.INFERMIERE) {
            return rsa.creaMonitoraggio(m);
        }
        throw new RuntimeException("Solo gli infermieri possono creare un monitoraggio per un paziente");	  
    }

	@Override
	public List<Monitoraggio> getMonitoraggiConAlertAttivo() {
		if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.MEDICO) {
            return rsa.getMonitoraggiConAlertAttivo();
        }
        throw new RuntimeException("Solo i medici possono visualizzare la lista di monitoraggi con alert attivo");	  
	}

	@Override
	public boolean risolviAlertMonitoraggio(Monitoraggio m) {
		if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.MEDICO) {
            return rsa.risolviAlertMonitoraggio(m);
        }
        throw new RuntimeException("Solo i medici possono contrassegnare un monitoraggio come risolto");	  
	}


    //MEDICO UNICO
    @Override
    public Monitoraggio cercaMonitoraggioById(int id)	{
        if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.MEDICO) {
            return rsa.cercaMonitoraggioById(id);
        }
        throw new RuntimeException("Solo i medici possono cercare un monitoraggio ");
    }
    

}
