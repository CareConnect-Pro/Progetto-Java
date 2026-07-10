package it.unipv.posw.careconnectpro.model.rsa.amministratore;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;

public class AmministratoreService implements IRSAAmministratore {

    private FacadeSingletonDB facadeDB = FacadeSingletonDB.getIstanza();

    
    @Override
    public boolean registraUtente(Persona p) {
        boolean nuovoUtente = facadeDB.insertPersona(p);
        if (!nuovoUtente) {
            System.out.println("Errore nell'inserimento dell'utente " + p.getCodiceFiscale());
            return false;
        }

        if (p.getTipoUtente() == TipoUtente.PAZIENTE) {
            CartellaClinica cc = new CartellaClinica(p);
            int idCC = facadeDB.insertCartellaClinica(cc);
            if (idCC <= 0) {
                throw new RuntimeException("Creazione cartella clinica fallita per il paziente " + p.getCodiceFiscale());
            }
            cc.setIdCartellaClinica(idCC);
        }
        System.out.println("Registrazione utente avvenuta con successo: " + p.getCodiceFiscale());
        return true;
    }

    
    @Override
    public boolean disattivaUtente(String cf) {

        if (cf == null) {
            System.out.println("Nessun codice fiscale inserito");
            return false;
        }

        Persona p = facadeDB.findPazienteByCf(cf);
        if (p == null) {
            p = facadeDB.findDipendenteByCf(cf);
        }

        if (p == null) {
            System.out.println("Utente non presente nel DB");
            return false;
        }

        boolean utenteDisattivato = facadeDB.deletePersona(p);
        if (!utenteDisattivato) {
            System.out.println("Errore nella rimozione dell'utente " + p.getCodiceFiscale());
            return false;
        }
        System.out.println("Rimozione utente avvenuta con successo: " + p.getCodiceFiscale());
        return true;
    }

    @Override
    public int creaCartellaClinica(CartellaClinica cc) {
        return facadeDB.insertCartellaClinica(cc);
    }
    
    @Override
    public Dipendente getUtenteLoggato() {
        return GestoreSessione.getIstanza().getUtenteLoggato();
    }
}