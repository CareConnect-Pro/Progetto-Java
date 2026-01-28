package it.unipv.posw.careconnectpro.controller.utenti.medico.button;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnAddTerapiaActionListener implements ActionListener {

    private ViewController view;
    private IRSA model;
    private int rigaSelezionata;

    public BtnAddTerapiaActionListener(IRSA model, ViewController view) {
        this.view = view;
        this.model = model;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.getLoginPanel().setVisible(false);
        view.getMedPanel().setVisible(false);
        view.getListMonitoraggioPanel().setVisible(false);
        view.getTerapiaPanel().setVisible(true);

        JTable tabella = view.getListMonitoraggioPanel().getMonitoraggiList();
        rigaSelezionata = tabella.getSelectedRow();

        if (rigaSelezionata != -1) {
            int idMonitoraggio = (int)tabella.getValueAt(rigaSelezionata, 0);
            int idCartella = (int) tabella.getValueAt(rigaSelezionata, 1);
            String idPaziente = (String) tabella.getValueAt(rigaSelezionata, 2);
            String idMedico = model.getUtenteLoggato().getCodiceFiscale();

            view.getTerapiaPanel().getIdCartellaField().setText(String.valueOf(idCartella));
            view.getTerapiaPanel().getIdPazienteField().setText(idPaziente);
            view.getTerapiaPanel().getIdMedicoField().setText(idMedico);
            view.getTerapiaPanel().getIdMonitoraggioField().setText(String.valueOf(idMonitoraggio));
        }else {
            PopUp.infoBox("Seleziona una riga dalla tabella prima di procedere!", "Nessuna Selezione");
        }

    }

    public int getRigaSelezionata() {
        return rigaSelezionata;
    }
}
