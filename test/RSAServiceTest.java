import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;



public class RSAServiceTest {

    private RSAService rsaService;
    private Paziente paziente;
    private FacadeSingletonDB facade;

    @Before
    public void setup(){
        rsaService = new RSAService();
        paziente = new Paziente("CFTEST", "NOME", "COGNOME", LocalDate.of(1980, 6,22), "mail@test",
                                 "3291234567", null ,LocalDate.now());

    }

    @After
    public void tearDown(){
        rsaService.rimuoviUtente(paziente);
    }

    @Test
    public void registrazionePazienteCC(){
        boolean risultato = rsaService.registraUtente(paziente);

        assertTrue("Registrazione nel DB fallita", risultato);

        assertNotNull("La cartella clinic dovrebbe essere  nel DB",
                rsaService.getFacadeDB().findCartellaClinicaByCf(paziente.getCodiceFiscale()));

    }

    @Test
    public void loginTest(){
        rsaService.login("INF001CF", "Inf001");
    }

    @Test
    public void loginFallitoTest(){
        rsaService.login("INF001CF", "Inf002");
    }



}
