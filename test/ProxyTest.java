import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.rsa.ProxyRSA;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ProxyTest {
    private Dipendente amministratore, medico, dipendenteNuovo;
    private Paziente pazienteNuovo;

    @Before
    public void creaUtente(){
        amministratore = new Dipendente("RSSMRA80A01F205Z", "Mario", "Rossi",
                LocalDate.of(1980, 1, 1), "admin@test.it", "333111",
                "pass123", TipoUtente.AMMINISTRATORE, LocalDate.now());

        medico = new Dipendente("BNCGNN90A01F205X", "Gianni", "Bianchi",
                LocalDate.of(1990, 5, 20), "medico@test.it", "333222",
                 "pass123", TipoUtente.MEDICO, LocalDate.now());


        dipendenteNuovo = new Dipendente("VRDLUU00A01F205W", "Luca", "Verdi",
                LocalDate.of(2000, 10, 10), "luca@test.it", "333333",
                "pass123", TipoUtente.INFERMIERE, LocalDate.now());
        
        pazienteNuovo = new Paziente("LLLFBL02", "Fabiola", "Lilla",
        					LocalDate.of(2002, 5, 3),"fabi@test.it","99999",
        					"paz1111",TipoUtente.PAZIENTE,LocalDate.now());
        
    }


//    @Test
//    public void connessione(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver trovato e caricato con successo!");
//        } catch (ClassNotFoundException e) {
//            System.err.println("Driver non trovato! Controlla il Classpath.");
//            e.printStackTrace();
//        }

//    }

//    @Test
//    public void testInserimento(){
//        ProxyRSA proxyRSA = new ProxyRSA(amministratore);
//        boolean r1 = proxyRSA.registraUtente(dipendenteNuovo);
//        boolean r2 = proxyRSA.registraUtente(pazienteNuovo);
//    }
//
//   @Test
//    public void testInserimentoFallito(){
//       ProxyRSA proxyRSA = new ProxyRSA(medico);
//       boolean risultato = proxyRSA.registraUtente(dipendenteNuovo);
//       System.out.println("True: registrato con successo, False: registrazione fallita --> risulalto = " + risultato);
//   }
//   
   @Test
   public void testRimozione(){
       ProxyRSA proxyRSA = new ProxyRSA(amministratore);
       boolean r1 = proxyRSA.rimuoviUtente(dipendenteNuovo);
       boolean r2 = proxyRSA.rimuoviUtente(pazienteNuovo);
   }

//  @Test
//   public void testRimozioneFallito(){
//      ProxyRSA proxyRSA = new ProxyRSA(medico);
//      boolean risultato = proxyRSA.rimuoviUtente(dipendenteNuovo);
//      System.out.println("True: rimosso con successo, False: rimozione fallita --> risulalto = " + risultato);
//  }
}

