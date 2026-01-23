import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;

public class ListaMonitoraggiAttiviTest {

	public static void main(String[] args) {


		FacadeSingletonDB facade = FacadeSingletonDB.getIstanza();

		List<Monitoraggio> monitoraggiAttivi = facade.selectMonitoraggioByAlertAttivo();

		if (monitoraggiAttivi == null) {
			System.out.println("ERRORE: la lista dei monitoraggi con alert attivo è nulla!");
			return;
		}

		System.out.println("Lista dei monitoraggi con ALERT = ATTIVO:");

		boolean erroreAlert = false;

		for (Monitoraggio m : monitoraggiAttivi) {
			if (!"ATTIVO".equals(m.getAlert().name())) {
				System.out.println("ERRORE: trovato monitoraggio con ALERT non attivo! Paziente: " 
						+ m.getPaziente().getCodiceFiscale());
				erroreAlert = true;
			}

			// Stampa i dettagli del monitoraggio
			System.out.println(
					"Paziente: " + m.getPaziente().getCodiceFiscale() +
					", Infermiere: " + m.getInfermiere().getCodiceFiscale() +
					", Tipo Parametro: " + m.getTipiParametroVitale() +
					", Valore: " + m.getValore() +
					", Data: " + m.getDataMonitoraggio() +
					", Alert: " + m.getAlert() +
					", Note: " + m.getNote()
					);
		}

		// Controllo numero di monitoraggi
		int attesi = 5; 
		if (monitoraggiAttivi.size() != attesi) {
			System.out.println("ERRORE: numero di monitoraggi con alert attivo sbagliato! Attesi: "
					+ attesi + ", trovati: " + monitoraggiAttivi.size());
		} else if (!erroreAlert) {
			System.out.println("Test completato correttamente: tutti i monitoraggi hanno ALERT = ATTIVO e numero corretto (" + attesi + ").");
		}


	}

}
