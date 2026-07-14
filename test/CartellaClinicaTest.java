import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import org.junit.Before;
import  org.junit.Test;

import java.time.LocalDate;

public class CartellaClinicaTest {

    private Paziente paziente;

    @Before
    public void setUp() {
       
        String codiceFiscale = "BNCFRC85M10H501Z";
        String nome = "Francesco";
        String cognome = "Barbieri";

        
        LocalDate dataNascita = LocalDate.of(1985, 8, 10);
        LocalDate dataAssunzione = LocalDate.of(2023, 5, 15);
       
        String email = "f.barbieri85@provider.it";
        String cellulare = "3479876543";


       
        paziente = new Paziente(
                codiceFiscale,
                nome,
                cognome,
                dataNascita,
                email,
                cellulare,
                dataAssunzione
        );
    }

    @Test
    public void creazioneCartella(){
        new CartellaClinica(paziente);


    }



}

