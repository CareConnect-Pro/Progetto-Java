package it.unipv.posw.careconnectpro.model.rsa;


import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.visita.Visita;
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
    public boolean rimuoviUtente(Persona persona)	{
        if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.AMMINISTRATORE) {
            return rsa.rimuoviUtente(persona);
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
    public boolean creaVisita(Visita v) {
        if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.MEDICO) {
            return rsa.creaVisita(v);
        }
        System.out.println("Solo i medici possono programmare una visita per un paziente");
        return false;
    }
}
