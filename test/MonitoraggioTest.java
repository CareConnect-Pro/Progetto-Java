import java.time.LocalDate;

import org.junit.Test;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Alert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.TipiParametroVitale;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.ProxyRSA;

public class MonitoraggioTest {

	@Test
	public void test() {

        Dipendente inf = new Dipendente("INF001CF", "Gianna", "Bianchi",
                LocalDate.of(1990, 2, 10), "g.bianchi@care.it", "444",
                "Inf001", TipoUtente.INFERMIERE, LocalDate.of(2021, 3, 15));

        Paziente paz = new Paziente("CFP005CF", "Chia", "Moretto",
                LocalDate.of(2020, 6, 20), "c.moretti@care.it", "202",
                "Paz006", TipoUtente.PAZIENTE, LocalDate.of(2023, 5, 20));

        Monitoraggio monitoraggio = new Monitoraggio(null, paz, inf, TipiParametroVitale.PRESSIONE_ARTERIOSA,
                "170/90", LocalDate.of(2026, 1, 23), Alert.ATTIVO,
                "Paziente Agitata");

        ProxyRSA proxyRSA = new ProxyRSA(inf);
        proxyRSA.creaMonitoraggio(monitoraggio);
	}

}

