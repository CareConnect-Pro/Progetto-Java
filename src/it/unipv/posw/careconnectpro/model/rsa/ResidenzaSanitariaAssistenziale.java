package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class ResidenzaSanitariaAssistenziale implements IResidenzaSanitariaAssistenziale {

    private FacadeSingletonDB facadeDB;

    public ResidenzaSanitariaAssistenziale() {
        facadeDB = FacadeSingletonDB.getIstanzaFacade();
    }
    
    public ResidenzaSanitariaAssistenziale(FacadeSingletonDB facadeDB) {
        this.facadeDB = facadeDB;
    }

    
    @Override
    public boolean registrazioneDipendente(Dipendente d) {
        return facadeDB.insertDipendente(d);
    }
    
    @Override 
    public boolean rimuoviDipendente(String idDipendente) {
        return facadeDB.deleteDipendente(idDipendente);
    }
}
