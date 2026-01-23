import java.time.LocalDate;
import java.util.List;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Alert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.ProxyRSA;

public class RisoluzioneAlertTest {

    public static void main(String[] args) {

  
    	Dipendente med = new Dipendente("MED001CF", "Mario", "Rossi",
                LocalDate.of(1980, 1, 1), "m.rossi@care.it", "111",
                "Med001", TipoUtente.MEDICO, LocalDate.of(2020, 1, 10));
        

        ProxyRSA rsa = new ProxyRSA(med);

        // ===== RECUPERO ALERT ATTIVI =====
        List<Monitoraggio> lista = rsa.getMonitoraggiConAlertAttivo();

        if (lista.isEmpty()) {
            System.out.println("❌ Nessun monitoraggio con alert attivo trovato");
            return;
        }

        Monitoraggio m = lista.get(0);

        System.out.println("=== STATO INIZIALE ===");
        System.out.println("Alert: " + m.getAlert());

        // ===== AZIONE =====
        rsa.risolviAlertMonitoraggio(m);

        // ===== VERIFICA =====
        System.out.println("=== STATO DOPO RISOLUZIONE ===");
        System.out.println("Alert: " + m.getAlert());

        if (m.getAlert() == Alert.RISOLTO) {
            System.out.println("✅ TEST OK: alert risolto correttamente");
        } else {
            System.out.println("❌ TEST FALLITO: alert non risolto");
        }

        // ===== VERIFICA BLOCCO INFERMIERE =====
        try {
        	Dipendente inf = new Dipendente("INF001CF", "Gianna", "Bianchi",
                    LocalDate.of(1990, 2, 10), "g.bianchi@care.it", "444",
                    "Inf001", TipoUtente.INFERMIERE, LocalDate.of(2021, 3, 15));

            ProxyRSA rsaInfermiere = new ProxyRSA(inf);
            rsaInfermiere.risolviAlertMonitoraggio(m);

            System.out.println("❌ ERRORE: infermiere ha risolto l’alert");

        } catch (RuntimeException e) {
            System.out.println("✅ ACCESSO NEGATO CORRETTO: " + e.getMessage());
        }
    }
}
