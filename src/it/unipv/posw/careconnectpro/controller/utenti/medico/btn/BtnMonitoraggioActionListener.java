package it.unipv.posw.careconnectpro.controller.utenti.medico.btn;

import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnMonitoraggioActionListener implements ActionListener {

    private ViewController view;

    public BtnMonitoraggioActionListener(ViewController view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getMedPanel().setVisible(false);
        view.getListMonitoraggioPanel().setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
