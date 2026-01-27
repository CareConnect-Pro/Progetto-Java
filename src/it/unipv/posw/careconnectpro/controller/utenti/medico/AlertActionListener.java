package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertActionListener implements ActionListener {
    private IRSA model;

    public AlertActionListener(IRSA model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = (String) JOptionPane.showInputDialog(
                null, "Inserisci l'ID del monitoraggio da risolvere:",
                "Risolvi ALert", JOptionPane.PLAIN_MESSAGE, null, null, "");

        if (id != null) {
            int codice = Integer.parseInt(id);

            boolean check = false;
            Monitoraggio monitoraggio = model.cercaMonitoraggioById(codice) ;
            if (monitoraggio != null){
                model.risolviAlertMonitoraggio(monitoraggio);
                check = true;
            }
            if(check){
                PopUp.infoBox("Monitoraggio con ID: " + codice + " risolto con successo", "Risolvi ALert");
            } else{
                PopUp.infoBox("Errore nel risolvere il monitoraggio con ID:" + codice,  "Risolvi ALert");
            }
        }  else {
            PopUp.infoBox("ID non valido", "Risolvi ALert");
        }
    }



}

