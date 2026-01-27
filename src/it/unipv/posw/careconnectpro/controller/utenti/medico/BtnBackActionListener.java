package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnBackActionListener implements ActionListener {

    private ViewController view;

    public BtnBackActionListener(ViewController view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getListMonitoraggioPanel().setVisible(false);
        view.getMedPanel().setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
