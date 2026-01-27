package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnAddTerapiaActionListener implements ActionListener {

    private ViewController view;

    public BtnAddTerapiaActionListener(ViewController view) {
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.getLoginPanel().setVisible(false);
        view.getMedPanel().setVisible(false);
        view.getListMonitoraggioPanel().setVisible(false);

    }

}
