package it.unipv.posw.careconnectpro.model.persona.dipendente;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.util.Properties;

public class FactoryDipendente {

    public static final String FILE_PROPERTIES_DIPENDENTI = "properties/dipendenti.properties";

    public static Dipendente getDipendente(
            String tipo,
            String cf,
            String nome,
            String cognome,
            LocalDate nascita,
            String email,
            String cell,
            String pw,
            LocalDate assunzione) {

        String dipendenteClassName;

        try {
            Properties p = new Properties(System.getProperties());
            p.load(new FileInputStream(FILE_PROPERTIES_DIPENDENTI));
            dipendenteClassName = p.getProperty(tipo.toUpperCase());

            Constructor <?> c = Class.forName(dipendenteClassName).getConstructor(
                    String.class,
                    String.class,
                    String.class,
                    LocalDate.class,
                    String.class,
                    String.class,
                    String.class,
                    LocalDate.class
            );

            Dipendente dipendente = (Dipendente) c.newInstance(cf, nome, cognome, nascita, email, cell, pw, assunzione);
            return dipendente;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}