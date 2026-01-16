package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class RSAService {
	
    private FacadeSingletonDB facadeDB;

    public RSAService() {
        facadeDB = FacadeSingletonDB.getIstanzaFacade();
    }
    
    public RSAService(FacadeSingletonDB facadeDB) {
        this.facadeDB = facadeDB;
    }
    
    public FacadeSingletonDB getFacadeDB() {
        return facadeDB;
    }
	
    
    public Dipendente login (String cf, String password) {
        Dipendente d = facadeDB.findDipendenteByCf(cf);
        if (d == null) return null;
        if (!d.getPassword().equals(password)) return null;
        return d;
    }

}
