import java.time.LocalDate;

import org.junit.Test;

import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.StatoTerapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.TipoSomministrazione;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.ProxyRSA;

public class TerapieTest {

	@Test
    public void insertionTest() {

        Dipendente med = new Dipendente("MED001CF", "Mario", "Rossi",
                LocalDate.of(1980, 1, 1), "m.rossi@care.it", "111",
                "Med001", TipoUtente.MEDICO, LocalDate.of(2020, 1, 10));

        Paziente paz = new Paziente("CFP005CF", "Chia", "Moretto",
                LocalDate.of(2020, 6, 20), "c.moretti@care.it", "202",
                "Paz006", TipoUtente.PAZIENTE, LocalDate.of(2023, 5, 20));

        Terapia terapia = new Terapia(null, paz, med, TipoSomministrazione.MEDICAZIONE,
                "Disinfettante", "Garze", "nessuno",
                2, StatoTerapia.PREVISTA, 2,
                LocalDate.of(2026, 1, 23), LocalDate.of(2026, 1, 24),
                "Dolori alla spalla destra");

        ProxyRSA proxyRSA = new ProxyRSA(med);
        proxyRSA.creaTerapia(terapia);

    }

}
