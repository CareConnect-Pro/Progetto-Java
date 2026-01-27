package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertActionListener implements ActionListener {
    private IRSA model;
    private ViewController view;

    public AlertActionListener(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        String id = (String) JOptionPane.showInputDialog(
//                null, "Inserisci l'ID del monitoraggio da risolvere:",
//                "Risolvi ALert", JOptionPane.PLAIN_MESSAGE, null, null, "");
//
//        if (id != null) {
//            int codice = Integer.parseInt(id);
//
//            boolean check = false;
//            Monitoraggio monitoraggio = model.cercaMonitoraggioById(codice) ;
//            if (monitoraggio != null){
//                model.risolviAlertMonitoraggio(monitoraggio);
//                check = true;
//            }
//            if(check){
//                System.out.println("ID " + monitoraggio.getIdMonitoraggio());
//                System.out.println("Alert " + monitoraggio.getAlert().name());
//                PopUp.infoBox("Monitoraggio con ID: " + codice + " risolto con successo", "Risolvi ALert");
//            } else{
//                PopUp.infoBox("Errore nel risolvere il monitoraggio con ID:" + codice,  "Risolvi ALert");
//            }
//        }  else {
//            PopUp.infoBox("ID non valido", "Risolvi ALert");
//        }

        JTable tabella = view.getListMonitoraggioPanel().getMonitoraggiList();
        int rigaSelezionata = tabella.getSelectedRow();

        if (rigaSelezionata != -1) {
            int idMonitoraggio = (int) tabella.getValueAt(rigaSelezionata, 0);

            Monitoraggio monitoraggio = model.cercaMonitoraggioById(idMonitoraggio);

            if (monitoraggio != null) {
                boolean successo = model.risolviAlertMonitoraggio(monitoraggio);

                if (successo) {
                    PopUp.infoBox("Monitoraggio " + idMonitoraggio + " risolto nel database.", "Successo");

                } else {
                    PopUp.infoBox("Errore nell'aggiornamento del Database.", "Errore DB");
                }
            }
        } else {
            PopUp.infoBox("Seleziona una riga dalla tabella prima di procedere!", "Nessuna Selezione");
        }
    }


}




