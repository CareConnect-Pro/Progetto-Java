package it.unipv.posw.careconnectpro.controller.utenti.infermiere.button;

import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnBackHomeInfAL implements ActionListener {

    private ViewController view;

    public BtnBackHomeInfAL(ViewController view) {
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getGestionePazPanel().setVisible(false);
        view.getMonitoraggioPanel().setVisible(false);
        view.getInfPanel().setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
