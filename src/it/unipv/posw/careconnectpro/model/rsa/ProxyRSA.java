package it.unipv.posw.careconnectpro.model.rsa;


import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.TipoDipendente;

public class ProxyRSA implements IResidenzaSanitariaAssistenziale {

    private final IResidenzaSanitariaAssistenziale rsa;
    private final Dipendente utenteLoggato;

    public ProxyRSA(Dipendente utenteLoggato, IResidenzaSanitariaAssistenziale rsa) {
        this.utenteLoggato = utenteLoggato;
        this.rsa = rsa;
    }

    @Override
    public boolean registrazioneDipendente(Dipendente dipendente) {
        if(utenteLoggato != null  && utenteLoggato.getTipoDipendente() == TipoDipendente.AMMINISTRATORE) {
            return rsa.registrazioneDipendente(dipendente);
        }
        throw new RuntimeException("Solo gli amministratori possono registrare nuovi dipendenti");
    }
    
    @Override
    public boolean rimuoviDipendente(String idDipendente)	{
        if(utenteLoggato != null  && utenteLoggato.getTipoDipendente() == TipoDipendente.AMMINISTRATORE) {
            return rsa.rimuoviDipendente(idDipendente);
        }
        throw new RuntimeException("Solo gli amministratori possono rimuovere i dipendenti");
    }

}
