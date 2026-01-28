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

        JTable tabella = view.getListMonitoraggioPanel().getMonitoraggiList();
        int rigaSelezionata = tabella.getSelectedRow();

        if (rigaSelezionata != -1) {
            int idMonitoraggio = (int) tabella.getValueAt(rigaSelezionata, 0);

            Monitoraggio monitoraggio = model.cercaMonitoraggioById(idMonitoraggio);

            if (monitoraggio != null) {
                boolean successo = model.risolviAlertMonitoraggio(monitoraggio);

                if (successo) {
                    view.getListMonitoraggioPanel().getMonitoraggiTable().rimuoviMonitoraggio(rigaSelezionata);
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




