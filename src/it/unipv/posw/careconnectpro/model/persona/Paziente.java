package it.unipv.posw.careconnectpro.model.persona;

import it.unipv.posw.careconnectpro.model.parametri.diaro.DiarioParamentri;

import java.time.LocalDate;

public class Paziente extends Persona {

    private DiarioParamentri diarioParamentri;
    public Paziente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
                    String cellulare, String id, String password, LocalDate dataAssunzione) {
        super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, null, TipoUtente.PAZIENTE, dataAssunzione);

        diarioParamentri = new DiarioParamentri();

    }

    public DiarioParamentri getDiarioParamentri() {
        return diarioParamentri;
    }
    public void setDiarioParamentri(DiarioParamentri diarioParamentri) {
        this.diarioParamentri = diarioParamentri;
    }
}