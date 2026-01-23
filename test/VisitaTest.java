import java.time.LocalDate;

import org.junit.Test;

import it.unipv.posw.careconnectpro.model.cartellaclinica.visita.EsitoVisita;
import it.unipv.posw.careconnectpro.model.cartellaclinica.visita.Visita;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.ProxyRSA;

public class VisitaTest {

	@Test
	public void test() {
        Dipendente med = new Dipendente("MED001CF", "Mario", "Rossi",
                LocalDate.of(1980, 1, 1), "m.rossi@care.it", "111",
                "Med001", TipoUtente.MEDICO, LocalDate.of(2020, 1, 10));

        Paziente paz = new Paziente("CFP005CF", "Chia", "Moretto",
                LocalDate.of(2020, 6, 20), "c.moretti@care.it", "202",
                "Paz006", TipoUtente.PAZIENTE, LocalDate.of(2023, 5, 20));

        Visita visita = new Visita(null, paz, med, LocalDate.of(2026, 1, 23),
                "Sospetta influenza", EsitoVisita.PREVISTA);
        
        ProxyRSA proxyRSA = new ProxyRSA(med);
        proxyRSA.creaVisita(visita);
	}

}
