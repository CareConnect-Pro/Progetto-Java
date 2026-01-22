import java.time.LocalDate;

import org.junit.Test;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.ProxyRSA;

public class CartellaClinicaTest {

//	@Test
//	public void insertionTest() {
//		Dipendente amm = new Dipendente("CF", "NOME", "COGNOME",
//				LocalDate.of(1990, 1, 1),
//				"EMAIL", "NUMERO", "PW", TipoUtente.AMMINISTRATORE,
//				LocalDate.of(2024, 9, 8));
//
//		Paziente paz = new Paziente("CFP005CF", "Chia", "Moretto",
//				LocalDate.of(2020, 6, 20),
//				"c.moretti@care.it", "202", "Paz006", "PAZIENTE",
//				LocalDate.of(2023, 5, 20));
//
//		CartellaClinica cc = new CartellaClinica(paz);
//
//		ProxyRSA proxyRSA = new ProxyRSA(amm);
//		proxyRSA.creaCartellaClinica(cc);
//
//	}

	@Test
	public void eliminationTest ()	{
		Dipendente amm = new Dipendente("CF", "NOME", "COGNOME",
				LocalDate.of(1990, 1, 1),
				"EMAIL", "NUMERO", "PW", TipoUtente.AMMINISTRATORE,
				LocalDate.of(2024, 9, 8));

		ProxyRSA proxyRSA = new ProxyRSA(amm);
		proxyRSA.rimuoviCartellaClinica("CFP005CF");

	}

}
