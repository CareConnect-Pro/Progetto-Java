package it.unipv.posw.careconnectpro.controller.utenti.amministratore;

import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnRegistraUtenteActionListener implements ActionListener {

    private ViewController view;
    public BtnRegistraUtenteActionListener(ViewController view) {
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getAmmPanel().setVisible(false);
        view.getRegUtentePanel().setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
