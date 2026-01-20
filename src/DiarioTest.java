import org.junit.Test;

import it.unipv.posw.careconnectpro.model.parametri.diaro.DiarioParametri;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;

public class DiarioTest {

	@Test
	public void test() {
		DiarioParametri dp = new DiarioParametri("LNRMRA92S15H531T");
		RSAService rsa = new RSAService();
		rsa.registrazioneDiarioParametri(dp);
	}

}
