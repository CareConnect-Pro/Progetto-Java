import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.rsa.ProxyRSA;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ProxyTest {
    private Dipendente amministratore, medico, dipendenteNuovo;

    @Before
    public void creaDipendenti(){
        amministratore = new Dipendente("RSSMRA80A01F205Z", "Mario", "Rossi",
                LocalDate.of(1980, 1, 1), "admin@test.it", "333111",
                "pass123", TipoUtente.AMMINISTRATORE, LocalDate.now());

        medico = new Dipendente("BNCGNN90A01F205X", "Gianni", "Bianchi",
                LocalDate.of(1990, 5, 20), "medico@test.it", "333222",
                 "pass123", TipoUtente.MEDICO, LocalDate.now());


        dipendenteNuovo = new Dipendente("VRDLUU00A01F205W", "Luca", "Verdi",
                LocalDate.of(2000, 10, 10), "luca@test.it", "333333",
                "pass123", TipoUtente.INFERMIERE, LocalDate.now());
    }


    @Test
    public void testInserimento(){
        ProxyRSA proxyRSA = ProxyRSA.getProxy();
        proxyRSA.setUtenteLoggato(amministratore);
        boolean risultato = proxyRSA.registraUtente(dipendenteNuovo);

        System.out.println("True: registrato con successo, False: registrazione fallita --> risulalto =  " + risultato);
    }

   @Test
    public void testInserimentoFallito(){
	   ProxyRSA proxyRSA = ProxyRSA.getProxy();
	   proxyRSA.setUtenteLoggato(medico);
	   boolean risultato = proxyRSA.registraUtente(dipendenteNuovo);
	   System.out.println("True: registrato con successo, False: registrazione fallita --> risulalto = " + risultato);
   }

}

