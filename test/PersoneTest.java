import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.ProxyRSA;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import org.junit.Test;

import java.time.LocalDate;

public class PersoneTest {

	@Test
	public void insertionTest(){
		Dipendente amm = new Dipendente("CF", "NOME", "COGNOME",
				LocalDate.of(1990, 1, 1),
				"EMAIL", "NUMERO", "PW", TipoUtente.AMMINISTRATORE,
				LocalDate.of(2024, 9, 8));

		Dipendente med = new Dipendente("CF1", "NOME", "COGNOME",
				LocalDate.of(1990, 1, 1),
				"EMAIL", "NUMERO", "PW", TipoUtente.MEDICO,
				LocalDate.of(2024, 9, 8));

		Dipendente inf = new Dipendente("CF2", "NOME", "COGNOME",
				LocalDate.of(1990, 1, 1),
				"EMAIL", "NUMERO", "PW", TipoUtente.INFERMIERE,
				LocalDate.of(2024, 9, 8));

		ProxyRSA proxyRSA = new ProxyRSA(amm);

		proxyRSA.registraUtente(med);
		proxyRSA.registraUtente(inf);

	}

	@Test
	public void eliminationTest(){
		Dipendente amm = new Dipendente("CF", "NOME", "COGNOME",
				LocalDate.of(1990, 1, 1),
				"EMAIL", "NUMERO", "PW", TipoUtente.AMMINISTRATORE,
				LocalDate.of(2024, 9, 8));

		Dipendente med = new Dipendente("CF1", "NOME", "COGNOME",
				LocalDate.of(1990, 1, 1),
				"EMAIL", "NUMERO", "PW", TipoUtente.MEDICO,
				LocalDate.of(2024, 9, 8));

		Dipendente inf = new Dipendente("CF2", "NOME", "COGNOME",
				LocalDate.of(1990, 1, 1),
				"EMAIL", "NUMERO", "PW", TipoUtente.INFERMIERE,
				LocalDate.of(2024, 9, 8));

		ProxyRSA proxyRSA = new ProxyRSA(amm);


		proxyRSA.rimuoviUtente(med);
		proxyRSA.rimuoviUtente(inf);

	}

	@Test
	public void loginTest(){

		RSAService rsaService = new RSAService();
		rsaService.login("VRLRRT85M20L219X", "NurPass2");
	}

	@Test
	public void loginFallitoTest(){
		RSAService rsaService = new RSAService();
		rsaService.login("VRLRRT85M20L219X", "NurPass1");
	}
}
