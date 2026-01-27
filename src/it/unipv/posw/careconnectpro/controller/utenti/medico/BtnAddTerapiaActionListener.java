package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnAddTerapiaActionListener implements ActionListener {

    private ViewController view;
    private IRSA model;

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
        int rigaSelezionata = tabella.getSelectedRow();

        if (rigaSelezionata != -1) {
            int idCartella = (int) tabella.getValueAt(rigaSelezionata, 1);
            String idPaziente = (String) tabella.getValueAt(rigaSelezionata, 2);
            String idMedico = model.getUtenteLoggato().getCodiceFiscale();

            view.getTerapiaPanel().getIdCartellaField().setText(String.valueOf(idCartella));
            view.getTerapiaPanel().getIdPazienteField().setText(idPaziente);
            view.getTerapiaPanel().getIdMedicoField().setText(idMedico);
        }else {
            PopUp.infoBox("Seleziona una riga dalla tabella prima di procedere!", "Nessuna Selezione");
        }

    }

}
