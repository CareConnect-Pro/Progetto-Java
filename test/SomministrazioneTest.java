import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.StatoSomministrazione;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertTrue;

public class SomministrazioneTest {

    private FacadeSingletonDB facadeDB;
    private Somministrazione somministrazioneTest;

    @Before
    public void setUp() {
        facadeDB = FacadeSingletonDB.getIstanza();
 
        int idTerapiaEsistente = 1; 
        String cfPazienteEsistente = "PAZ001CF"; 
        String cfOperatoreEsistente = "MED001CF"; 
        
        somministrazioneTest = new Somministrazione(
                idTerapiaEsistente,
                cfPazienteEsistente,
                cfOperatoreEsistente,
                LocalDate.now(),
                LocalTime.now(),
                StatoSomministrazione.DA_SOMMINISTRARE,
                "Test di inserimento automatico da JUnit"
        );
    }

    @Test
    public void insertSomministrazioneTest() {
      
        int idGenerato = facadeDB.insertSomministrazione(somministrazioneTest);
        assertTrue("L'inserimento della somministrazione è fallito (ID non generato)", idGenerato > 0);
    }
}