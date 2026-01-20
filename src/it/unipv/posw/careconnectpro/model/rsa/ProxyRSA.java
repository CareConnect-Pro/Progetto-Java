package it.unipv.posw.careconnectpro.model.rsa;


import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;

public class ProxyRSA implements IRSA {

    private final RSAService rsa;
    private final Dipendente utenteLoggato;

    public ProxyRSA(Dipendente utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
        this.rsa = new RSAService();
    }

    @Override
    public boolean registrazioneDipendente(Dipendente dipendente) {
        if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.AMMINISTRATORE) {
            return rsa.registrazioneDipendente(dipendente);
        }
        System.out.println("Solo gli amministratori possono registrare nuovi dipendenti");
        return false;
    }

    @Override
    public boolean rimuoviDipendente(String idDipendente)	{
        if(utenteLoggato != null  && utenteLoggato.getTipoUtente() == TipoUtente.AMMINISTRATORE) {
            return rsa.rimuoviDipendente(idDipendente);
        }
        throw new RuntimeException("Solo gli amministratori possono rimuovere i dipendenti");
    }
}
