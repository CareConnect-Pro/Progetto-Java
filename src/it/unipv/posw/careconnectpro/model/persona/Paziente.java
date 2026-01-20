package it.unipv.posw.careconnectpro.model.persona;

import it.unipv.posw.careconnectpro.model.parametri.diaro.DiarioParametri;

import java.time.LocalDate;

public class Paziente extends Persona {

    private DiarioParametri diarioParametri;
    public Paziente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
                    String cellulare, String id, String password, LocalDate dataAssunzione) {
        super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, null, TipoUtente.PAZIENTE, dataAssunzione);

        diarioParametri = new DiarioParametri(codiceFiscale);

    }

    public DiarioParametri getDiarioParamentri() {
        return diarioParametri;
    }
    public void setDiarioParamentri(DiarioParametri diarioParamentri) {
        this.diarioParametri = diarioParamentri;
    }
}