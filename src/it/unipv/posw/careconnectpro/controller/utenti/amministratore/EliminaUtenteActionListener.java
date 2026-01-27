package it.unipv.posw.careconnectpro.controller.utenti.amministratore;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminaUtenteActionListener implements ActionListener {
    private IRSA model;

    public EliminaUtenteActionListener(IRSA model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String cf = (String) JOptionPane.showInputDialog(
                null, "Inserisci codice fiscale del utente da rimuovere:",
                "Rimuovi Utente", JOptionPane.PLAIN_MESSAGE, null, null,"");

        if (cf != null) {

            if(model.rimuoviUtente(cf)){
                PopUp.infoBox("Utente con CF: " + cf + " rimosso con successo", "Rimuovi Utente");
            } else{
                PopUp.infoBox("Errore nel rimuovere l'utente con CF" + cf,  "Rimuovi Utente");
            }
        }  else {
            PopUp.infoBox("CF non valido", "Rimuovi Utente");
        }
    }

}
