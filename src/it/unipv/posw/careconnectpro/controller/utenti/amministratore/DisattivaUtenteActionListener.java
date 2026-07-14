package it.unipv.posw.careconnectpro.controller.utenti.amministratore;

import it.unipv.posw.careconnectpro.model.rsa.amministratore.ProxyAmministratore;
import it.unipv.posw.careconnectpro.view.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisattivaUtenteActionListener implements ActionListener {
  

    public DisattivaUtenteActionListener() { }

    @Override
    public void actionPerformed(ActionEvent e){
        String cf = JOptionPane.showInputDialog(
                null, 
                "Inserisci codice fiscale dell'utente da disattivare:", 
                "Disattiva Utente", 
                JOptionPane.PLAIN_MESSAGE);

        if (cf != null && !cf.trim().isEmpty()) {
            if(ProxyAmministratore.getProxy().disattivaUtente(cf)){
                PopUp.infoBox("Utente con CF: " + cf + " disabilitato con successo", "Disattiva Utente");
            } else{
                PopUp.infoBox("Errore, impossibile disattivare l'utente con CF: " + cf,  "Disattiva Utente");
            }
        } else {
            PopUp.infoBox("CF non valido", "Disattiva Utente");
        }
    }
}
