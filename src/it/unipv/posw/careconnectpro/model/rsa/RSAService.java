package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.parametri.diaro.DiarioParametri;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class RSAService implements IRSA {
	
    private final FacadeSingletonDB facadeDB;

    //Costruttori
    public RSAService() {
        facadeDB = FacadeSingletonDB.getIstanza();
    }
    public RSAService(FacadeSingletonDB facadeDB) {
        this.facadeDB = facadeDB;
    }

    //Metodi
    public FacadeSingletonDB getFacadeDB() {
        return facadeDB;
    }

    @Override
    public boolean registrazioneDipendente(Dipendente d) {
        System.out.println("registrazione Dipendente avvenuta con successo");
        return facadeDB.insertPersona(d);
    }
    @Override
    public boolean rimuoviDipendente(String cf) {
        System.out.println("eliminazione Dipendente avvenuta con successo");
        return facadeDB.deletePersona(cf);
    }

    public Dipendente login (String cf, String password) {
        Dipendente d = facadeDB.findDipendenteByCf(cf);
        if (d == null) return null;
        if (d.getPassword().equals(password)){
            System.out.println("Login Dipendente avvenuta con successo " + password);

            return d;
        }

        System.out.println("Password errata");
        return null;
    }
    
    public boolean registrazioneDiarioParametri(DiarioParametri dp) {
        System.out.println("registrazione Diario avvenuta con successo");
        return facadeDB.insertDiarioParametri(dp);
    }

//    public void nuovoMonitoraggio (String idMonitoraggio, Paziente paziente, Dipendente dipendente, ParametroVitale pv, String note) {
//        Monitoraggio nMonitoraggio = new Monitoraggio(idMonitoraggio, paziente, dipendente, pv, note);
//
//        paziente.getDiarioClinico().addMonitoraggio(nMonitoraggio);
//        System.out.println("Aggiunto monitoraggio a " + paziente.getNome() + " " + paziente.getCognome() +
//                            "al Diario:" + paziente.getDiarioClinico().getIdDiario());
//    }

}
