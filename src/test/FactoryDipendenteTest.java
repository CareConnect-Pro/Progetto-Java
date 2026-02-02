package test;

import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.FactoryDipendente;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class FactoryDipendenteTest {

    @Test
    public void testFactoryDipendente() {
        Dipendente dipendente = FactoryDipendente.getDipendente("MEDICO", "CFTEST", "NOME",
                                "COGNOME", LocalDate.of(1998,4, 14), "medico@mail",
                                "3331234567", "password", LocalDate.now());

        assertNotNull("Il dipendente dovrebbe esiste", dipendente);
    }


}
