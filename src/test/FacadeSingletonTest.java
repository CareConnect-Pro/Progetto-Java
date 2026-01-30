import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FacadeSingletonTest {
    private FacadeSingletonDB facadeDB;
    private Paziente pazienteTest;

    @Before
    public void setUp(){
        facadeDB = FacadeSingletonDB.getIstanza();
        pazienteTest= new Paziente("TestCF", "NomeT", "CognomeT",
                                    LocalDate.of(1999, 3,1), "mail@test","3121234567",
                        LocalDate.now());

    }

    @After
    public void tearDown(){
        facadeDB.deletePersona(pazienteTest);

    }

    @Test
    public void insertRicercaPaziente(){
        boolean risultato = facadeDB.insertPersona(pazienteTest);
        assertTrue("L'inserimento della persona non è avvenuto con successo",  risultato);

        Paziente recuperato = facadeDB.findPazienteByCf(pazienteTest.getCodiceFiscale());
        assertNotNull("Il paziente non è stato trovato", recuperato);
    }

    @Test
    public void creazioneCartellaClinica(){
        facadeDB.insertPersona(pazienteTest);
        CartellaClinica cartellaClinica = new CartellaClinica(pazienteTest);

        int idGenerato = facadeDB.insertCartellaClinica(cartellaClinica);
        assertTrue("ID con valore positivo", idGenerato > 0);

        CartellaClinica recuperata = facadeDB.findCartellaClinicaByCf(pazienteTest.getCodiceFiscale());
        assertNotNull("Cartella clinica non è statarecuperata", recuperata);
    }
}
