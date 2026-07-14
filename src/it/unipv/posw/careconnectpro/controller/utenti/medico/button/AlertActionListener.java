package it.unipv.posw.careconnectpro.controller.utenti.medico.button;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.rsa.medico.ProxyMedico;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertActionListener implements ActionListener {
    
    private ViewController view;

    public AlertActionListener(ViewController view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable tabella = view.getListMonitoraggioPanel().getMonitoraggiList();
        int rigaSelezionata = tabella.getSelectedRow();

        if (rigaSelezionata == -1) {
            PopUp.infoBox("Seleziona una riga dalla tabella prima di procedere!", "Nessuna Selezione");
        } else {
            int idMonitoraggio = (int) tabella.getValueAt(rigaSelezionata, 0);
            Monitoraggio monitoraggio = ProxyMedico.getProxy().cercaMonitoraggioById(idMonitoraggio);

            if (monitoraggio != null) {
                boolean successo = ProxyMedico.getProxy().risolviAlertMonitoraggio(monitoraggio);

                if (successo) {
                    view.getListMonitoraggioPanel().getMonitoraggiTable().rimuoviMonitoraggio(rigaSelezionata);
                    PopUp.infoBox("Monitoraggio " + idMonitoraggio + " risolto nel database.", "Successo");
                } else {
                    PopUp.infoBox("Errore nell'aggiornamento del Database.", "Errore DB");
                }
            }
        }
    }
}