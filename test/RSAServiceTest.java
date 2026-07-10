import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.rsa.amministratore.AmministratoreService;
import it.unipv.posw.careconnectpro.model.rsa.login.LoginService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class RSAServiceTest {

    private AmministratoreService amministratoreService;
    private LoginService loginService;
    private Paziente paziente;
    
    @Before
    public void setup(){
        amministratoreService = new AmministratoreService();
        loginService = new LoginService();
        paziente = new Paziente("CFTEST", "NOME", "COGNOME", LocalDate.of(1980, 6,22), "mail@test",
                                 "3291234567", LocalDate.now());
    }

    @Test
    public void registrazionePazienteCC(){
        boolean risultato = amministratoreService.registraUtente(paziente);

        assertTrue("Registrazione nel DB fallita", risultato);

        assertNotNull("La cartella clinica dovrebbe essere nel DB",
                FacadeSingletonDB.getIstanza().findCartellaClinicaByCf(paziente.getCodiceFiscale()));
    }

    @Test
    public void loginTest(){
        loginService.login("INF001CF", "Inf001");
    }

    @Test
    public void loginFallitoTest(){
        loginService.login("INF001CF", "Inf002");
    }
}