package it.unipv.posw.careconnectpro.controller.utenti.amministratore;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisattivaUtenteActionListener implements ActionListener {
    private IRSA model;

    public DisattivaUtenteActionListener(IRSA model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e){
//        String cf = (String) JOptionPane.showInputDialog(
//                null, "Inserisci codice fiscale dell'utente da disattivare: ",
//                "Disattiva Utente", JOptionPane.PLAIN_MESSAGE, null, null,"");
    	String cf = JOptionPane.showInputDialog(
                null, 
                "Inserisci codice fiscale dell'utente da disattivare:", 
                "Disattiva Utente", 
                JOptionPane.PLAIN_MESSAGE);


        if (cf != null) {

            if(model.disattivaUtente(cf)){
                PopUp.infoBox("Utente con CF: " + cf + " disabilitato con successo", "Disattiva Utente");
            } else{
                PopUp.infoBox("Errore, impossibile disattivare l'utente con CF: " + cf,  "Disattiva Utente");
            }
        }  else {
            PopUp.infoBox("CF non valido", "Disattiva Utente");
        }
    }

}
